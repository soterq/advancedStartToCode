package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

import java.util.List;

import static undemy9_10.enums.Genre.*;

public class GetAllBooksTest {
    @Test
    public void getAllBooks() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", FANTASY, 322);
        Book book2 = new Book("No one", HORROR, 320);
        Book book3 = new Book("The live", DETECTIVE, 203);
        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        int sizeOtTheStore = 3;

        Assert.assertEquals(bookStore.getAllBooks().size(), sizeOtTheStore);
    }

    @Test
    public void getAllBooksFromEmptyCollection() {
        BookStore bookStore = new BookStoreImpl();
        List<Book> list = bookStore.getAllBooks();
        Assert.assertTrue(list.isEmpty());
    }
}
