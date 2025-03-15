package iuh.fit.se.stock;

public class Investor implements StockObserver {
	private String investorName;
    private Stock stock;

    public Investor(String name, Stock stock) {
        this.investorName = name;
        this.stock = stock;
        this.stock.registerObserver(this); // Đăng ký làm observer khi Investor được tạo
    }

    @Override
    public void update(double price) {
        System.out.println("Thông báo cho nhà đầu tư " + investorName + ":");
        System.out.println("Giá cổ phiếu " + stock.getStockName() + " đã thay đổi thành: " + price + " VNĐ");
        // Logic phản ứng của nhà đầu tư khi giá cổ phiếu thay đổi (ví dụ: mua/bán)
    }
}
