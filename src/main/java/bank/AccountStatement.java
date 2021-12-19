package bank;

import java.math.BigInteger;

public class AccountStatement {
    private BigInteger amount;

    public AccountStatement(final BigInteger amount) {
        this.amount = amount;
    }

    public BigInteger getAmount() {
        return amount;
    }

}
