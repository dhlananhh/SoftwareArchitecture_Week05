package iuh.fit.se.library;

import java.util.List;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = Library.getInstance(); // Lấy instance Singleton của thư viện

        // Tạo các sách mới (sử dụng Factory), thêm thể loại vào
        Book book1 = BookFactory.createBook("Sách giấy", "Sherlock Holmes: A Study in Scarlet", "Arthur Conan Doyle", "Trinh thám", 250);
        Book book2 = BookFactory.createBook("Sách điện tử", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy", "EPUB");
        Book book3 = BookFactory.createBook("Sách nói", "Pride and Prejudice", "Jane Austen", "Lãng mạn", 12.5);
        Book book4 = BookFactory.createBook("Sách giấy", "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Khoa học viễn tưởng", 224);
        Book book5 = BookFactory.createBook("Sách giấy", "Mắt Biếc", "Nguyễn Nhật Ánh", "Lãng mạn", 178);

        // Thêm sách vào thư viện
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);


        // Hiển thị danh sách tất cả sách
        System.out.println("\n---\n");
        library.displayAllBooks();
        System.out.println("\n---\n");

        // Mượn sách
        library.borrowBook(book1);
        library.borrowBook(book4); // Thử mượn sách không có trong thư viện
        System.out.println("\n---\n");

        // Hiển thị lại danh sách sách sau khi mượn
        library.displayAllBooks();
        System.out.println("\n---\n");

        // Tìm kiếm sách theo tiêu đề
        System.out.println("Tìm kiếm sách theo tiêu đề 'Sherlock':");
        List<Book> searchResultsTitle = library.searchBookByTitle("Sherlock");
        searchResultsTitle.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");

        // Tìm kiếm sách theo tác giả
        System.out.println("Tìm kiếm sách theo tác giả 'Tolkien':");
        List<Book> searchResultsAuthor = library.searchBookByAuthor("Tolkien");
        searchResultsAuthor.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");

        // **DEMO Tìm kiếm sách theo thể loại**
        System.out.println("Tìm kiếm sách theo thể loại 'Lãng mạn':");
        List<Book> searchResultsGenre = library.searchBookByGenre("Lãng mạn");
        searchResultsGenre.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");


        // Trả sách
        library.returnBook(book1);
        System.out.println("\n---\n");

        // Hiển thị lại danh sách sách sau khi trả
        library.displayAllBooks();

    }
}