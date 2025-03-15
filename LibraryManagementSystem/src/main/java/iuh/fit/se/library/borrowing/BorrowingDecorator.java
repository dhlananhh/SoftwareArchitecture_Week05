package iuh.fit.se.library.borrowing;

import iuh.fit.se.library.Book;

public class BorrowingDecorator {
	protected Borrowable borrowable; 

    public BorrowingDecorator(Borrowable borrowable) {
        this.borrowable = borrowable;
    }

    public void borrowBook(Book book, String borrowerName) {
        borrowable.borrowBook(book, borrowerName); 
    }
}
