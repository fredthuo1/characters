package com.thread_count.app.register.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegistrationRepo extends JpaRepository<CustomerRegistration, Integer> {
}
