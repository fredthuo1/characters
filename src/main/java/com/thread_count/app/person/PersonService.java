package com.thread_count.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    final private PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    // Get all people
    public List<Person> getAllPeople() {
        if (personRepo.findAll().size() > 0) {
            return personRepo.findAll();
        } else {
            return new ArrayList<Person>();
        }
    }

    // Save person
    public Person save(Person person) {
        return personRepo.save(person);
    }

    // Get Person By Id
    public Person getPerson(int id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            return person;
        } else {
            return null;
        }
    }

    // Delete Person
    public void delete(int id) {
        Optional<Person> optionalPerson = personRepo.findById(id);
        if (optionalPerson.isPresent()) {
            personRepo.delete(optionalPerson.get());
        }
    }

    // Edit Person
    public Person editPerson(Person person) {
        Optional<Person> optionalPerson = personRepo.findById(person.getId());
        if (optionalPerson.isPresent()) {
            Person temp = optionalPerson.get();
            temp.setId(person.getId());
            temp.setFirstName(person.getFirstName());
            temp.setMiddleName(person.getMiddleName());
            temp.setLastName(person.getLastName());
            temp.setDateJoined(person.getDateJoined());
            temp.setCellPhone(person.getCellPhone());
            temp.setEmailAddress(person.getEmailAddress());
            temp.setBirthDate(person.getBirthDate());
            temp = personRepo.save(person);
            return temp;
        } else {
            person = personRepo.save(person);
            return person;
        }
    }
}
