package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public interface LibraryEventObserver {
   	void onNewBookAdded(Book book);
	void onBookOverdue(Book book); // Method thông báo sách hết hạn mượn
}
