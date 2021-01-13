package com.thread_count.app.register.seller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRegistrationRepo extends JpaRepository<SellerRegistration, Integer> {
}
