package undemy9_10.interfacemethods;

import undemy9_10.Exception.*;
import undemy9_10.enums.Genre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookStoreImpl implements BookStore {

    private Map<Integer, Book> bookCollection = new HashMap<>();

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookCollection.values());
    }

    @Override
    public void addBook(Book book) throws InvalidValueException {
        nullBookValidation(book);
        if (!bookCollection.keySet().contains(book.getId())) {
            bookCollection.put(book.getId(), book);
            System.out.println(book.toString() + " was added");
        } else {
            System.out.println("This book already exists ");
        }
    }

    @Override
    public Book findBookByName(String name) throws InvalidValueException, BookNotFoundException {
        bookNameNullValidation(name);
        for (Book book : bookCollection.values()) {
            if (name.equalsIgnoreCase(book.getName())) {
                return book;
            }
        }
        throw new BookNotFoundException("Book " + name + " not found");
    }

    @Override
    public Book findBookById(int id) throws InvalidValueException, BookNotFoundException {
        negativeIdValidation(id);
        for (Book book : bookCollection.values()) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found");
    }

    @Override
    public List<Book> getBooksByGenre(Genre genre) throws InvalidValueException {
        genreNullPointerValidation(genre);
        List<Book> books = new ArrayList<>();
        for (Book book : bookCollection.values()) {
            if (book.getGenre().equals(genre)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public void deleteBook(Book book) throws InvalidValueException, BookNotFoundException {
        nullBookValidation(book);
        if (bookWithNameExists(book.getName())) {
            bookCollection.remove(book.getId());
            System.out.println("Book " + book.getName() + " was removed");
        } else {
            throw new BookNotFoundException("Book " + book.getName() + " does not exist");
        }
    }

    @Override
    public void deleteBookById(int id) throws InvalidValueException, BookNotFoundException {
        negativeIdValidation(id);
        if (bookCollection.containsKey(id)) {
            bookCollection.remove(id);
            System.out.println("Book " + id + " was removed");
        } else {
            throw new BookNotFoundException("Book with id '" + id + "' does not exist");
        }
    }

    @Override
    public boolean bookWithNameExists(String name) throws InvalidValueException {
        bookNameNullValidation(name);
        for (Book book : bookCollection.values()) {
            if (name.equalsIgnoreCase(book.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Book> findBooksByPriceRange(double minPrice, double maxPrice) throws InvalidValueException {
        if (minPrice < 0 || maxPrice < minPrice) {
            throw new InvalidValueException("Invalid entering price range, Minimal price : " + minPrice + " Maximal Price: " + maxPrice);
        }
        List<Book> books = new ArrayList<>();
        for (Book book : bookCollection.values()) {
            if (book.bookInPriceRange(minPrice, maxPrice)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> findBooksByGenreAndPriceRange(Genre genre, double minPrice, double maxPrice) throws InvalidValueException {
        genreNullPointerValidation(genre);
        if (minPrice < 0 || maxPrice < minPrice) {
            throw new InvalidValueException("Invalid entering price range, Minimal price : " + minPrice + " Maximal Price: " + maxPrice);
        }
        List<Book> books = new ArrayList<>();
        for (Book book : bookCollection.values()) {
            if (book.bookInPriceRangeAndOfGenre(genre, minPrice, maxPrice)) {
                books.add(book);
            }
        }
        return books;
    }

    private void bookNameNullValidation(String name) throws InvalidValueException {
        if (name == null || name.isEmpty())
            throw new InvalidValueException("Name is required");
    }

    private void nullBookValidation(Book book) throws InvalidValueException {
        if (book == null)
            throw new InvalidValueException("The book can not to be null");
    }

    private void genreNullPointerValidation(Genre genre) throws InvalidValueException {
        if (genre == null)
            throw new InvalidValueException("The genre can no to be null");
    }

    private void negativeIdValidation(int id) throws InvalidValueException {
        if (id < 0)
            throw new InvalidValueException("Invalid id value");
    }
}
