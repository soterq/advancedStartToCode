package oop;

import oop.Circle;

public class Cylinder extends Circle {

    private double height;

    public Cylinder(double radius, double height) throws Exception {
        super(radius);
        if (height == 0) {
            throw new Exception("your number" + height + " is not valid for height");
        } else
            this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return this.height * getArea();
    }
}
