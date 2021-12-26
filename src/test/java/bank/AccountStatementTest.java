package bank;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class AccountStatementTest {
    private final AccountStatement accountStatement = new AccountStatement();

    @Test
    void should_print_operation_date_first_when_printing_deposit_operation() {
        this.accountStatement.addDepositOperation(null, null, LocalDate.of(2020, 1, 1));
        assertThat(this.accountStatement.print()).startsWith("01/01/2020");
    }

    @Test
    void should_print_operation_date_first_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(null, null, LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).startsWith("03/01/2020");
    }


    @Test
    void should_print_amount_second_when_printing_deposit_operation() {
        this.accountStatement.addDepositOperation(new BigInteger("100"), null, LocalDate.of(2020, 1, 1));
        assertThat(this.accountStatement.print()).startsWith("01/01/2020|100");
    }


    @Test
    void should_print_amount_second_when_printing_withdraw_operation() {
        this.accountStatement.addWithdrawOperation(new BigInteger("50"), null, LocalDate.of(2020, 1, 3));
        assertThat(this.accountStatement.print()).startsWith("03/01/2020|-50");
    }



}
