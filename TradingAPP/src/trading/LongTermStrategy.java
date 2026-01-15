package trading;

import user.User;
import market.Asset;

public class LongTermStrategy implements TradingStrategy {
    @Override
    public void execute(User user, Asset asset, int quantity) {
        user.getPortfolio().buy(asset, quantity, false);
    }
}
