package com.ahmetyildiran.simpleBanking.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BankAccountDto {


    private Long id;
    private String owner;
    private String accountNumber;
    private double balance;
    private Date createDate;
    private List<TransactionDto> transactionDtoList;


}
