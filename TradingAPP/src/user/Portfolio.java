package user;

import market.Asset;
import java.util.*;


//COMPOSITE -gestioneaza mai multe assets ca un intreg
public class Portfolio {

    private Map<String, Holding> holdings = new HashMap<>();

    // buy fara mesaje
    public void buy(Asset a, int q, boolean dayTrade) {
        holdings.put(a.getSymbol(), new Holding(q, dayTrade));
    }

    public boolean hasEnough(String symbol, int q) {
        Holding h = holdings.get(symbol);
        return h != null && h.quantity >= q;
    }

    public void sell(Asset a, int q) {
        Holding h = holdings.get(a.getSymbol());
        if (h != null) {
            h.quantity -= q;
            if (h.quantity <= 0) holdings.remove(a.getSymbol());
        }
    }

    public void printPortfolio() {
        System.out.println("Portfolio:");
        if (holdings.isEmpty()) { System.out.println("Empty"); return; }
        holdings.forEach((k, v) -> System.out.println(k + " -> " + v.quantity));
    }

    private static class Holding {
        int quantity;
        boolean dayTrade;
        public Holding(int q, boolean dt) { quantity = q; dayTrade = dt; }
    }
}
