package undemy9_10.abstractmethods;

import undemy9_10.enums.Genre;

import java.util.Random;

public class AbstractBook {
    private Genre genre;
    private final int id;
    private String name;
    private double price;

    public AbstractBook(String name, Genre genre, double price) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Name is required");
        }
        if (price < 0) {
            throw new Exception("Invalid entering price data : '" + price + '\'');
        }

        this.genre = genre;
        this.name = name;
        this.price = price;
        this.id = random();
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "genre='" + genre + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price + '}'
                ;
    }

    private int random() {
        Random r = new Random();
        int low = 1;
        int high = 1000;
        int random;
        random = r.nextInt(high - low) + low;
        return random;
    }


    boolean bookInPriceRange(double minPrice, double maxPrice) {
        return getPrice() >= minPrice && getPrice() <= maxPrice;
    }

    boolean bookInPriceRangeAndOfGenre(Genre genre, double minPrice, double maxPrice) {
        return bookInPriceRange(minPrice, maxPrice) && getGenre() == genre;
    }
}
