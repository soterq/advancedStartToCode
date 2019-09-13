package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;
import undemy9_10.Exception.BookNotFoundException;


public class DeleteBookTest {
    @Test(expected = BookNotFoundException.class)
    public void deleteBook() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        int idBookForDeleting = book2.getId();
        bookStore.deleteBook(book2);

        Assert.assertNotEquals(book2, bookStore.findBookById(idBookForDeleting));
    }
}