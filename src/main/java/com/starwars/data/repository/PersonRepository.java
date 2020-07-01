package com.starwars.data.repository;

import com.starwars.data.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository // Repository Class extends JPaRepository
public interface PersonRepository extends JpaRepository<Person, Long > {

}
