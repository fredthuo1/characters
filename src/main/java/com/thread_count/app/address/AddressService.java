package com.thread_count.app.address;

import com.thread_count.app.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    final private AddressRepo addressRepo;

    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    // Get all addresses
    public List<Address> getAllAddresses() {
        if (addressRepo.findAll().size() > 0) {
            return addressRepo.findAll();
        } else {
            return new ArrayList<Address>();
        }
    }

    // Save address
    public Address save(Address address) {
        return addressRepo.save(address);
    }

    // Get Address By Id
    public Address getAddress(int id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            Address address = optionalAddress.get();
            return address;
        } else {
            return null;
        }
    }

    // Delete Address
    public void delete(int id) {
        Optional<Address> optionalAddress = addressRepo.findById(id);
        if (optionalAddress.isPresent()) {
            addressRepo.delete(optionalAddress.get());
        }
    }

    // Edit Address
    public Address editAddress(Address address) {
        Optional<Address> optionalAddress = addressRepo.findById(address.getId());
        if (optionalAddress.isPresent()) {
            Address temp = optionalAddress.get();
            temp.setId(address.getId());
            temp.setStreet(address.getStreet());
            temp.setCity(address.getCity());
            temp.setState(address.getState());
            temp.setZipCode(address.getZipCode());
            temp.setCountry(address.getCountry());
            temp.setPeople(address.getPeople());
            temp = addressRepo.saveAndFlush(address);
            return temp;
        } else {
            address = addressRepo.save(address);
            return address;
        }
    }
}
