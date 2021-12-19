import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {



    @Test
    void given_a_new_account_then_the_balance_is_0() {
        final Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void given_a_deposit_of_100_then_the_balance_is_100() {
        final Account account = new Account();
        final BigInteger amount = new BigInteger("100");
        account.depose(amount);
        assertThat(account.getBalance()).isEqualTo(new BigInteger("100"));
    }

    @Test
    void given_a_deposit_of_200_and_balance_is_100_then_the_balance_is_300() {
        final Account account = new Account(new BigInteger("100"));
        final BigInteger amount = new BigInteger("200");
        account.depose(amount);
        assertThat(account.getBalance()).isEqualTo(new BigInteger("300"));
    }

    @Test
    void given_a_withdraw_of_50_and_balance_is_350_then_the_balance_is_250() {
        final Account account = new Account(new BigInteger("300"));
        final BigInteger amount = new BigInteger("50");
        account.withdraw(amount);
        assertThat(account.getBalance()).isEqualTo(new BigInteger("250"));
    }

    @Test
    void given_an_account_then_the_balance_cannot_be_null() {
        final Account account = new Account(null);
        assertThat(account.getBalance()).isEqualTo(0);
    }


}
