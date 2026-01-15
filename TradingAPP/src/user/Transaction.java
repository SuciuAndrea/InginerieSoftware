package user;

public class Transaction {
    private String assetSymbol;
    private int quantity;
    private String type;

    public Transaction(String assetSymbol, int quantity, String type) {
        this.assetSymbol = assetSymbol;
        this.quantity = quantity;
        this.type = type;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " of " + assetSymbol;
    }
}
