package trading;

import user.User;
import market.Asset;

//STRATEGY PATTERN
public interface TradingStrategy {
    void execute(User user, Asset asset, int quantity);
}
