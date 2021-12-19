package bank;

import java.math.BigInteger;

public class Account {

    private BigInteger balance = BigInteger.ZERO;
    private AccountStatement statement;

    public Account() {

    }
    public Account(final BigInteger balance) {
        if (balance == null) return;
        this.balance = balance;

    }

    public BigInteger getBalance() {
        return balance;
    }

    public void depose(final BigInteger amount) {
         this.balance = this.balance.add(amount);
         this.statement = new AccountStatement(amount);
    }

    public void withdraw(final BigInteger amount) {
        this.balance = this.balance.subtract(amount);
    }

    public AccountStatement getAccountStatement() {
        return this.statement;
    }
}
