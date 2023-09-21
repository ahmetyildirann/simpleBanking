package com.ahmetyildiran.simpleBanking.repository;

import com.ahmetyildiran.simpleBanking.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
