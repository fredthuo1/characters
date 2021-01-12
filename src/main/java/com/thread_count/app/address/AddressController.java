package com.thread_count.app.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    final private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/getAddresses", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<Address> addresses() {
        return (ArrayList<Address>) addressService.getAllAddresses();
    }

    @RequestMapping( value = "/addAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Address> addAddress(@RequestBody Address address ) {
        addressService.save(address);
        return new ResponseEntity<Address>(address, HttpStatus.CREATED);
    }

    // Delete Address
    @RequestMapping( value = "/deleteAddress", method = { RequestMethod.POST, RequestMethod.GET })
    public void deleteAddress(@RequestParam int id){
        addressService.delete(id);
    }

    // Get Address
    @RequestMapping( value = "/getAddress", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Address> getAddress(@RequestParam int id ) {
        Address address = addressService.getAddress(id);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }

    // Edit person Info
    @RequestMapping( value = "/updateAddress", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Address> editAddressInfo( @RequestBody Address address ){
        addressService.editAddress(address);
        return new ResponseEntity<Address>(address, HttpStatus.OK);
    }
}
