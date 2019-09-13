package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;

public class FindBookByNameTest {

    @Test
    public void findBookByName() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        bookStore.addBook(book1);
        bookStore.addBook(book2);

        Book wantedBook = null;
        String name = "The Humans";

        for (Book book : bookStore.getAllBooks()) {
            if (book.getName().equals(name)) {
                wantedBook = book;
            }
        }
        Assert.assertEquals(wantedBook, bookStore.findBookByName(name));
    }
}