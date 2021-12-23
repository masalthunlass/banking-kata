package bank;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.LocalDate;

public class AccountTest {


    @Test
    void given_a_new_account_then_the_balance_is_0() {
        final Account account = new Account();
        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void given_a_deposit_of_100_then_the_balance_is_100() {
        final Account account = new Account();
        final BigInteger amount = new BigInteger("100");
        account.depose(amount, LocalDate.of(2020, 1, 1));
        Assertions.assertThat(account.getBalance()).isEqualTo(new BigInteger("100"));
    }

    @Test
    void given_a_deposit_of_200_and_balance_is_100_then_the_balance_is_300() {
        final Account account = new Account(new BigInteger("100"));
        final BigInteger amount = new BigInteger("200");
        account.depose(amount, LocalDate.of(2020, 1, 1));
        Assertions.assertThat(account.getBalance()).isEqualTo(new BigInteger("300"));
    }

    @Test
    void given_a_withdraw_of_50_and_balance_is_350_then_the_balance_is_250() {
        final Account account = new Account(new BigInteger("300"));
        final BigInteger amount = new BigInteger("50");
        account.withdraw(amount, LocalDate.of(2020, 1, 3));
        Assertions.assertThat(account.getBalance()).isEqualTo(new BigInteger("250"));
    }

    @Test
    void given_an_account_then_the_balance_cannot_be_null() {
        final Account account = new Account(null);
        Assertions.assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void given_an_account_when_depose_amount_then_keep_amount() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");
        account.depose(amount, null);
        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getAmount()).isEqualTo(amount);
    }

    @Test
    void given_an_account_when_depose_amount_then_keep_balance() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");

        account.depose(amount, null);

        final BigInteger balanceAfterOperation = new BigInteger("300");
        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getBalance()).isEqualTo(balanceAfterOperation);
    }

    @Test
    void given_an_account_when_depose_amount_at_a_date_then_keep_date() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");

        account.depose(amount, LocalDate.of(2020, 1, 1));

        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getOperationDate())
                .isEqualTo(LocalDate.of(2020, 1, 1));
    }

    @Test
    void given_an_account_when_depose_amount_twice_then_keep_two_operations_history() {

        final Account account = new Account(BigInteger.ZERO);

        account.depose(new BigInteger("200"), LocalDate.of(2020, 1, 1));
        account.depose(new BigInteger("20"), LocalDate.of(2020, 2, 1));

        Assertions.assertThat(account.getAccountStatement().getOperations()).hasSize(2);
        Assertions.assertThat(account.getAccountStatement().getOperations()).containsExactly(
                new AccountStatement.AccountOperation(
                        new BigInteger("200"),new BigInteger("200"),LocalDate.of(2020, 1, 1)
                ), new AccountStatement.AccountOperation(
                        new BigInteger("20"),new BigInteger("220"),LocalDate.of(2020, 2, 1)
                ));
    }


    @Test
    void given_an_account_when_withdraw_amount_then_keep_amount() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");
        account.withdraw(amount, LocalDate.of(2020, 1, 3));
        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getAmount()).isEqualTo(amount);
    }


    @Test
    void given_an_account_when_withdraw_amount_then_keep_balance() {
        final BigInteger balance = new BigInteger("300");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");
        account.withdraw(amount, LocalDate.of(2020, 1, 3));
        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getBalance()).isEqualTo("100");
    }

    @Test
    void given_an_account_when_withdraw_amount_at_a_date_then_keep_the_date() {
        final BigInteger balance = new BigInteger("300");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");
        account.withdraw(amount, LocalDate.of(2020,1,3));
        Assertions.assertThat(account.getAccountStatement().getOperations().get(0).getOperationDate()).isEqualTo( LocalDate.of(2020,1,3));
    }





}
