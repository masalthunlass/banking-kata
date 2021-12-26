package bank;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class AccountStatementTest {
    private final AccountStatement accountStatement = new AccountStatement();

    @Test
    void should_print_operation_date_first_when_printing_deposit_operation() {
        this.accountStatement.addDepositOperation(new BigInteger("100"), new BigInteger("100"), LocalDate.of(2020, 1, 1));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "01/01/2020");
    }

    @Test
    void should_print_operation_date_first_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(new BigInteger("100"), new BigInteger("100"), LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "03/01/2020");
    }


    @Test
    void should_print_amount_second_when_printing_deposit_operation() {
        this.accountStatement.addDepositOperation(new BigInteger("100"), new BigInteger("100"), LocalDate.of(2020, 1, 1));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "01/01/2020|100");
    }


    @Test
    void should_print_amount_second_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(new BigInteger("50"), new BigInteger("100"), LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "03/01/2020|-50");
    }

    @Test
    void should_print_balance_last_when_printing_deposit_operation() {
        this.accountStatement.addDepositOperation(new BigInteger("100"), new BigInteger("100"), LocalDate.of(2020, 1, 1));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "01/01/2020|100|100");
    }

    @Test
    void should_print_balance_last_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(new BigInteger("50"), new BigInteger("250"), LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).startsWith("date|amount|balance"+ System.lineSeparator()+ "03/01/2020|-50|250");
    }

    @Test
    void should_not_create_a_withdraw_operation_with_null_amount() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addWithdrawOperation(null, new BigInteger("250"), LocalDate.of(2020, 1, 3));
        });
    }

    @Test
    void should_not_create_a_deposit_operation_with_null_amount() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addDepositOperation(null, new BigInteger("250"), LocalDate.of(2020, 1, 3));
        });
    }

    @Test
    void should_not_create_a_withdraw_operation_with_null_balance() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addWithdrawOperation(new BigInteger("250"), null, LocalDate.of(2020, 1, 3));
        });
    }


    @Test
    void should_not_create_a_deposit_operation_with_null_balance() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addDepositOperation(new BigInteger("250"), null, LocalDate.of(2020, 1, 3));
        });
    }

    @Test
    void should_not_create_a_withdraw_operation_with_null_date() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addWithdrawOperation(new BigInteger("250"), new BigInteger("250"), null);
        });
    }

    @Test
    void should_not_create_a_deposit_operation_with_null_date() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.accountStatement.addDepositOperation(new BigInteger("250"), new BigInteger("250"), null);
        });
    }

    @Test
    void should_print_header_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(new BigInteger("50"), new BigInteger("250"), LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).isEqualTo(
                "date|amount|balance"+ System.lineSeparator()+ "03/01/2020|-50|250"
        );
    }


    @Test
    void should_print_all_operations_when_printing_statement() {
        this.accountStatement.addWithdrawOperation(new BigInteger("50"), new BigInteger("250"), LocalDate.of(2020, 1, 1));
        this.accountStatement.addDepositOperation(new BigInteger("100"), new BigInteger("100"), LocalDate.of(2020, 1, 1));

        assertThat(this.accountStatement.print()).isEqualTo(
                "date|amount|balance"+ System.lineSeparator()+ "01/01/2020|-50|250" +System.lineSeparator()+ "01/01/2020|100|100"
        );
    }

}
