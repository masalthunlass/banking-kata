package client;

import java.time.LocalDate;

public interface BankClock {

   default LocalDate today() {
       return LocalDate.now();
    }
}
