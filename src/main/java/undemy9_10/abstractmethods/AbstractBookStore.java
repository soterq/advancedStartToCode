package undemy9_10.abstractmethods;

import undemy9_10.enums.Genre;

import java.util.List;
import java.util.Map;

public abstract class AbstractBookStore {

    public abstract Map<Integer, AbstractBook> getAllBooks();

    public abstract Map<Integer, AbstractBook> getBooksByGenre(Genre genre) throws Exception;

    public abstract void addBook(AbstractBook book) throws Exception;

    public abstract void deleteBook(AbstractBook book) throws Exception;

    public abstract void deleteBookById(int id) throws Exception;

    public abstract AbstractBook findBookByName(String name) throws Exception;

    public abstract AbstractBook findBookById(int id) throws Exception;

    public abstract boolean bookWithNameExists(String name) throws Exception;

    public abstract List<AbstractBook> findBooksByPriceRange(double minPrice, double maxPrice) throws Exception;

    public abstract List<AbstractBook> findBooksByGenreAndPriceRange(Genre genre, double minPrice, double maxPrice) throws Exception;
}
