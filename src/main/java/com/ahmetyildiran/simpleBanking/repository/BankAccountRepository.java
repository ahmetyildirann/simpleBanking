package com.ahmetyildiran.simpleBanking.repository;

import com.ahmetyildiran.simpleBanking.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {

    Optional<BankAccount> findByAccountNumber(String accountNumber);
}
