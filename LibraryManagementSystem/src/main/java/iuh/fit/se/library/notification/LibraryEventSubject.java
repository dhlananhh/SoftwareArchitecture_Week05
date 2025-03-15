package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public interface LibraryEventSubject {
	void registerObserver(LibraryEventObserver observer); // Đăng ký Observer
    void unregisterObserver(LibraryEventObserver observer); // Hủy đăng ký Observer
    void notifyNewBookAdded(Book book); // Thông báo sách mới
    void notifyBookLoanExpired(Book book); // Thông báo sách hết hạn
	void addBook(Book book);
}
