package test;

import main.BankAccount;
import main.BankTransaction;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class TestBankTransaction {

    private BankAccount bankAccountSenderMock;
    private BankAccount bankAccountReceiverMock;

    private BankTransaction bankTransaction;

    @Before
    public void setUp(){

        bankAccountSenderMock = mock(BankAccount.class);
        bankAccountReceiverMock = mock(BankAccount.class);

    }

    @Test
    public void whenTransfer_thenSendMoneyToReceiverCalled(){

        bankTransaction = new BankTransaction(bankAccountSenderMock, bankAccountReceiverMock, 100);

        bankTransaction.transfer();

        verify(bankAccountReceiverMock, times(1)).deposit(100);
    }

    @Test
    public void whenTransfer_thenWithdrawMoneyFromSenderCalled(){

        bankTransaction = new BankTransaction(bankAccountSenderMock, bankAccountReceiverMock, 100);

        bankTransaction.transfer();

        verify(bankAccountSenderMock, times(1)).withdraw(100);
    }
}
