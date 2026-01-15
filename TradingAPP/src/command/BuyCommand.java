package command;

import market.Asset;
import trading.TradingStrategy;
import user.User;

public class BuyCommand implements TradeCommand {

    private User user;
    private Asset asset;
    private int quantity;
    private TradingStrategy strategy;

    public BuyCommand(User user, Asset asset, int quantity, TradingStrategy strategy) {
        this.user = user;
        this.asset = asset;
        this.quantity = quantity;
        this.strategy = strategy;
    }

    @Override
    public void execute() {

        double totalCost = asset.getPrice() * quantity;
        if (user.getBalance() < totalCost) {
            System.out.println("Not enough balance!");
            return;
        }

        strategy.execute(user, asset, quantity);
        user.removeMoney(totalCost);
        user.addTransaction(new user.Transaction(asset.getSymbol(), quantity, "BUY"));
    }
}
