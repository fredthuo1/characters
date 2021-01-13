package com.thread_count.app.register.seller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerRegistrationService {
    @Autowired
    final private SellerRegistrationRepo sellerRegistrationRepo;

    public SellerRegistrationService(SellerRegistrationRepo sellerRegistrationRepo) {
        this.sellerRegistrationRepo = sellerRegistrationRepo;
    }
}
