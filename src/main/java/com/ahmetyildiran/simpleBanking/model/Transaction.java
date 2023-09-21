package com.ahmetyildiran.simpleBanking.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Date date;
    private double amount;
    private String approvalCode;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private BankAccount bankAccount;

}
