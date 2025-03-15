package iuh.fit.se.library;


import java.util.List;

import iuh.fit.se.library.search.AuthorSearchStrategy;
import iuh.fit.se.library.search.GenreSearchStrategy;
import iuh.fit.se.library.search.TitleSearchStrategy;
import iuh.fit.se.library.notification.LibrarianObserver;
import iuh.fit.se.library.borrow.*;


public class LibraryManagementDemo {
    public static void main(String[] args) {
    	// Lấy instance Singleton của thư viện
        Library library = Library.getInstance(); 
        
        // Tạo các Observer (nhân viên thư viện)
        LibrarianObserver librarian1 = new LibrarianObserver("Lan");
        LibrarianObserver librarian2 = new LibrarianObserver("Hùng");
        
        // Đăng ký Observers với thư viện (Subject)
        library.registerObserver(librarian1);
        library.registerObserver(librarian2);

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

        // DEMO MƯỢN SÁCH VỚI DECORATOR PATTERN
        Book borrowedBook1 = library.getAllBooks().get(0); 
        System.out.println("\n--- DEMO MƯỢN SÁCH VỚI DECORATOR ---");
        System.out.println("\n1. Mượn sách cơ bản:");
        library.borrowBook(borrowedBook1); 
        System.out.println("\n2. Mượn sách và gia hạn 2 tuần:");
        Borrowable borrowWithExtension = new ExtendedReturnDateBorrowDecorator(new DefaultBorrowable(), 14); // Decorator gia hạn
        borrowWithExtension.borrow(book1);
        System.out.println("\n3. Mượn sách và yêu cầu phiên bản chữ nổi:");
        Borrowable borrowWithSpecialEdition = new SpecialEditionRequestBorrowDecorator(new DefaultBorrowable(), "Chữ nổi"); // Decorator phiên bản đặc biệt
        borrowWithSpecialEdition.borrow(book1); // Mượn sách với decorator phiên bản đặc biệt

        System.out.println("\n4. Mượn sách với gia hạn VÀ yêu cầu phiên bản đặc biệt (kết hợp decorators):");
        Borrowable borrowCombined = new ExtendedReturnDateBorrowDecorator( // Kết hợp decorators
        		new SpecialEditionRequestBorrowDecorator(new DefaultBorrowable(), "Bản dịch tiếng Việt"), // Bao decorator này bởi decorator khác
                                     30); // Gia hạn 30 ngày
        borrowCombined.borrow(book1); // Mượn sách với combination decorators

        System.out.println("\n---\n");
        
        // Trả sách
        library.returnBook(book1);
        System.out.println("\n---\n");
        
        // Mượn sách
//        library.borrowBook(book1);
//        library.borrowBook(book4); 
//        System.out.println("\n---\n");

        // Hiển thị lại danh sách sách sau khi mượn
        library.displayAllBooks();
        System.out.println("\n---\n");

        // Tìm kiếm sách theo thể loại
        System.out.println("Tìm kiếm sách theo thể loại 'Lãng mạn':");
        GenreSearchStrategy genreStrategy = new GenreSearchStrategy();
        List<Book> searchResultsGenreStrategy = library.searchBooks(genreStrategy, "Lãng mạn"); 
        searchResultsGenreStrategy.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");

        // Tìm kiếm sách theo Tác giả
        System.out.println("Tìm kiếm sách theo Tác giả 'Doyle':");
        AuthorSearchStrategy authorStrategy = new AuthorSearchStrategy();
        List<Book> searchResultsAuthorStrategy = library.searchBooks(authorStrategy, "Doyle"); 
        searchResultsAuthorStrategy.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");

        // Tìm kiếm sách theo Tiêu đề
        System.out.println("Tìm kiếm sách theo Tiêu đề 'Lord':");
        TitleSearchStrategy titleStrategy = new TitleSearchStrategy();
        List<Book> searchResultsTitleStrategy = library.searchBooks(titleStrategy, "Lord"); 
        searchResultsTitleStrategy.forEach(Book::displayBookInfo);
        System.out.println("\n---\n");

        // Hiển thị lại danh sách sách sau khi trả
        System.out.println("Danh sách sách sau khi trả:");
        library.displayAllBooks();

    }
}