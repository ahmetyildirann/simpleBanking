package com.ahmetyildiran.simpleBanking.general;

import com.ahmetyildiran.simpleBanking.model.BankAccount;
import lombok.Getter;

@Getter
public class CreditTransaction extends TransactionAbs{

    double amount;

    public CreditTransaction(double amount) {
        super("CreditTransaction");
        this.amount = amount;
    }

    @Override
    public void execute(BankAccount account) {
        double amount = getAmount();
        account.setBalance(account.getBalance() + amount);
    }

}
