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
        account.withdraw(amount);
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
        account.depose(amount,null);
        Assertions.assertThat(account.getAccountStatement().getAmount()).isEqualTo(amount);
    }

    @Test
    void given_an_account_when_depose_amount_then_keep_balance() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");

        account.depose(amount, null);

        final BigInteger balanceAfterOperation = new BigInteger("300");
        Assertions.assertThat(account.getAccountStatement().getBalance()).isEqualTo(balanceAfterOperation);
    }

    @Test
    void given_an_account_when_depose_amount_at_a_date_then_keep_date() {
        final BigInteger balance = new BigInteger("100");
        final Account account = new Account(balance);
        final BigInteger amount = new BigInteger("200");

        account.depose(amount, LocalDate.of(2020, 1,1));

        Assertions.assertThat(account.getAccountStatement().getOperationDate()).isEqualTo( LocalDate.of(2020, 1,1));
    }



}
