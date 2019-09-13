package oop;

public class Truck extends Car {
    private double weight;

    public Truck(int speed, String color, int realPrice, double weight) throws Exception {
        super(speed, color, realPrice);
        this.weight = weight;
    }

    public double getSalePrice() {
        if (weight > 2000) {
            return super.salePriceDiscount(20);
        }
        return super.salePriceDiscount(10);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" + "sale price " + getSalePrice() +
                super.toString() +
                ", weight=" + weight +
                '}';
    }
}
