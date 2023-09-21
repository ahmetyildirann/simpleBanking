package com.ahmetyildiran.simpleBanking.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class TransactionDto {
    private String type;
    private Date date;
    private double amount;
    private String approvalCode;

}
