package main;

import java.util.List;

public class BankAccount {

    private int accountId;

    private int moneyAvailable;

    private List<BankTransaction> bankTransactions;

    public int getAccountId() {
        return accountId;
    }
    public BankAccount(int accountId) {
        this.accountId = accountId;
    }
    
    public int getMoneyAvailable() {
        return moneyAvailable;
    }

    public void deposit(int valueDeposited) {
        if (valueDeposited >= 0){
            moneyAvailable += valueDeposited;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void withdraw(int value) {
        if (moneyAvailable >= value && moneyAvailable > 0){
            moneyAvailable -= value;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void transfer(BankTransaction bankTransaction) {

        if (moneyAvailable >= bankTransaction.getAmount() && moneyAvailable > 0){
            bankTransaction.transfer();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
