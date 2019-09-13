package unit_testing.oop.positive_scenario;

import org.junit.Assert;
import org.junit.Test;
import undemy9_10.enums.Genre;
import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;

import java.util.ArrayList;
import java.util.List;

public class FindBookByPriceRangeTest {
    @Test
    public void findBookByFixedPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);
        Book book4 = new Book("Moon", Genre.DETECTIVE, 296);
        Book book5 = new Book("David Copperfield", Genre.DETECTIVE, 300);
        Book book6 = new Book("Oceans", Genre.DETECTIVE, 255);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);
        bookStore.addBook(book5);
        bookStore.addBook(book6);

        List<Book> booksCollection = new ArrayList<>();

        for (Book book : bookStore.getAllBooks()) {
            if (book.getPrice() == 296) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByPriceRange(296, 296));
    }

    @Test
    public void findBookByPriceRange() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("Forward", Genre.DETECTIVE, 296);
        Book book4 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);

        List<Book> booksCollection = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getPrice() > 0 && book.getPrice() <= 296) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByPriceRange(0, 296));
    }

    @Test
    public void findBookByGenreAndPriceRange() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("Forward", Genre.DETECTIVE, 296);
        Book book4 = new Book("The live", Genre.DETECTIVE, 203);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);

        List<Book> booksCollection = new ArrayList<>();
        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(Genre.DETECTIVE) && book.getPrice() >= 50 && book.getPrice() <= 296) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByGenreAndPriceRange(Genre.DETECTIVE, 50, 296));
    }

    @Test
    public void findBookByGenreAndFixedPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 203);
        Book book4 = new Book("The live", Genre.DETECTIVE, 296);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);

        List<Book> booksCollection = new ArrayList<>();

        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(Genre.DETECTIVE) && book.getPrice() == 296) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByGenreAndPriceRange(Genre.DETECTIVE, 296, 296));
    }

    @Test
    public void findBookByHorrorGenreAndFixedPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);

        bookStore.addBook(book1);
        bookStore.addBook(book2);

        List<Book> booksCollection = new ArrayList<>();

        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(Genre.HORROR) && book.getPrice() == 320) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByGenreAndPriceRange(Genre.HORROR, 320, 320));
    }

    @Test
    public void findBookByActionGenreAndFixedPrice() throws Exception {
        BookStore bookStore = new BookStoreImpl();
        Book book1 = new Book("The Humans", Genre.ACTION, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);

        bookStore.addBook(book1);
        bookStore.addBook(book2);

        List<Book> booksCollection = new ArrayList<>();

        for (Book book : bookStore.getAllBooks()) {
            if (book.getGenre().equals(Genre.ACTION) && book.getPrice() == 322) {
                booksCollection.add(book);
            }
        }
        Assert.assertEquals(booksCollection, bookStore.findBooksByGenreAndPriceRange(Genre.ACTION, 322, 322));
    }
}
