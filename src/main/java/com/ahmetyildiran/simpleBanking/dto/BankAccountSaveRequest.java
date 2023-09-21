package com.ahmetyildiran.simpleBanking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountSaveRequest {
    private String owner;
    private String accountNumber;

}
