package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;

public class AddBookTest {
    @Test
    public void addBook() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        bookStore.addBook(book1);

        int bookId = book1.getId();
        Assert.assertEquals(book1, bookStore.findBookById(bookId));
    }
}