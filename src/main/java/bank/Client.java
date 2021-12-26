package bank;

import java.math.BigInteger;
import java.time.LocalDate;

public class Client {
    private final Account account;

    public Client(Account account) {
        this.account = account;
    }

    public Account getAccount() {
       return account;
    }

    public void makesDeposit(BigInteger amount) {
        this.account.depose(amount, LocalDate.now());
    }
}
