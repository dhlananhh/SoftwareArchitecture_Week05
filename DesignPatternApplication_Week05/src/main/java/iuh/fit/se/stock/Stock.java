package iuh.fit.se.stock;

import java.util.ArrayList;
import java.util.List;

public class Stock implements StockSubject {
	private String stockName;
    private double price;
    private List<StockObserver> observers = new ArrayList<>();

    public Stock(String name, double initialPrice) {
        this.stockName = name;
        this.price = initialPrice;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (this.price != newPrice) {
            this.price = newPrice;
            notifyObservers(); // Gọi notifyObservers() khi giá thay đổi
        }
    }

    @Override
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(price); // Truyền giá mới cho từng Observer
        }
    }
}
