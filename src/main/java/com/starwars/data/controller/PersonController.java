package com.starwars.data.controller;

// Imports
import com.starwars.data.entity.Person;
import com.starwars.data.repository.PersonRepository;
import com.starwars.service.ServiceClass;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@RestController // Instantiation of controller for application to scan object on start up
public class PersonController  {

    @Autowired
    private PersonRepository personRepository; // Calling repository to get methods

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    } // Constructor for repository

    @Autowired
    private ServiceClass serviceClass; // Calling and instantiating service class

    @CrossOrigin(origins = "http://localhost:3000") // Give access to multiple platforms and applications like react front end
   @RequestMapping( value = "/main", method = RequestMethod.GET ) // Make method a get method so that it can be accessed by data
        public <S extends Person> S save(S s) { // Get date to database from SWAPI api
        ArrayList<Person> people = new ArrayList<>(); // Create arrayList to hold list of people
        for ( int i = 0; i < 88; i++ ){ // Iterate through list of people
            URL url = null; // Instantiate URL
            try {
                url = new URL("https://swapi.co/api/people/" + i + "/?format=json" ); // Sorround with try catch method in order to prevent exceptions from breaking the app
            } catch ( MalformedURLException e ) {
                e.printStackTrace();
            }
            HttpURLConnection http = null;
            try {
                http = (HttpURLConnection) url.openConnection(); // Open url connection
            } catch ( IOException e ) {
                e.printStackTrace();
            }

            try {
                if ( http.getResponseCode() == 200 ) {
                    InputStream inputStream = http.getInputStream(); // Get input stream
                    StringBuffer sb = new StringBuffer(); // Instantiate String Buffer
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); // Instantiate buffer reader

                    JSONObject jsonObject = new JSONObject(); // Create Json object
                    jsonObject = (JSONObject) JSONValue.parseWithException(br); // Assign data to json Object

                    // Save data to database
                    s.setId(i);
                    s.setName(String.valueOf(jsonObject.get("name")));
                    s.setHeight(String.valueOf(jsonObject.get("height")));
                    s.setMass(String.valueOf(jsonObject.get("mass")));
                    s.setHair_color(String.valueOf(jsonObject.get("hair_color")));
                    s.setSkin_color(String.valueOf(jsonObject.get("skin_color")));
                    s.setEye_color(String.valueOf(jsonObject.get("eye_color")));
                    s.setBirth_year(String.valueOf(jsonObject.get("birth_year")));
                    s.setGender(String.valueOf(jsonObject.get("gender")));
                    s.setHomeworld(String.valueOf(serviceClass.getHomeWorld(String.valueOf(jsonObject.get("homeworld")))));

                    JSONArray filmsArray = new JSONArray();
                    filmsArray = (JSONArray) jsonObject.get("films");
                    ArrayList arrayLists = new ArrayList();
                    for (int a = 0; a <= filmsArray.size() - 1; a++) {
                        String filmUrl = String.valueOf(filmsArray.get(a));
                        arrayLists.add(serviceClass.getFilmName(filmUrl));
                    }
                    s.setFilms(arrayLists);

                    JSONArray species = new JSONArray();
                    species = (JSONArray) jsonObject.get("species");
                    ArrayList speciesList = new ArrayList();
                    for (int b = 0; b <= species.size() - 1; b++) {
                        String speciesUrl = String.valueOf(species.get(b));
                        speciesList.add(serviceClass.getSpecies(speciesUrl)); // Use method in service class to get the data in the api link
                    }
                    s.setSpecies(speciesList);

                    JSONArray vehicles = new JSONArray();
                    vehicles = (JSONArray) jsonObject.get("vehicles");
                    ArrayList vehiclesList = new ArrayList();
                    for (int c = 0; c <= vehicles.size() - 1; c++) {
                        String vehiclesUrl = String.valueOf(vehicles.get(c));
                        vehiclesList.add(serviceClass.getVehicles(vehiclesUrl));
                    }
                    s.setVehicles(vehiclesList);

                    JSONArray starships = new JSONArray();
                    starships = (JSONArray) jsonObject.get("starships");
                    ArrayList starshipsList = new ArrayList();
                    for (int d = 0; d <= starships.size() - 1; d++) {
                        String starchipsUrl = String.valueOf(starships.get(d));
                        starshipsList.add(serviceClass.getStarShip(starchipsUrl));
                    }
                    s.setStarships(starshipsList);

                    s.setCreated(String.valueOf(jsonObject.get("created")));
                    s.setEdited(String.valueOf(jsonObject.get("edited")));
                    s.setUrl(String.valueOf(jsonObject.get("url")));
                    people.add(s); // Add person to people array
                    personRepository.save(s); // Save person to database
                    System.out.println(s);
                }
            } catch ( IOException e ) {
                e.printStackTrace();
            } catch ( ParseException e ) {
                e.printStackTrace();
            }
        }

        return null; // Don't need to return anything for this method
    }

    @CrossOrigin(origins = "http://localhost:3000") // Make method cross origin
    @RequestMapping( value = "/person", method = RequestMethod.GET ) // Make it a get method
    public List<Person> getAllPeople() { // Get a list of all the people and their information
        return serviceClass.findAll(); // Use method in service class to get a list of all people
    }

    @CrossOrigin(origins = "http://localhost:3000") // Make method cross origin
    @RequestMapping( value = "findByName", method = RequestMethod.GET ) // Make method a get method
    public AtomicReference<Person> getPerson(@RequestParam String name) { // Make it a person object reference and get name to find in database
        return serviceClass.findByName(name); // Return person object
    }


}
