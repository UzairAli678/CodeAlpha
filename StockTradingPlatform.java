import java.util.HashMap;
import java.util.Scanner;

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> stocks = new HashMap<>();
        stocks.put("AAPL", 150.0);
        stocks.put("GOOGL", 2800.0);
        stocks.put("TSLA", 700.0);
        stocks.put("AMZN", 3400.0);
        
        HashMap<String, Integer> portfolio = new HashMap<>();
        double balance = 10000.0;
        
        while (true) {
            System.out.println("\nStock Trading Platform");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("\nMarket Data:");
                for (String stock : stocks.keySet()) {
                    System.out.println(stock + " - $" + stocks.get(stock));
                }
            } else if (choice == 2) {
                System.out.print("Enter stock symbol to buy: ");
                String stock = scanner.next().toUpperCase();
                if (stocks.containsKey(stock)) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    double cost = stocks.get(stock) * quantity;
                    if (cost <= balance) {
                        balance -= cost;
                        portfolio.put(stock, portfolio.getOrDefault(stock, 0) + quantity);
                        System.out.println("Successfully bought " + quantity + " shares of " + stock);
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                } else {
                    System.out.println("Stock not found!");
                }
            } else if (choice == 3) {
                System.out.print("Enter stock symbol to sell: ");
                String stock = scanner.next().toUpperCase();
                if (portfolio.containsKey(stock)) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    if (portfolio.get(stock) >= quantity) {
                        balance += stocks.get(stock) * quantity;
                        portfolio.put(stock, portfolio.get(stock) - quantity);
                        if (portfolio.get(stock) == 0) portfolio.remove(stock);
                        System.out.println("Successfully sold " + quantity + " shares of " + stock);
                    } else {
                        System.out.println("Not enough shares to sell!");
                    }
                } else {
                    System.out.println("You don't own this stock!");
                }
            } else if (choice == 4) {
                System.out.println("\nYour Portfolio:");
                for (String stock : portfolio.keySet()) {
                    System.out.println(stock + " - " + portfolio.get(stock) + " shares");
                }
                System.out.println("Balance: $" + balance);
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option!");
            }
        }
        scanner.close();
    }
}

