package trading;

import market.Asset;
import market.Market;
import market.Stock;
import observer.Observer;
import user.User;

public class AutoTradingStrategy implements TradingStrategy, Observer {

    private User user;
    private Asset asset;
    private int quantity;
    private double buyThreshold;
    private double sellThreshold;

    public AutoTradingStrategy(User user, Asset asset, int quantity, double buyThreshold, double sellThreshold) {
        this.user = user;
        this.asset = asset;
        this.quantity = quantity;
        this.buyThreshold = buyThreshold;
        this.sellThreshold = sellThreshold;

        Market.getInstance().registerObserver(this);
    }

    @Override
    public void execute(User u, Asset a, int q) {
        // nu se foloseste manual
    }

    @Override
    public void update(Asset updatedAsset) {
        if (!updatedAsset.getSymbol().equalsIgnoreCase(asset.getSymbol())) return;
        if (!(updatedAsset instanceof Stock)) return;

        double price = updatedAsset.getPrice();

        // AUTO BUY
        if (price < buyThreshold) {
            double cost = price * quantity;
            if (user.getBalance() >= cost) {
                user.getPortfolio().buy(updatedAsset, quantity, false);
                user.removeMoney(cost);
                user.addTransaction(new user.Transaction(asset.getSymbol(), quantity, "AUTO BUY"));
            }
        }

        // AUTO SELL
        if (price > sellThreshold && user.getPortfolio().hasEnough(asset.getSymbol(), quantity)) {
            user.getPortfolio().sell(updatedAsset, quantity);
            user.addMoney(price * quantity);
            user.addTransaction(new user.Transaction(asset.getSymbol(), quantity, "AUTO SELL"));
        }
    }
}
