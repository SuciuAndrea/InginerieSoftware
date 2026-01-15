package market;

// Clasa de bază pentru Stock și Crypto
public abstract class Asset {
    protected String name;
    protected String symbol;
    protected double price;

    public Asset(String name, String symbol, double price) {
        this.name = name;
        this.symbol = symbol;
        this.price = price;
    }

    public abstract boolean canTradeNow();

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public String toString() {
        return name + " (" + symbol + ") - $" + price;
    }
}
