package bank;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AccountStatement {

    private final List<AccountOperation> operations = new ArrayList<>();


    public List<AccountOperation> getOperations() {
        return operations;
    }

    public void addDepositOperation(BigInteger amount, BigInteger balance,
                                    LocalDate operationDate) {
        operations.add(new DepositOperation(amount, balance, operationDate));
    }

    public void addWithdrawOperation(BigInteger amount, BigInteger balance,
                                     LocalDate operationDate) {
        operations.add(new WithdrawOperation(amount, balance, operationDate));
    }

    public String print() {
        return String.join(System.lineSeparator(),"date|amount|balance",
                this.operations.stream().map(AccountOperation::toString)
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    public abstract static class AccountOperation {
        final BigInteger amount;
        final BigInteger balance;
        final LocalDate operationDate;

        public AccountOperation(BigInteger amount, BigInteger balance, LocalDate operationDate) {
            if (amount == null || balance == null || operationDate == null) throw new  IllegalArgumentException();
            this.amount = amount;
            this.balance = balance;
            this.operationDate = operationDate;
        }

        public BigInteger getAmount() {
            return amount;
        }

        public BigInteger getBalance() {
            return this.balance;
        }

        public LocalDate getOperationDate() {
            return this.operationDate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AccountOperation that = (AccountOperation) o;
            return amount.equals(that.amount) && balance.equals(that.balance) && operationDate.equals(that.operationDate);
        }

        @Override
        public String toString() {
            return String.join("|",
                    this.operationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    this.printAmount() ,
                    ""+this.balance
            );
        }

        abstract String printAmount() ;

        @Override
        public int hashCode() {
            return Objects.hash(amount, balance, operationDate);
        }

    }

    public static class DepositOperation extends AccountOperation {

        public DepositOperation(BigInteger amount, BigInteger balance, LocalDate operationDate) {
            super(amount, balance, operationDate);
        }

        String printAmount() {
            return ""+this.getAmount();
        }

    }

    public static class WithdrawOperation extends AccountOperation {
        public WithdrawOperation(BigInteger amount, BigInteger balance, LocalDate operationDate) {
            super(amount, balance, operationDate);
        }

          String printAmount() {
           return "-"+this.getAmount();
        }
    }
}
