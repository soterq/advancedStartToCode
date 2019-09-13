package oop;

public class Car {
    private int speed;
    private String color;
    private double realPrice;

    public Car(int speed, String color, double realPrice) throws Exception {
        if (speed < 1) {
            throw new Exception("Speed should be more that" + speed);
        } else {
            this.speed = speed;
        }
        this.color = color;
        if (realPrice < 0) {
            throw new Exception("Price should be more that" + speed);
        }
        this.realPrice = realPrice;
    }

    public double getSalePrice() {
        return realPrice;
    }

    @Override
    public String toString() {
        return " Car description : " + "Speed=" + speed +
                ", Color='" + color + '\'' +
                ", Real price=" + realPrice;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double salePriceDiscount(int discount) {
        return this.realPrice - ((this.realPrice + (this.realPrice * discount)) / 100);
    }

}
