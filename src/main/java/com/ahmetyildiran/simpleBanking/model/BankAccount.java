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
    private Long id;
    private String owner;
    private String accountNumber;
    private double balance;
    private Date createDate;


    @OneToMany(mappedBy = "bankAccount")
    private List<Transaction> transactions;

}
