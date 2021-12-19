package bank;

import java.math.BigInteger;
import java.time.LocalDate;

public record AccountStatement(BigInteger amount, BigInteger balance,
                               LocalDate operationDate) {

    public BigInteger getAmount() {
        return amount;
    }

    public BigInteger getBalance() {
        return this.balance;
    }

    public LocalDate getOperationDate() {
        return this.operationDate;
    }
}
