package undemy9_10.test;

import undemy9_10.abstractmethods.AbstractBook;
import undemy9_10.abstractmethods.AbstractBookStore;
import undemy9_10.abstractmethods.AbstractBookStoreImpl;
import undemy9_10.enums.Genre;

public class AbstractBookStoreTest {
    public static void main(String[] args) throws Exception {
        AbstractBookStore abstractBook = new AbstractBookStoreImpl();
        AbstractBook book1 = new AbstractBook("The Humans", Genre.FANTASY, 322);
        AbstractBook book2 = new AbstractBook("No one", Genre.HORROR, 320);
        AbstractBook book3 = new AbstractBook("The live", Genre.DETECTIVE, 513);
        AbstractBook book4 = new AbstractBook("James", Genre.DETECTIVE, 125);
        AbstractBook book5 = new AbstractBook("Born", Genre.DETECTIVE, 135);
        AbstractBook book6 = new AbstractBook("007", Genre.ACTION, 116);

        abstractBook.addBook(book1);
        abstractBook.addBook(book2);
        abstractBook.addBook(book3);
        abstractBook.addBook(book4);
        abstractBook.addBook(book5);
        abstractBook.addBook(book6);

    }
}
