package observer;

import market.Asset;

public interface Observer {
    void update(Asset asset);
}
