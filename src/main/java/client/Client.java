package client;

import bank.Account;

import java.math.BigInteger;

public class Client {
    private final Account account;
    private final BankClock bankClock;

    public Client(final Account account,final  BankClock bankClock) {
        this.account = account;
        this.bankClock = bankClock;
    }

    public Account getAccount() {
        return account;
    }

    public void makeDeposit(final BigInteger amount) {
        this.account.depose(amount, bankClock.today());
    }

    public void makeWithdrawal(final BigInteger amount) {
        this.account.withdraw(amount, bankClock.today());
    }

    public String printStatement() {
        return this.account.printAccountStatement();
    }
}
