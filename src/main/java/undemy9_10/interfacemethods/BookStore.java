package undemy9_10.interfacemethods;

import undemy9_10.enums.Genre;

import java.util.List;
import java.util.Map;

public interface BookStore {

    List<Book> getAllBooks();

    List<Book> getBooksByGenre(Genre genre) throws Exception;

    void addBook(Book book) throws Exception;

    void deleteBook(Book book) throws Exception;

    void deleteBookById(int id) throws Exception;

    Book findBookByName(String name) throws Exception;

    Book findBookById(int id) throws Exception;

    boolean bookWithNameExists(String name) throws Exception;

    List<Book> findBooksByPriceRange(double minPrice, double maxPrice) throws Exception;

    List<Book> findBooksByGenreAndPriceRange(Genre genre, double minPrice, double maxPrice) throws Exception;
}
