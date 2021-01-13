package com.thread_count.app.customer_account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerAccount, Integer> {
}
