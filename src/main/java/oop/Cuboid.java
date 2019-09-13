package oop;

public class Cuboid extends Rectangle {
    private double height;

    public Cuboid(double width, double length, double height) throws Exception {
        super(width, length);
        if (height < 0) {
            throw new Exception("your number" + height + " is not valid for height");
        }
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume() {
        return getArea() * height;
    }
}
