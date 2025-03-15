package iuh.fit.se.stock;

public class StockMarketDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo cổ phiếu
        Stock googleStock = new Stock("GOOGL", 2500.0);

        // Tạo các nhà đầu tư (Observers), tự động đăng ký theo dõi cổ phiếu
        Investor investor1 = new Investor("Nhà đầu tư A", googleStock);
        Investor investor2 = new Investor("Nhà đầu tư B", googleStock);

        // Thay đổi giá cổ phiếu
        System.out.println("Giá cổ phiếu GOOGL hiện tại: " + googleStock.getPrice());
        googleStock.setPrice(2550.0);
        System.out.println("---");
        googleStock.setPrice(2600.0);

	}
}
