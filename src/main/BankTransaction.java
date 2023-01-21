package main;

public class BankTransaction {

    private BankAccount sender;
    private BankAccount receiver;
    private int amount;


    public BankTransaction(BankAccount sender, BankAccount receiver, int amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public void transfer() {
        sendMoneyToReceiver();
        removeMoneyFromSender();
    }

    private void removeMoneyFromSender() {
        //receiver.withdraw(0);
    }

    private void sendMoneyToReceiver() {
        //receiver.deposit(0);
        //trocar por amount apos testes
    }

    public BankAccount getSender() {
        return sender;
    }

    public BankAccount getReceiver() {
        return receiver;
    }

    public int getAmount() {
        return amount;
    }

}
