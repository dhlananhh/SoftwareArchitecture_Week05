package iuh.fit.se.library.search;

import iuh.fit.se.library.Book;
import iuh.fit.se.library.Library;
import java.util.List;
import java.util.stream.Collectors;

public class GenreSearchStrategy implements SearchStrategy {
	@Override
    public List<Book> searchBooks(String keyword) {
        List<Book> allBooks = Library.getInstance().getAllBooks(); 
        return allBooks.stream()
                .filter(book -> book.getGenre().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
