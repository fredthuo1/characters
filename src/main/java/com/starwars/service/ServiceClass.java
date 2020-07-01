package com.starwars.service;

import com.starwars.data.entity.Person;
import com.starwars.data.repository.PersonRepository;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import net.minidev.json.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service // Service class to handle/Implement most methods in repository
public class ServiceClass  {

    private final PersonRepository personRepository; // Instantiate repository

    @Autowired
    public ServiceClass(PersonRepository personRepository) {
        this.personRepository = personRepository;
    } // Repository Constructor


    public List<Person> findAll() { // Method to get all people from database
        List<Person> persons = personRepository.findAll(); // Get method from repository to implement
        List<Person> personList = new ArrayList<>();  // Create arrayList to put people
        persons.forEach(person -> personList.add(person)); // Add people to arrayList
        return personList; // Return arrayList of people
    }


    public AtomicReference<Person> findByName(String name ) { // <Method to find person by name
        List<Person> people = personRepository.findAll(); // Get method to implement from repository
        AtomicReference<Person> person = new AtomicReference<>(new Person()); // Create person object
        for ( int i = 0; i <= people.size(); i++ ) { // Loop through the list of all people to find one with matching name
            people.forEach(person1 -> {
                if ( person1.getName().toLowerCase().equals(name.toLowerCase())) { // Make data from database and name from use lowercase in order to compare without worrying about case difference since java is case sensitive
                    person.set(person1); // Return person if found
                }
            });
        }
        return person;
    }

    public String getHomeWorld(String homeworld) throws IOException, ParseException { // Method to get homeworld link and get name of homeworld
        URL url = new URL(homeworld + "?format=json"); // Get Url string
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // Open Url connection
        InputStream inputStream = httpURLConnection.getInputStream(); // Get input stream
        StringBuffer stringBuffer = new StringBuffer(); // Instantiate String buffer
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        JSONObject jsonObject = new JSONObject(); // Create Json Object
        jsonObject = (JSONObject) JSONValue.parseWithException(bufferedReader); // Assign homeworld data to json Object
        homeworld = String.valueOf(jsonObject.get("name")); // Get homeworld name
        return homeworld; // Return name
    }

    public String getFilmName(String filmUrl) throws IOException, ParseException { // Method to get film name that character is in
        String film = ""; // Create film string
        URL url = new URL(filmUrl + "?format=json"); // Get film url
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // Open connection
        InputStream inputStream = httpURLConnection.getInputStream(); // Get input stream
        StringBuffer stringBuffer = new StringBuffer(); // Create String buffer
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        JSONObject jsonObject = new JSONObject(); // Create Json Object
        jsonObject = (JSONObject) JSONValue.parseWithException(bufferedReader); // Parse Json Object
        film = String.valueOf(jsonObject.get("title")); // Get the title of film

        return film; // Return film title
    }

    // Same thing done for film above but this methos gets species information
    public String getSpecies(String speciesUrl) throws IOException, ParseException {
        String species = "";
        URL url = new URL(speciesUrl + "?format=json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        JSONObject jsonObject = new JSONObject();
        jsonObject = (JSONObject) JSONValue.parseWithException(bufferedReader);
        species = String.valueOf(jsonObject.get("name"));
        return species;
    }

    // Same thing we did for film but this return vehicle infomation
    public String getVehicles(String vehiclesUrl) throws IOException, ParseException {
        String vehicles = "";
        URL url = new URL(vehiclesUrl + "?format=json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        JSONObject jsonObject = new JSONObject();
        jsonObject = (JSONObject) JSONValue.parseWithException(bufferedReader);
        vehicles = String.valueOf(jsonObject.get("name")); //Change to necessary parameter
        return vehicles;
    }

    // Same thing done to film but this one returns starship flown by person information
    public String getStarShip(String starchipsUrl) throws IOException, ParseException {
        String starship = "";
        URL url = new URL(starchipsUrl + "?format=json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        JSONObject jsonObject = new JSONObject();
        jsonObject = (JSONObject) JSONValue.parseWithException(bufferedReader);
        starship = String.valueOf(jsonObject.get("name")); //Change to necessary parameter
        return starship;
    }
}
