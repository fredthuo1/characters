package com.thread_count.app.guest_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GuestAccountController {

    @Autowired
    final private GuestAccountService guestAccountService;

    public GuestAccountController(GuestAccountService guestAccountService) {
        this.guestAccountService = guestAccountService;
    }

    @RequestMapping(value = "/getGuestAccounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<GuestAccount> guestAccountList() {
        return (ArrayList<GuestAccount>) guestAccountService.getAllGuestAccounts();
    }

    @RequestMapping(value = "addGuestAccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<GuestAccount> addGuestAccount(@RequestBody GuestAccount guestAccount) {
        guestAccountService.save(guestAccount);
        return new ResponseEntity<GuestAccount>(guestAccount, HttpStatus.CREATED);
    }

    // Delete Address
    @RequestMapping(value = "deleteGuestAccount", method = { RequestMethod.GET, RequestMethod.POST})
    public void deleteGuestAccount(@RequestParam int id) {
        guestAccountService.deleteGuestAccount(id);
    }

    // Get Guest Account
    @RequestMapping( value = "/getGuestAccount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuestAccount> getGuestAccount(@RequestParam int id) {
        GuestAccount guestAccount = guestAccountService.getGuestAccount(id);
        return new ResponseEntity<GuestAccount>(guestAccount, HttpStatus.OK);
    }

    // Edit Guest Account
    @RequestMapping( value = "/updateGuestAccount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuestAccount> editGuestAccount(@RequestBody GuestAccount guestAccount) {
        guestAccountService.editGuestAccount(guestAccount);
        return new ResponseEntity<GuestAccount>(guestAccount, HttpStatus.OK);
    }
}
