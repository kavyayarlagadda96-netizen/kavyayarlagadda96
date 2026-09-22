import java.util.Scanner;

class Stock {
    String symbol;
    String name;
    double price;

    Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    int apple = 0;
    int google = 0;
    int microsoft = 0;

    double balance = 10000;

    void buyStock(String symbol, int quantity, double price) {

        double cost = quantity * price;

        if (cost > balance) {
            System.out.println("Insufficient balance!");
            return;
        }

        if (symbol.equals("AAPL")) {
            apple += quantity;
        } else if (symbol.equals("GOOG")) {
            google += quantity;
        } else if (symbol.equals("MSFT")) {
            microsoft += quantity;
        }

        balance -= cost;

        System.out.println("Stock purchased successfully!");
    }

    void sellStock(String symbol, int quantity, double price) {

        if (symbol.equals("AAPL")) {

            if (quantity > apple) {
                System.out.println("You don't have enough AAPL stocks.");
                return;
            }

            apple -= quantity;

        } else if (symbol.equals("GOOG")) {

            if (quantity > google) {
                System.out.println("You don't have enough GOOG stocks.");
                return;
            }

            google -= quantity;

        } else if (symbol.equals("MSFT")) {

            if (quantity > microsoft) {
                System.out.println("You don't have enough MSFT stocks.");
                return;
            }

            microsoft -= quantity;

        } else {
            System.out.println("Invalid stock.");
            return;
        }

        balance += quantity * price;

        System.out.println("Stock sold successfully!");
    }

    void showPortfolio(Stock a, Stock g, Stock m) {

        System.out.println("\n========== PORTFOLIO ==========");

        System.out.println("AAPL : " + apple +
                " | Value: " + (apple * a.price));

        System.out.println("GOOG : " + google +
                " | Value: " + (google * g.price));

        System.out.println("MSFT : " + microsoft +
                " | Value: " + (microsoft * m.price));

        double totalValue =
                balance +
                (apple * a.price) +
                (google * g.price) +
                (microsoft * m.price);

        System.out.println("Cash Balance : " + balance);
        System.out.println("Total Portfolio Value : " + totalValue);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", "Apple", 180);
        Stock google = new Stock("GOOG", "Google", 150);
        Stock microsoft = new Stock("MSFT", "Microsoft", 400);

        Portfolio portfolio = new Portfolio();

        int choice;

        do {

            System.out.println("\n========== STOCK TRADING PLATFORM ==========");
            System.out.println("1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n----- MARKET DATA -----");
                    System.out.println("AAPL - Apple     : $" + apple.price);
                    System.out.println("GOOG - Google    : $" + google.price);
                    System.out.println("MSFT - Microsoft : $" + microsoft.price);
                    break;

                case 2:

                    System.out.print("Enter stock symbol (AAPL/GOOG/MSFT): ");
                    String buySymbol = sc.next().toUpperCase();

                    System.out.print("Enter quantity: ");
                    int buyQuantity = sc.nextInt();

                    if (buySymbol.equals("AAPL")) {
                        portfolio.buyStock(
                                buySymbol,
                                buyQuantity,
                                apple.price);
                    } else if (buySymbol.equals("GOOG")) {
                        portfolio.buyStock(
                                buySymbol,
                                buyQuantity,
                                google.price);
                    } else if (buySymbol.equals("MSFT")) {
                        portfolio.buyStock(
                                buySymbol,
                                buyQuantity,
                                microsoft.price);
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }

                    break;

                case 3:

                    System.out.print("Enter stock symbol (AAPL/GOOG/MSFT): ");
                    String sellSymbol = sc.next().toUpperCase();

                    System.out.print("Enter quantity: ");
                    int sellQuantity = sc.nextInt();

                    if (sellSymbol.equals("AAPL")) {
                        portfolio.sellStock(
                                sellSymbol,
                                sellQuantity,
                                apple.price);
                    } else if (sellSymbol.equals("GOOG")) {
                        portfolio.sellStock(
                                sellSymbol,
                                sellQuantity,
                                google.price);
                    } else if (sellSymbol.equals("MSFT")) {
                        portfolio.sellStock(
                                sellSymbol,
                                sellQuantity,
                                microsoft.price);
                    } else {
                        System.out.println("Invalid stock symbol.");
                    }

                    break;

                case 4:
                    portfolio.showPortfolio(
                            apple, google, microsoft);
                    break;

                case 5:
                    System.out.println("Thank you for using the platform!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}