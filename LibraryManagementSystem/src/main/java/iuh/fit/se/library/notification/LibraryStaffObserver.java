package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public class LibraryStaffObserver implements LibraryEventObserver {
	private String staffName;

    public LibraryStaffObserver(String name) {
        this.staffName = name;
    }

    @Override
    public void onNewBookAdded(Book book) {
        System.out.println("Thông báo cho nhân viên " + staffName + ":");
        System.out.println("Sách mới đã được thêm vào thư viện: " + book.getTitle());
        // Logic xử lý của nhân viên thư viện (ví dụ: sắp xếp sách lên kệ, ...)
    }

    @Override
    public void onBookLoanExpired(Book book) {
        System.out.println("Thông báo cho nhân viên " + staffName + ":");
        System.out.println("Sách '" + book.getTitle() + "' đã hết hạn mượn!");
        // Logic xử lý sách hết hạn (ví dụ: liên hệ người mượn, ...)
    }
}
