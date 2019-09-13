package oop;

import java.util.Calendar;

public class Ford extends Car {
    private int year;
    private int manufacturerDiscount;

    public Ford(int speed, String color, int realPrice, int year, int manufacturerDiscount) throws Exception {
        super(speed, color, realPrice);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year > currentYear) {
            throw new Exception("Entered year " + year + " is invalid");
        } else {
            this.year = year;
        }
        if (manufacturerDiscount < 0) {
            throw new Exception("your discount" + manufacturerDiscount + " should be more than 0");
        }
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public Ford(int speed, String color, int realPrice, int year) throws Exception {
        super(speed, color, realPrice);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year < currentYear || year < 1500) {
            throw new Exception("Entered year " + year + " is invalid");
        }
        this.year = year;

    }

    public int getYear() {
        return year;
    }

    public double getSalePrice() {
        return super.salePriceDiscount(this.manufacturerDiscount);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public void setManufacturerDiscount(int manufacturerDiscount) {
        this.manufacturerDiscount = manufacturerDiscount;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "Price with manufacturer discount " + getSalePrice() +
                super.toString() +
                ", Year=" + year +
                '}';
    }
}
