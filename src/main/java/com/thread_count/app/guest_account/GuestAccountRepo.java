package com.thread_count.app.guest_account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestAccountRepo extends JpaRepository<GuestAccount, Integer> {
}
