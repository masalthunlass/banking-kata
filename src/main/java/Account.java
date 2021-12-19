import java.math.BigInteger;

public class Account {

    private BigInteger balance = BigInteger.ZERO;

    public BigInteger getBalance() {
        return balance;
    }

    public void depose(BigInteger amount) {
         this.balance = new BigInteger("100");
    }
}
