package iuh.fit.se.stock;

public interface StockSubject {
	void registerObserver(StockObserver observer); // Đăng ký Observer
    void unregisterObserver(StockObserver observer); // Hủy đăng ký Observer
    void notifyObservers(); // Thông báo cho tất cả Observersz
}
