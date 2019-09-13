package unit_testing.oop.negative_scenario;

import org.junit.Test;
import undemy9_10.Exception.InvalidValueException;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

public class FindBookByPriceRangeTest {

    @Test(expected = InvalidValueException.class)
    public void findBookByInvalidMinPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBooksByPriceRange(500, 296);
    }

    @Test(expected = InvalidValueException.class)
    public void findBookByNegativePrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBooksByPriceRange(-35, 150);
    }

    @Test(expected = InvalidValueException.class)
    public void findBookByGenreAndInvalidMinPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBooksByGenreAndPriceRange(Genre.DETECTIVE, 500, 296);
    }

    @Test(expected = InvalidValueException.class)
    public void findBookByGenreAndNegativePrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBooksByGenreAndPriceRange(Genre.DETECTIVE, -35, 150);
    }

    @Test(expected = InvalidValueException.class)
    public void findBookByGenreAndPriceEmptyGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        bookStore.findBooksByGenreAndPriceRange(null, 200, 296);
    }
}