package iuh.fit.se.library;


import java.util.ArrayList;
import java.util.List;

import iuh.fit.se.library.search.SearchStrategy;


public class Library {

    private static Library instance;
    private List<Book> books = new ArrayList<>();

    private Library() {
    	
    }

    public static Library getInstance() {
        if (instance == null) {
            synchronized (Library.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setBorrowed(false); 
        System.out.println("Đã thêm sách: " + book.getTitle() + " vào thư viện.");
    }

    public void borrowBook(Book book) {
        if (books.contains(book) && !book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println("Bạn đã mượn sách: " + book.getTitle());
        } else if (!books.contains(book)) {
            System.out.println("Sách " + book.getTitle() + " không tồn tại trong thư viện.");
        } else {
            System.out.println("Sách " + book.getTitle() + " hiện đang được mượn.");
        }
    }

    public void returnBook(Book book) {
        if (books.contains(book) && book.isBorrowed()) {
            book.setBorrowed(false);
            System.out.println("Bạn đã trả sách: " + book.getTitle());
        } else if (!books.contains(book)) {
            System.out.println("Sách " + book.getTitle() + " không tồn tại trong thư viện.");
        }
         else {
            System.out.println("Sách " + book.getTitle() + " không ở trạng thái đang mượn để có thể trả.");
        }
    }


    public List<Book> getAllBooks() {
        return books;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Thư viện hiện tại không có sách.");
        } else {
            System.out.println("Danh sách tất cả sách trong thư viện:");
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
    }

    public List<Book> searchBooks(SearchStrategy strategy, String keyword) {
        return strategy.searchBooks(keyword); 
    }
}