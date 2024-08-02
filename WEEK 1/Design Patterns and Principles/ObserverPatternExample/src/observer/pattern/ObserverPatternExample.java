package observer.pattern;

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("App1");
        Observer mobileApp2 = new MobileApp("App2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice(100.0);
        stockMarket.setStockPrice(101.5);

        stockMarket.removeObserver(mobileApp2);

        stockMarket.setStockPrice(102.0);
    }
}