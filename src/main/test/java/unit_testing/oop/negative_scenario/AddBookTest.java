package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

public class AddBookTest {

    @Test(expected = InvalidValueException.class)
    public void addBookByEmptyName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
    }

    @Test(expected = InvalidValueException.class)
    public void addBookNullName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book(null, Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
    }

    @Test(expected = InvalidValueException.class)
    public void addBookNullGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("One time", null, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

    }

    @Test(expected = InvalidValueException.class)
    public void addBookNegativePrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, -1);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
    }

    @Test(expected = InvalidValueException.class)
    public void addNullBook() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        bookStore.addBook(null);
    }
}