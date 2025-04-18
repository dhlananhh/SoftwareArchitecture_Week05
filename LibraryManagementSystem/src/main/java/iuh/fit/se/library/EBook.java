package iuh.fit.se.library;

public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, String genre, String format) {
        super(title, author, genre); 
        this.fileFormat = format;
    }

    @Override
    public String getBookType() {
        return "Sách điện tử";
    }

    public String getFileFormat() {
        return fileFormat;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Định dạng file: " + fileFormat + "\n");
    }
}