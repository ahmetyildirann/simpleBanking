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

    @Column(name = "type", length = 100, nullable = false)
    private String type;

    @Column(name = "date", length = 100, nullable = false)
    private Date date;

    @Column(name = "amount", length = 100, nullable = false)
    private double amount;

    @Column(name = "approval_code", length = 100, nullable = false)
    private String approvalCode;

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "acc_id", nullable = false)
    private BankAccount bankAccount;

}
