package iuh.fit.se.library.borrow;

import iuh.fit.se.library.Book;

public class ExtendedReturnDateBorrowDecorator extends BorrowDecorator {
	private int extendedDays;

    public ExtendedReturnDateBorrowDecorator(Borrowable borrowable, int days) {
        super(borrowable);
        this.extendedDays = days;
    }

    @Override
    public void borrow(Book book) {
        super.borrow(book); 
        System.out.println("Bạn được gia hạn thêm " + extendedDays + " ngày trả sách cho cuốn: " + book.getTitle() + ".");
    }
}
