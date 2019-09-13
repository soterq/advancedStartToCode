package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;

public class GetBooksByNullGenreTest {
    @Test(expected = InvalidValueException.class)
    public void getBooksByNullGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The live", Genre.DETECTIVE, 300);
        Book book2 = new Book("The live", Genre.DETECTIVE, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);

        bookStore.getBooksByGenre(null);
    }
}
