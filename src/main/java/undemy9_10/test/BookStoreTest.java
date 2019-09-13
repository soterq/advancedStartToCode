package undemy9_10.test;

import undemy9_10.interfacemethods.Book;
import undemy9_10.interfacemethods.BookStore;
import undemy9_10.interfacemethods.BookStoreImpl;
import undemy9_10.enums.Genre;

public class BookStoreTest {

    public static void main(String[] args) throws Exception {
        BookStore bookStore = new BookStoreImpl();
        bookStore.getAllBooks();

        Book book1 = new Book("The Humans", Genre.FANTASY, 322);
        Book book2 = new Book("No one", Genre.HORROR, 320);
        Book book3 = new Book("The live", Genre.DETECTIVE, 513);
        Book book4 = new Book("James", Genre.DETECTIVE, 125);
        Book book5 = new Book("Born", Genre.DETECTIVE, 135);
        Book book6 = new Book("007", Genre.ACTION, 116);

        bookStore.addBook(book1);
        bookStore.addBook(book2);
        bookStore.addBook(book3);
        bookStore.addBook(book4);
        bookStore.addBook(book5);
        bookStore.addBook(book6);

        bookStore.deleteBook(book6);

        bookStore.getAllBooks();
        System.out.println();

        bookStore.getBooksByGenre(Genre.DETECTIVE);
        System.out.println();

        Book book7 = new Book("Candy", Genre.FANTASY, 150);
        bookStore.addBook(book7);

        System.out.println(bookStore.findBookByName("Candy"));
        System.out.println();


        System.out.println(bookStore.findBookByName("candy"));

        System.out.println();
        bookStore.deleteBook(book2);

        System.out.println(bookStore.findBookByName("James"));
        System.out.println();

        System.out.println(bookStore.bookWithNameExists("The live"));

        bookStore.findBooksByPriceRange(100, 250);

        bookStore.findBooksByGenreAndPriceRange(Genre.FANTASY, 100, 200);

    }
    // Custom Exceptions
    //validate input
    //Unit test pentru fircare book store action scenarii negative / pos
}