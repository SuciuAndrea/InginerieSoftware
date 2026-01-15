package market;

// Crypto poate fi tranzactionata oricand
public class Crypto extends Asset {
    public Crypto(String name, String symbol, double price) {
        super(name, symbol, price);
    }

    @Override
    public boolean canTradeNow() {
        return true;
    }
}
