package iuh.fit.se.library;

public class AudioBook extends Book {
    private double durationHours;

    public AudioBook(String title, String author, String genre, double duration) {
        super(title, author, genre); 
        this.durationHours = duration;
    }

    @Override
    public String getBookType() {
        return "Sách nói";
    }

    public double getDurationHours() {
        return durationHours;
    }

    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Thời lượng: " + durationHours + " giờ" + "\n");
    }
}