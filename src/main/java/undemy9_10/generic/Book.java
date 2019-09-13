package undemy9_10.generic;

public class Book<T extends  BookCover> {

    private T bookCover;
    private Sheets sheets;

    public Book(T bookCover, Sheets sheets) {
        this.bookCover = bookCover;
        this.sheets = sheets;
    }

    public T getBookCover() {
        return bookCover;
    }

    public void setBookCover(T bookCover) {
        this.bookCover = bookCover;
    }

    public Sheets getSheets() {
        return sheets;
    }

    public void setSheets(Sheets sheets) {
        this.sheets = sheets;
    }
}
