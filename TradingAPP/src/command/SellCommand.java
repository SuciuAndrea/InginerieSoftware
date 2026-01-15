package command;

import market.Asset;
import user.User;

public class SellCommand implements TradeCommand {

    private User user;
    private Asset asset;
    private int quantity;

    public SellCommand(User user, Asset asset, int quantity) {
        this.user = user;
        this.asset = asset;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        if (!user.getPortfolio().hasEnough(asset.getSymbol(), quantity)) {
            System.out.println("Not enough assets to sell!");
            return;
        }

        user.getPortfolio().sell(asset, quantity);
        user.addMoney(asset.getPrice() * quantity);
        user.addTransaction(new user.Transaction(asset.getSymbol(), quantity, "SELL"));
    }
}
