package iuh.fit.se.library.borrow;

import iuh.fit.se.library.Book;

public class SpecialEditionRequestBorrowDecorator extends BorrowDecorator {
	private String specialEditionType;

    public SpecialEditionRequestBorrowDecorator(Borrowable borrowable, String editionType) {
        super(borrowable);
        this.specialEditionType = editionType;
    }

    @Override
    public void borrow(Book book) {
        super.borrow(book); 
        System.out.println("Yêu cầu phiên bản đặc biệt '" + specialEditionType + "' cho sách: " + book.getTitle() + " đã được ghi nhận.");
    }
}
