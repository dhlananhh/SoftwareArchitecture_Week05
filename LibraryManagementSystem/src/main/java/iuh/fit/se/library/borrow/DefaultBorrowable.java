package iuh.fit.se.library.borrow;

import iuh.fit.se.library.Library;
import iuh.fit.se.library.Book;

public class DefaultBorrowable implements Borrowable {
	@Override
    public void borrow(Book book) {
        Library library = Library.getInstance(); // Lấy Library Instance
        if (library.getAllBooks().contains(book) && !book.isBorrowed()) {
            book.setBorrowed(true);
            System.out.println("Bạn đã mượn sách: " + book.getTitle());
             library.simulateOverdueCheck(book, 7); // Vẫn giữ check overdue giả lập ở Component gốc
        } else if (!library.getAllBooks().contains(book)) {
            System.out.println("Sách " + book.getTitle() + " không tồn tại trong thư viện.");
        } else {
            System.out.println("Sách " + book.getTitle() + " hiện đang được mượn.");
        }
    }
}
