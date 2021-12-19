import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {



    @Test
    void given_a_new_account_the_balance_is_0() {
        final Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }



}
