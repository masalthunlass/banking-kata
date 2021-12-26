package bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {



    @Test
    void should_have_an_account() {
        Client client = new Client(new Account());
        assertThat(client.getAccount()).isNotNull();
    }
}
