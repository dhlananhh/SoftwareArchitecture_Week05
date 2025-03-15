package iuh.fit.se.library.search;

import iuh.fit.se.library.Book;
import java.util.List;

public interface SearchStrategy {
    List<Book> searchBooks(String keyword);
}