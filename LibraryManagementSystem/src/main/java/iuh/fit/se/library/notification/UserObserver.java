package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public class UserObserver implements LibraryEventObserver {
	private String userName;

    public UserObserver(String name) {
        this.userName = name;
    }

    @Override
    public void onNewBookAdded(Book book) {
        System.out.println("Thông báo cho người dùng " + userName + ":");
        System.out.println("Có sách mới về thư viện mà bạn có thể quan tâm: " + book.getTitle());
        // Logic xử lý cho người dùng (ví dụ: xem thông tin sách mới, ...)
    }

    @Override
    public void onBookLoanExpired(Book book) {
        System.out.println("Thông báo cho người dùng " + userName + ":");
        System.out.println("Sách bạn đang mượn '" + book.getTitle() + "' sắp hết hạn mượn!");
        // Logic nhắc nhở người dùng trả sách (ví dụ: gửi email nhắc hạn, ...)
    }
}
