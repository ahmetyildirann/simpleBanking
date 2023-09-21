package com.ahmetyildiran.simpleBanking.general;

import com.ahmetyildiran.simpleBanking.model.BankAccount;


public abstract class TransactionAbs {
    private String transactionType;

    public TransactionAbs(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }
    public abstract void execute(BankAccount account);
}
