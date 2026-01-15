package user;

import java.time.LocalDate;

// Reprezintă o deținere din portofoliu
public class Holding {
    public int quantity;
    public LocalDate buyDate;
    public boolean dayTrade;

    public Holding(int q, boolean d) {
        quantity = q;
        buyDate = LocalDate.now();
        dayTrade = d;
    }
}
