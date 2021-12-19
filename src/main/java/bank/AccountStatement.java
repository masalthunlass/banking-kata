package bank;

import java.math.BigInteger;

public class AccountStatement {
    private BigInteger amount;
    private BigInteger balance;

    public AccountStatement(BigInteger amount, BigInteger balance) {
        this.amount = amount;
        this.balance = balance;
    }


    public BigInteger getAmount() {
        return amount;
    }

    public BigInteger getBalance() {
        return this.balance;
    }
}
