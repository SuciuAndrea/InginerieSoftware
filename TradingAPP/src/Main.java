import market.*;
import trading.*;
import user.*;
import command.*;
import observer.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = Market.getInstance();
        Map<String, User> users = new HashMap<>();
        User user = null;
        TradingStrategy strategy = new DayTradingStrategy();

        // adaugare asset-uri initiale
        market.addAsset(AssetFactory.createAsset("stock", "Apple", "AAPL", 150));
        market.addAsset(AssetFactory.createAsset("stock", "Google", "GOOGL", 2800));
        market.addAsset(AssetFactory.createAsset("crypto", "Bitcoin", "BTC", 42000));

        while (true) {

            // LOGIN
            if (user == null) {
                System.out.println("\n=== LOGIN ===");
                System.out.print("Username: ");
                String username = sc.nextLine();
                user = users.getOrDefault(username, new User(username));
                users.putIfAbsent(username, user);
                System.out.println("Welcome " + username + "! Balance: $" + user.getBalance());
            }

            // MENU
            System.out.println("\n===== MENU =====");
            System.out.println("1. View market");
            System.out.println("2. Buy asset");
            System.out.println("3. Sell asset");
            System.out.println("4. View portfolio & balance");
            System.out.println("5. Transaction history");
            System.out.println("6. Change strategy");
            System.out.println("7. Change asset price");
            System.out.println("8. Add asset to watchlist");
            System.out.println("0. Logout");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 0:
                    user = null;
                    System.out.println("Logged out.");
                    break;

                case 1:
                    market.printAssets();
                    break;

                case 2:
                    market.printAssets();
                    System.out.print("Symbol: ");
                    Asset aBuy = market.findBySymbol(sc.nextLine());
                    System.out.print("Quantity: ");
                    int qBuy = Integer.parseInt(sc.nextLine());
                    new BuyCommand(user, aBuy, qBuy, strategy).execute();
                    break;

                case 3:
                    user.getPortfolio().printPortfolio();
                    System.out.print("Symbol: ");
                    Asset aSell = market.findBySymbol(sc.nextLine());
                    System.out.print("Quantity: ");
                    int qSell = Integer.parseInt(sc.nextLine());
                    new SellCommand(user, aSell, qSell).execute();
                    break;

                case 4:
                    user.printBalance();
                    user.getPortfolio().printPortfolio();
                    break;

                case 5:
                    user.printTransactions();
                    break;

                case 6:
                    System.out.println("1. Day Trading");
                    System.out.println("2. Long Term");
                    System.out.println("3. Auto Trading");
                    int s = Integer.parseInt(sc.nextLine());
                    if (s == 1) {
                        strategy = new DayTradingStrategy();
                        System.out.println("DAY TRADING activated");
                    } else if (s == 2) {
                        strategy = new LongTermStrategy();
                        System.out.println("LONG TERM activated");
                    } else if (s == 3) {
                        market.printAssets();
                        System.out.print("Symbol to auto trade: ");
                        Asset autoAsset = market.findBySymbol(sc.nextLine());
                        System.out.print("Quantity: ");
                        int qty = Integer.parseInt(sc.nextLine());
                        System.out.print("Buy threshold: ");
                        double buyT = Double.parseDouble(sc.nextLine());
                        System.out.print("Sell threshold: ");
                        double sellT = Double.parseDouble(sc.nextLine());
                        strategy = new AutoTradingStrategy(user, autoAsset, qty, buyT, sellT);
                        System.out.println("AUTO TRADING activated for " + autoAsset.getSymbol());
                    }
                    break;

                case 7:
                    market.printAssets();
                    System.out.print("Symbol: ");
                    Asset assetPrice = market.findBySymbol(sc.nextLine());
                    System.out.print("New price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    market.updatePrice(assetPrice, price);
                    System.out.println("Price updated");
                    break;

                case 8:
                    System.out.print("Symbol to add to watchlist: ");
                    Asset watchAsset = market.findBySymbol(sc.nextLine());

                    user.getWatchlist().addAsset(watchAsset);

                    // 🔥 înregistrăm watchlist-ul ca observer
                    market.registerObserver(user.getWatchlist());

                    System.out.println("Added to watchlist");
                    break;
            }
        }
    }
}
