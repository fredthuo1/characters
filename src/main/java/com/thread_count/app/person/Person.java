package com.thread_count.app.person;

import com.thread_count.app.address.Address;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "PERSON" )
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private int Id;
    @Column( name = "FIRST_NAME" )
    private String firstName;
    @Column( name = "MIDDLE_NAME" )
    private String middleName;
    @Column( name = "LAST_NAME" )
    private String lastName;
    @Column( name = "DATE_JOINED" )
    private Date dateJoined;
    @Column( name = "CELLPHONE" )
    private String cellPhone;
    @Column( name = "EMAIL_ADDRESS" )
    private String emailAddress;
    @Column( name = "BIRTH_DATE" )
    private Date birthDate;
    @ManyToMany
    @JoinTable(
            name = "people_addresses",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    Set<Address> addresses;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateJoined=" + dateJoined +
                ", cellPhone='" + cellPhone + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", birthDate=" + birthDate +
                ", addresses=" + addresses +
                '}';
    }
}
