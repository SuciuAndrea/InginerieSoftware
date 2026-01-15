package user;

import observer.Watchlist;
import java.util.*;

// User-ul are portofoliu, balance, tranzactii si watchlist
public class User {
    private String username;
    private double balance;
    private Portfolio portfolio = new Portfolio();
    private List<Transaction> history = new ArrayList<>();
    private Watchlist watchlist = new Watchlist();

    public User(String username) {
        this.username = username;
        this.balance = 10000; // starting money
    }

    public double getBalance() { return balance; }
    public void removeMoney(double amount) { balance -= amount; }
    public void addMoney(double amount) { balance += amount; }

    public Portfolio getPortfolio() { return portfolio; }
    public Watchlist getWatchlist() { return watchlist; }

    public void addTransaction(Transaction t) { history.add(t); }

    public void printTransactions() {
        if (history.isEmpty()) {
            System.out.println("No transactions yet.");
            return;
        }
        history.forEach(System.out::println);
    }

    public void printBalance() { System.out.println("Balance: $" + balance); }
}
