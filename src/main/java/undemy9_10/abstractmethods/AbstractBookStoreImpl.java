package undemy9_10.abstractmethods;

import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractBookStoreImpl extends AbstractBookStore {
    private Map<Integer, AbstractBook> bookCollection = new HashMap<>();

    @Override
    public Map<Integer, AbstractBook> getAllBooks() {
        return bookCollection;
    }

    @Override
    public void addBook(AbstractBook book) throws Exception {
        nullBookValidation(book);
        if (!bookCollection.keySet().contains(book.getId())) {
            bookCollection.put(book.getId(), book);
            System.out.println(book.toString() + " was added");
        } else {
            System.out.println("This book already exists ");
        }
    }

    @Override
    public AbstractBook findBookByName(String name) throws Exception {
        bookNameNullValidation(name);
        for (AbstractBook book : bookCollection.values()) {
            if (name.equalsIgnoreCase(book.getName())) {
                return book;
            }
        }
        throw new Exception("Book not found");
    }

    @Override
    public AbstractBook findBookById(int id) throws Exception {
        negativeIdValidation(id);
        for (AbstractBook book : bookCollection.values()) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new Exception("Book not found");
    }

    @Override
    public Map<Integer, AbstractBook> getBooksByGenre(Genre genre) throws Exception {
        genreNullPointerValidation(genre);
        Map<Integer, AbstractBook> genreBooks = new HashMap<>();
        for (AbstractBook book : bookCollection.values()) {
            if (book.getGenre().equals(genre)) {
                genreBooks.put(book.getId(), book);
            }
        }
        return genreBooks;
    }

    @Override
    public void deleteBook(AbstractBook book) throws Exception {
        nullBookValidation(book);
        bookCollection.remove(book.getId());
        System.out.println("Book " + book.getName() + " was removed");
    }

    @Override
    public void deleteBookById(int id) throws Exception {
        negativeIdValidation(id);
        if (bookCollection.containsKey(id)) {
            bookCollection.remove(id);
            System.out.println("Book " + id + " was removed");
        } else {
            System.out.println("Book " + id + " does not exist");
        }
    }

    @Override
    public boolean bookWithNameExists(String name) throws Exception {
        bookNameNullValidation(name);
        for (AbstractBook book : bookCollection.values()) {
            if (name.equalsIgnoreCase(book.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<AbstractBook> findBooksByPriceRange(double minPrice, double maxPrice) throws Exception {
        if (minPrice < 0 && maxPrice <= minPrice) {
            throw new Exception("Invalid entering price range, Minimal price : " + minPrice + " Maximal Price: " + maxPrice);
        }
        List<AbstractBook> books = new ArrayList<>();
        for (AbstractBook book : bookCollection.values()) {
            if (book.bookInPriceRange(minPrice, maxPrice)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<AbstractBook> findBooksByGenreAndPriceRange(Genre genre, double minPrice, double maxPrice) throws Exception {
        genreNullPointerValidation(genre);
        if (minPrice < 0 && maxPrice <= minPrice) {
            throw new Exception("Invalid entering price range, Minimal price : " + minPrice + " Maximal Price: " + maxPrice);
        }
        List<AbstractBook> books = new ArrayList<>();
        for (AbstractBook book : bookCollection.values()) {
            if (book.bookInPriceRangeAndOfGenre(genre, minPrice, maxPrice)) {
                books.add(book);
            }
        }
        return books;
    }


    private void bookNameNullValidation(String name) throws Exception {
        if (name == null || name.isEmpty())
            throw new InvalidValueException("Name is required");
    }

    private void nullBookValidation(AbstractBook book) throws Exception {
        if (book == null)
            throw new InvalidValueException("The book can not to be null");
    }

    private void genreNullPointerValidation(Genre genre) throws Exception {
        if (genre == null)
            throw new InvalidValueException("The genre can no to be null");
    }

    private void negativeIdValidation(int id) throws Exception {
        if (id < 0)
            throw new InvalidValueException("Invalid id value");
    }
}
