import java.math.BigInteger;

public class Account {

    private BigInteger balance = BigInteger.ZERO;

    public Account() {

    }
    public Account(BigInteger balance) {
        this.balance = balance;
    }

    public BigInteger getBalance() {
        return balance;
    }

    public void depose(BigInteger amount) {
         this.balance = this.balance.add(amount);
    }

}
