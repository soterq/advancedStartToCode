package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

import java.util.ArrayList;
import java.util.List;

import static undemy9_10.enums.Genre.*;

public class GetBooksByGenreTest {
    @Test
    public void getBooksByDetectiveGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The live", ACTION, 300);
        Book book2 = new Book("The Homes", DETECTIVE, 255);
        Book book3 = new Book("The live", FANTASY, 255);
        Book book4 = new Book("The live", DETECTIVE, 255);
        Book book5 = new Book("The Moon", DETECTIVE, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);
        bookStore.addBook(book5);

        List<Book> books = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(DETECTIVE)) {
                books.add(book);
            }
        }
        Assert.assertEquals(books, bookStore.getBooksByGenre(DETECTIVE));
    }
    @Test
    public void getBooksByActionGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The live", ACTION, 300);
        Book book2 = new Book("007", DETECTIVE, 255);
        Book book3 = new Book("The live", DETECTIVE, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);

        List<Book> books = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(ACTION)) {
                books.add(book);
            }
        }
        Assert.assertEquals(books, bookStore.getBooksByGenre(ACTION));
    }
    @Test
    public void getBooksFantasyByGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The live", ACTION, 300);
        Book book2 = new Book("The live", DETECTIVE, 255);
        Book book3 = new Book("The live", FANTASY, 255);
        Book book4 = new Book("Live on the sun", FANTASY, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);


        List<Book> books = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(FANTASY)) {
                books.add(book);
            }
        }
        Assert.assertEquals(books, bookStore.getBooksByGenre(FANTASY));
    }
    @Test
    public void getBooksByHorrorGenre() throws Exception {
        BookStore bookStore = new BookStoreImpl();

        Book book1 = new Book("The live", ACTION, 300);
        Book book2 = new Book("007", ACTION, 300);
        Book book3 = new Book("The live", FANTASY, 255);
        Book book4 = new Book("The live", HORROR, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);

        List<Book> books = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(HORROR)) {
                books.add(book);
            }
        }
        Assert.assertEquals(books, bookStore.getBooksByGenre(HORROR));
    }
}