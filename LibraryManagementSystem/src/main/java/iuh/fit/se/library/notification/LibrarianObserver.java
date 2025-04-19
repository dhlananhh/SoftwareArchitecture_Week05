package iuh.fit.se.library.notification;

import iuh.fit.se.library.Book;

public class LibrarianObserver implements LibraryEventObserver {
	private String name;

    public LibrarianObserver(String name) {
        this.name = name;
    }

    public void onNewBookAdded(Book book) {
        System.out.println("Thông báo cho nhân viên thư viện " + name + ":");
        System.out.println("Sách mới đã được thêm vào thư viện: " + book.getTitle() + " - " + book.getBookType());
        // Logic xử lý khi nhân viên thư viện nhận thông báo sách mới (ví dụ: cập nhật danh mục, thông báo lên hệ thống...)
    }

    @Override
    public void onBookOverdue(Book book) { // Implement method onBookOverdue
        System.out.println("Thông báo cho nhân viên thư viện " + name + ":");
        System.out.println("Sách ĐÃ HẾT HẠN MƯỢN: " + book.getTitle() + " - Người mượn cần được nhắc nhở!");
        // Logic xử lý khi nhân viên thư viện nhận thông báo sách hết hạn mượn
        // Ví dụ: Gửi email/tin nhắn nhắc nhở người mượn, cập nhật trạng thái sách trên hệ thống, v.v.
    }
}
