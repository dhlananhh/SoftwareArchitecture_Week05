package iuh.fit.se.library;


import java.util.ArrayList;
import java.util.List;

import iuh.fit.se.library.search.SearchStrategy;
import iuh.fit.se.library.notification.LibraryEventObserver;
import iuh.fit.se.library.borrow.*;

public class Library  {

    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<LibraryEventObserver> observers = new ArrayList<>();
    private Borrowable borrowableComponent;
    
    private Library() {
    	this.borrowableComponent = new DefaultBorrowable(); 
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
    
    public void registerObserver(LibraryEventObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(LibraryEventObserver observer) {
        observers.remove(observer);
    }

    private void notifyNewBookAdded(Book book) { // Private method để thông báo
        for (LibraryEventObserver observer : observers) {
            observer.onNewBookAdded(book);
        }
    }
    
    private void notifyBookOverdue(Book book) { 
        for (LibraryEventObserver observer : observers) {
            observer.onBookOverdue(book);
        }
    }
    
    public void addBook(Book book) {
        books.add(book);
        book.setBorrowed(false);
        System.out.println("Đã thêm sách: " + book.getTitle() + " vào thư viện." + "\n");
        notifyNewBookAdded(book); 
    }
    
    public void borrowBook(Book book) { 
        borrowableComponent.borrow(book); 
    }
    
    public void simulateOverdueCheck(Book book, int daysToOverdue) { 
        System.out.println("Giả định: Sách " + book.getTitle() + " hết hạn mượn sau " + daysToOverdue + " ngày.");
        notifyBookOverdue(book); 
    }

//    public void borrowBook(Book book) {
//        if (books.contains(book) && !book.isBorrowed()) {
//            book.setBorrowed(true);
//            System.out.println("Bạn đã mượn sách: " + book.getTitle());
//        } else if (!books.contains(book)) {
//            System.out.println("Sách " + book.getTitle() + " không tồn tại trong thư viện.");
//        } else {
//            System.out.println("Sách " + book.getTitle() + " hiện đang được mượn.");
//        }
//    }

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