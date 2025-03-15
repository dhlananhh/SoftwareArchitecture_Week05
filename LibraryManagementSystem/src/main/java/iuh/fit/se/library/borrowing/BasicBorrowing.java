package iuh.fit.se.library.borrowing;

import iuh.fit.se.library.Book;

public class BasicBorrowing implements Borrowable {
	@Override
    public void borrowBook(Book book, String borrowerName) {
        System.out.println("Người dùng '" + borrowerName + "' mượn sách '" + book.getTitle() + "'");
        System.out.println("Ghi lại thông tin mượn sách vào hệ thống...");
        // Logic xử lý mượn sách cơ bản (ví dụ: cập nhật database, ...)
    }
}
