package market;

import observer.Observer;
import java.util.*;

public class Market {

    private static Market instance;
    private List<Asset> assets = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Market() {}

    //SINGLETON
    // FACADE -simplifica interactiunea cu assets, observers si preturi
    public static Market getInstance() {
        if (instance == null) instance = new Market();
        return instance;
    }

    public void addAsset(Asset a) { assets.add(a); }

    public Asset findBySymbol(String symbol) {
        return assets.stream().filter(a -> a.getSymbol().equalsIgnoreCase(symbol)).findFirst().orElse(null);
    }

    public void printAssets() {
        assets.forEach(System.out::println);
    }

    public void registerObserver(Observer o) { observers.add(o); }

    // Folosit pentru schimbarea pretului assetului
    public void updatePrice(Asset asset, double newPrice) {
        asset.setPrice(newPrice);
        // notificam toti observerii (auto-trading + watchlist)
        for (Observer o : observers) o.update(asset);
    }
}
