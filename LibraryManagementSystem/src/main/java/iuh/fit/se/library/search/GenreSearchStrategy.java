package iuh.fit.se.library.search;

import iuh.fit.se.library.Book;
import iuh.fit.se.library.Library;
import java.util.List;
import java.util.stream.Collectors;

public class GenreSearchStrategy implements SearchStrategy {
	@Override
    public List<Book> searchBooks(String keyword) {
        System.out.println("Tìm kiếm sách theo thể loại: '" + keyword + "'");
        List<Book> books = Library.getInstance().getAllBooks(); // Lấy danh sách sách từ Library
        return books.stream()
                    .filter(book -> book.getGenre().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
    }
}
