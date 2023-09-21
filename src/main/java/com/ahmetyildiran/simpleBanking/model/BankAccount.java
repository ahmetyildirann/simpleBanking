package com.ahmetyildiran.simpleBanking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "acc_id")
    private Long id;

    @Column(name = "owner", length = 100, nullable = false)
    private String owner;

    @Column(name = "account_number", length = 100, nullable = false)
    private String accountNumber;

    @Column(name = "balance", length = 100, nullable = false)
    private double balance;

    @Column(name = "create_date", length = 100, nullable = false)
    private Date createDate;


    @OneToMany(mappedBy = "bankAccount")
    private List<Transaction> transactions;

}
