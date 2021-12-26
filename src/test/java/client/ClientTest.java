package client;

import bank.Account;
import bank.BankClockStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;


class ClientTest {
    private Client client;

    @BeforeEach
    void setUp() {
        client = new Client(new Account(), new BankClockStub());
    }


    @Test
    void should_have_an_account() {
        assertThat(client.getAccount()).isNotNull();
    }

    @Test
    void should_make_deposit_on_their_account() {
        client.makeDeposit(new BigInteger("100"));
        assertThat(client.getAccount().getBalance()).isEqualTo(new BigInteger("100"));
    }

    @Test
    void should_make_withdrawal_on_their_account() {
        client.makeWithdrawal(new BigInteger("100"));
        assertThat(client.getAccount().getBalance()).isEqualTo(new BigInteger("-100"));
    }

    @Test
    void should_print_statement() {
        client.makeDeposit(new BigInteger("100"));
        client.printStatement();
        assertThat(client.printStatement()).isEqualTo("date|amount|balance"+ System.lineSeparator()+ "01/01/2020|100|100");
    }
}
