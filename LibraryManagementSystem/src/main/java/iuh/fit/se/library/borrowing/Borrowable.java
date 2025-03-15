package iuh.fit.se.library.borrowing;

import iuh.fit.se.library.Book;

public interface Borrowable {
	void borrowBook(Book book, String borrowerName); 
}
