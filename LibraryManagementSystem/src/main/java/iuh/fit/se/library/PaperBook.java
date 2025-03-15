package iuh.fit.se.library;

public class PaperBook extends Book {
    private int pageCount;

    public PaperBook(String title, String author, String genre, int pages) {
        super(title, author, genre); 
        this.pageCount = pages;
    }

    @Override
    public String getBookType() {
        return "Sách giấy";
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo(); 
        System.out.println("Số trang: " + pageCount + " trang" + "\n");
    }
}