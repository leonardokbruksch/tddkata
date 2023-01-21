package test;

import main.BankAccount;
import main.BankTransaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.*;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestBankAccount {

    private BankAccount bankAccount;

    private BankTransaction bankTransactionMock;

    @Before
    public void setUp(){
        bankAccount = new BankAccount(1);
        bankTransactionMock = mock(BankTransaction.class);
    }

    @Test
    public void testBankAccountId(){
        Assert.assertEquals(1,bankAccount.getAccountId());
    }

    @Test
    public void whenDepositMoney_ThenMoneySummed(){
        bankAccount.deposit(10);
        Assert.assertEquals(10, bankAccount.getMoneyAvailable());
    }

    @Test
    public void whenDepositNegative_ThenThrowException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-10));
    }

    @Test
    public void whenWithdrawMoney_ThenMoneySubtracted(){
        bankAccount.deposit(100);
        bankAccount.withdraw(100);
        Assert.assertEquals(0, bankAccount.getMoneyAvailable());
    }

    @Test
    public void whenTryWithdrawWithoutMoney_ThenThrowException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(10));
    }

    @Test
    public void whenTryWithdrawNegativeValue_ThenThrowException(){
        Assert.assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(-10));
    }

    @Test
    public void whenTransferAvailableMoney_ThenBankAccountCalled(){

        bankAccount.deposit(100);

        when(bankTransactionMock.getAmount()).thenReturn(100);

        bankAccount.transfer(bankTransactionMock);

        verify(bankTransactionMock, times(1)).transfer();
    }

    @Test
    public void whenTransferWithoutMoney_ThenThrowException(){

        when(bankTransactionMock.getAmount()).thenReturn(100);

        Assert.assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(bankTransactionMock));

    }

    @Test
    public void whenTransferNegativeMoney_ThenThrowException(){

        when(bankTransactionMock.getAmount()).thenReturn(-20);

        Assert.assertThrows(IllegalArgumentException.class, () -> bankAccount.transfer(bankTransactionMock));

    }

}
