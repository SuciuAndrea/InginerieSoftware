package market;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

// Stock se poate tranzactiona doar in interval 9-18, luni-vineri
public class Stock extends Asset {
    public Stock(String name, String symbol, double price) {
        super(name, symbol, price);
    }

    @Override
    public boolean canTradeNow() {
        LocalDateTime now = LocalDateTime.now();
        DayOfWeek day = now.getDayOfWeek();
        int hour = now.getHour();
        return day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY && hour >= 9 && hour <= 18;
    }
}
