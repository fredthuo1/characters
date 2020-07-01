package com.starwars.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity // Entity for person created
@Table(name = "PERSON" ) // Table annotated for database configuration
public class Person {
    @Id // Id for entity
    @Column( name = "PERSON_ID" ) // Column Annotation for person Id
    private long Id; // Instantiation of Person Id
    @Column( name = "NAME" ) // Column Annotation for person name
    private String Name; // Instantiation of Person Name
    @Column( name = "HEIGHT" ) // Column Annotation for person height
    private String height; // Instantiation of height
    @Column( name = "MASS" ) // Column Annotation for person weight
    private String mass; // Instantiation of mass
    @Column( name = "HAIR_COLOR" ) // Column Annotation for person hair color
    private String hair_color; // Instantiation of hair color
    @Column( name = "SKIN_COLOR" ) // Column Annotation for person skin color
    private String skin_color; // Instantiation of skin color
    @Column( name = "EYE_COLOR" ) // Column Annotation for person eye color
    private String eye_color; // Instantiation of eye color
    @Column( name = "BIRTH_YEAR" ) // Column Annotation for person birth year
    private String birth_year; // Instantiation of birth year
    @Column( name = "GENDER" ) // Column Annotation for person gender
    private String gender; // Instantiation of gender
    @Column( name = "HOMEWORLD" ) // Column Annotation for person home world
    private String homeworld; // Instantiation of homwworld
    @Column( name = "FILMS" ) // Column Annotation for person films
    private ArrayList films; // Instantiation of films
    @Column( name = "SPECIES" ) // Column Annotation for person species
    private ArrayList species; // Instantiation of species
    @Column( name = "VEHICLES" ) // Column Annotation for person vehicles
    private ArrayList vehicles; // Instantiation of vehicles
    @Column( name = "STARSHIPS" ) // Column Annotation for person starships
    private ArrayList starships; // Instantiation of starships
    @Column( name = "CREATED" ) // Column Annotation for person date created
    private String created; // Instantiation of date of creation
    @Column( name = "EDITED" ) // Column Annotation for person date edited
    private String edited; // Instantiation of edit information
    @Column( name = "URL" ) // Column Annotation for person url
    private String url; // Instantiation of page URL
    @Column( name = "MARITAL_STATUS" )
    private String maritalStatus;
    // Getters and Setters
    public long getId() {
        return Id;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public List getFilms() {
        return films;
    }

    public void setFilms(ArrayList films) {
        this.films = films;
    }

    public ArrayList getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList species) {
        this.species = species;
    }

    public ArrayList getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList vehicles) {
        this.vehicles = vehicles;
    }

    public ArrayList getStarships() {
        return starships;
    }

    public void setStarships(ArrayList starships) {
        this.starships = starships;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", height='" + height + '\'' +
                ", mass='" + mass + '\'' +
                ", hair_color='" + hair_color + '\'' +
                ", skin_color='" + skin_color + '\'' +
                ", eye_color='" + eye_color + '\'' +
                ", birth_year='" + birth_year + '\'' +
                ", gender='" + gender + '\'' +
                ", homeworld='" + homeworld + '\'' +
                ", films=" + films +
                ", species=" + species +
                ", vehicles=" + vehicles +
                ", starships=" + starships +
                ", created='" + created + '\'' +
                ", edited='" + edited + '\'' +
                ", url='" + url + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                '}';
    }
}
