package market;

// Creeaza Stock sau Crypto
public class AssetFactory {
    public static Asset createAsset(String type, String name, String symbol, double price) {
        if (type.equalsIgnoreCase("stock"))
            return new Stock(name, symbol, price);
        if (type.equalsIgnoreCase("crypto"))
            return new Crypto(name, symbol, price);
        throw new IllegalArgumentException("Unknown asset type");
    }
}
