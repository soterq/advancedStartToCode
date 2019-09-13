package undemy9_10.generic;

public class Typography {

    public static void main(String[] args) {
        Sheets sheets = new Sheets();
        ThinCover thinCover = new ThinCover();
        NormalCover normalCover = new NormalCover();
        ThickCover thickCover = new ThickCover();

        thickCover.hardness();
        normalCover.gloss();
        thinCover.color();

        Book<ThickCover> book = new Book<>(thickCover, sheets);
        Book<NormalCover> book2 = new Book<>(normalCover, sheets);
        Book<ThinCover> book3 = new Book<>(thinCover, sheets);

        book.getBookCover().hardness();
        book2.getBookCover().gloss();
        book3.getBookCover().color();

    }
}
