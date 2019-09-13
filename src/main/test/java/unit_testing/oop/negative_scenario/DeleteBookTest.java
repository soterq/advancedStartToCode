package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.BookNotFoundException;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

public class DeleteBookTest {

    @Test(expected = InvalidValueException.class)
    public void deleteBookByNegativeId() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.deleteBookById(-1);
    }

    @Test(expected = BookNotFoundException.class)
    public void deleteBookUnExistingId() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.deleteBookById(3500);
    }

    @Test(expected = InvalidValueException.class)
    public void deleteBookByNullName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.deleteBook(null);
    }

    @Test(expected = BookNotFoundException.class)
    public void deleteUnExistingBook() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);
        Book book4 = new Book("Unauthorized", Genre.FANTASY, 99999);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.deleteBook(book4);
    }
}