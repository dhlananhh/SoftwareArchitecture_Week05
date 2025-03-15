package iuh.fit.se.library.borrow;

import iuh.fit.se.library.Book;

public class BorrowDecorator implements Borrowable {
	protected Borrowable borrowable; 

    public BorrowDecorator(Borrowable borrowable) {
        this.borrowable = borrowable;
    }

    @Override
    public void borrow(Book book) {
        borrowable.borrow(book); 
    }
}
