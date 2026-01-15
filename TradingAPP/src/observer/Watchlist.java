package observer;

import market.Asset;
import java.util.*;

public class Watchlist implements Observer {
    private List<Asset> watched = new ArrayList<>();

    public void addAsset(Asset a) { watched.add(a); }

    @Override
    public void update(Asset asset) {
        if (watched.contains(asset)) {
            System.out.println("NOTIFICATION: " + asset.getSymbol() + " price changed to " + asset.getPrice());
        }
    }
}
