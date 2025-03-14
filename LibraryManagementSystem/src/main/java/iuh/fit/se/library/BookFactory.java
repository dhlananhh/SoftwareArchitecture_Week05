package iuh.fit.se.library;


public class BookFactory {
    public static Book createBook(String type, String title, String author, String genre, Object... details) { // Thêm genre vào params đầu tiên
        if ("Sách giấy".equalsIgnoreCase(type)) {
            return new PaperBook(title, author, genre, (Integer) details[0]); // detail[0] = pageCount
        } else if ("Sách điện tử".equalsIgnoreCase(type)) {
            return new EBook(title, author, genre, (String) details[0]); // detail[0] = fileFormat
        } else if ("Sách nói".equalsIgnoreCase(type)) {
            return new AudioBook(title, author, genre, (Double) details[0]); // detail[0] = durationHours
        }
        return null; // Loại sách không hợp lệ
    }
}