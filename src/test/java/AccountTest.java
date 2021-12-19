import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {



    @Test
    void given_a_new_account_the_balance_is_0() {
        final Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    void given_a_deposit_of_100_the_balance_is_100() {
        final Account account = new Account();
        final BigInteger amount = new BigInteger("100");
        account.depose(amount);
        assertThat(account.getBalance()).isEqualTo(new BigInteger("100"));
    }


}
