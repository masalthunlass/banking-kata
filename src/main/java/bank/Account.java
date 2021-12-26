package bank;

import java.math.BigInteger;
import java.time.LocalDate;

public class Account {

    private BigInteger balance = BigInteger.ZERO;
    private final AccountStatement statement = new AccountStatement();

    public Account() {    }

    public Account(final BigInteger balance) {
        if (balance == null) return;
        this.balance = balance;

    }

    public BigInteger getBalance() {
        return balance;
    }

    public void depose(final BigInteger amount, LocalDate operationDate) {
        this.balance = this.balance.add(amount);
        statement.addDepositOperation(amount, this.balance, operationDate);
    }

    public void withdraw(final BigInteger amount, LocalDate operationDate) {
        this.balance = this.balance.subtract(amount);
        statement.addWithdrawOperation(amount,this.balance, operationDate);
    }

     AccountStatement getAccountStatement() {
        return this.statement;
    }

    public String printAccountStatement() {
        return this.getAccountStatement().print();
    }
}
