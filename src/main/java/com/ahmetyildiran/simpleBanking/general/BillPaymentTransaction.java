package com.ahmetyildiran.simpleBanking.general;

import com.ahmetyildiran.simpleBanking.model.BankAccount;
import lombok.Getter;

@Getter
public class BillPaymentTransaction extends TransactionAbs{
    private double amount;
    private String billName;

    public BillPaymentTransaction(double amount, String billName) {
        super(billName);
        this.amount = amount;
        this.billName = billName;
    }

    @Override
    public void execute(BankAccount account) {
        double currentBalance = account.getBalance();
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            account.setBalance(newBalance);
        } else {
            throw new IllegalStateException("Yetersiz bakiye");
        }
    }


}
