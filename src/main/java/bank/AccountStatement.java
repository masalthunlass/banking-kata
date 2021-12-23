package bank;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountStatement {

    private List<AccountOperation> operations = new ArrayList<>();


    public List<AccountOperation>  getOperations() {
        return operations;
    }

    public void addOperation(BigInteger amount, BigInteger balance,
                             LocalDate operationDate) {
        operations.add(new AccountOperation(amount,balance, operationDate));
    }

    record AccountOperation(BigInteger amount, BigInteger balance,
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
}
