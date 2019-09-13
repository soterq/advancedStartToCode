package unit_testing.oop.positive_scenario;

import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookExistTest {

    @Test
    public void bookExist() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);
        Book book4 = new Book("James", Genre.DETECTIVE, 125);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);

        boolean bookCollectionContains = bookStore.bookWithNameExists("James");

        assertTrue(bookCollectionContains);
    }

    @Test
    public void unExistingBook() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        bookStore.addBook(book1);
        bookStore.addBook(book2);
        boolean bookCollectionContains = bookStore.bookWithNameExists("The detective");
        assertFalse(bookCollectionContains);
    }
}