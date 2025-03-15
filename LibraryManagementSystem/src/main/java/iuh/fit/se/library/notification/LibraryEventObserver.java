package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public interface LibraryEventObserver {
	void onNewBookAdded(Book book); // Thông báo sách mới
    void onBookLoanExpired(Book book); // Thông báo sách hết hạn mượn
}
