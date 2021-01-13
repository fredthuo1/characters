package com.thread_count.app.register.customer;

import com.thread_count.app.address.Address;
import com.thread_count.app.address.AddressService;
import com.thread_count.app.customer_account.CustomerAccount;
import com.thread_count.app.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerRegistrationService {
    @Autowired
    final private CustomerRegistrationRepo customerRegistrationRepo;

    public CustomerRegistrationService(CustomerRegistrationRepo customerRegistrationRepo) {
        this.customerRegistrationRepo = customerRegistrationRepo;
    }

    public CustomerAccount addCustomer(CustomerRegistration customerRegistration) {
        Date now  = new Date();
        Person person = new Person();
        person.setFirstName(customerRegistration.getFirstName());
        person.setMiddleName(customerRegistration.getMiddleName());
        person.setLastName(customerRegistration.getLastName());
        person.setDateJoined(now);
        person.setCellPhone(customerRegistration.getPhoneNumber());
        person.setEmailAddress(customerRegistration.getEmail());
        // Add Address
        // Birth date
        CustomerAccount customerAccount = new CustomerAccount();
        customerAccount.setPerson(person);
        customerAccount.setPassword(customerRegistration.getPassword());
        person.setCustomerAccount(customerAccount );
        return customerAccount;
    }

    public Address addAddress() {

    }
}
