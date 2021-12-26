package bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {
    private Client client;
    @BeforeEach
    void setUp() {
        client = new Client(new Account());
    }

    @Test
    void should_have_an_account() {
        assertThat(client.getAccount()).isNotNull();
    }

    @Test
    void should_make_deposit_on_their_account() {
        client.makesDeposit(new BigInteger("100"));
        assertThat(client.getAccount().getBalance()).isEqualTo(new BigInteger("100"));
    }
}
