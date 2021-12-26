package bank;

public class Client {
    private final Account account;

    public Client(Account account) {
        this.account = account;
    }

    public Account getAccount() {
       return account;
    }
}
