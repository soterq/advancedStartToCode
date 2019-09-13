package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

public class BookExistTest {
    @Test(expected = InvalidValueException.class)
    public void bookExistByNullName() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("James", Genre.DETECTIVE, 125);

        bookStore.addBook(book1);
        bookStore.addBook(book2);

        bookStore.bookWithNameExists(null);
    }

    @Test(expected = InvalidValueException.class)
    public void BookNameNullException() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("James", Genre.DETECTIVE, 125);

        bookStore.addBook(book1);
        bookStore.addBook(book2);

        bookStore.bookWithNameExists("");
    }
}