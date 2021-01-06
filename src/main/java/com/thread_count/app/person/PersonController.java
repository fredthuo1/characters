package com.thread_count.app.person;

import com.thread_count.app.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    final private PersonService personService;

    public PersonController(PersonService personService, AddressService addressService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> people() {
        return personService.getAllPeople();
    }

    @RequestMapping( value = "/addPerson", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Person> addPerson(@RequestBody Person person ) {
        personService.save(person);
        return new ResponseEntity<Person>(person, HttpStatus.CREATED);
    }

    // Delete user
    @RequestMapping( value = "/deletePerson", method = { RequestMethod.POST, RequestMethod.GET })
    public void deletePerson(@RequestParam int id){
        personService.delete(id);
    }

    // Get Person
    @RequestMapping( value = "/getPerson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Person> getUserProfile(@RequestParam int id ) {
        Person person = personService.getPerson(id);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    // Edit person Info
    @RequestMapping( value = "/updatePersonInfo", method = { RequestMethod.POST, RequestMethod.GET })
    public ResponseEntity<Person> editPersonInfo( @RequestBody Person person ){
        personService.editPerson(person);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }
}
