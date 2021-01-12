package com.thread_count.app.guest_account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestAccountService {

    @Autowired
    final private GuestAccountRepo guestAccountRepo;

    public GuestAccountService(GuestAccountRepo guestAccountRepo) {
        this.guestAccountRepo = guestAccountRepo;
    }

    // Get All Guest Accounts
    public List<GuestAccount> getAllGuestAccounts() {
        if (guestAccountRepo.findAll().size() > 0) {
            return guestAccountRepo.findAll();
        } else {
            return new ArrayList<GuestAccount>();
        }
    }

    // Save A Guest Account
    public GuestAccount save(GuestAccount guestAccount) {
        return guestAccountRepo.save(guestAccount);
    }

    // Get Guest Account By Id
    public GuestAccount getGuestAccount(int id) {
        Optional<GuestAccount> optionalGuestAccount = guestAccountRepo.findById(id);
        if (optionalGuestAccount.isPresent()) {
            GuestAccount guestAccount = optionalGuestAccount.get();
            return guestAccount;
        } else {
            return null;
        }
    }

    // Delete Guest Account
    public void deleteGuestAccount(int id) {
        Optional<GuestAccount> optionalGuestAccount = guestAccountRepo.findById(id);
        if (optionalGuestAccount.isPresent()) {
            guestAccountRepo.delete(optionalGuestAccount.get());
        }
    }

    // Edit Guest Account
    public GuestAccount editGuestAccount(GuestAccount guestAccount) {
        Optional<GuestAccount> optionalGuestAccount = guestAccountRepo.findById(guestAccount.getId());
        if (optionalGuestAccount.isPresent()) {
            GuestAccount tempAccount = optionalGuestAccount.get();
            tempAccount.setId(guestAccount.getId());
            tempAccount.setEmail(guestAccount.getEmail());
            tempAccount.setPhoneNumber(guestAccount.getPhoneNumber());
            tempAccount.setFirstName(guestAccount.getFirstName());
            tempAccount.setMiddleName(guestAccount.getMiddleName());
            tempAccount.setLastName(guestAccount.getLastName());
            tempAccount = guestAccountRepo.save(tempAccount);
            return tempAccount;
        } else {
            guestAccount = guestAccountRepo.save(guestAccount);
            return guestAccount;
        }
    }
}
