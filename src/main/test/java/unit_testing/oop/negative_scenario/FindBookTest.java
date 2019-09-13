package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.BookNotFoundException;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

public class FindBookTest {
    @Test(expected = InvalidValueException.class)
    public void findBookByEmptyName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.deleteBook(null);
    }

    @Test(expected = InvalidValueException.class)
    public void findBookByNegativeId() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBookById(-36);
    }

    @Test(expected = BookNotFoundException.class)
    public void findBookByUnExistingId() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBookById(3500);
    }

    @Test(expected = BookNotFoundException.class)
    public void findBookByUnExistingName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBookByName("Find Me!");
    }
}