package bank;

import client.BankClock;

import java.time.LocalDate;

public class BankClockStub implements BankClock {

    public LocalDate today() {
        return LocalDate.of(2020, 1, 1);
    }
}
