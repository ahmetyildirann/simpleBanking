package com.ahmetyildiran.simpleBanking.general;

import lombok.Getter;
import org.springframework.stereotype.Component;


@Getter
public class TransactionStatus {

    private String status;
    private String approvalCode;

    public TransactionStatus(String status, String approvalCode) {
        this.status = status;
        this.approvalCode = approvalCode;
    }
}
