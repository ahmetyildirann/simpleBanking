package com.ahmetyildiran.simpleBanking.general;

import com.ahmetyildiran.simpleBanking.model.BankAccount;
import lombok.Getter;

@Getter
public class DebitTransaction extends TransactionAbs{
    private double amount;

    public DebitTransaction(double amount) {
        super("DebitTransaction");
        this.amount = amount;
    }

    @Override
    public void execute(BankAccount account) {
        double amount = getAmount();
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
        } else {
            throw new IllegalStateException("Yetersiz bakiye");
        }

    }
}
