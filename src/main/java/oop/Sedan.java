package oop;

public class Sedan extends Car {
    private double length;

    public Sedan(int speed, String color, int realPrice, double length) throws Exception {
        super(speed, color, realPrice);
        if (length <= 1) {
            throw new Exception("please enter length more that" + length);
        } else {
            this.length = length;
        }
    }

    public double getSalePrice() {
        return this.length > 4 ? salePriceDiscount(5) : salePriceDiscount(10);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "Sale price " + getSalePrice() +
                super.toString() +
                ", Length=" + length +
                '}';
    }

}
