package oop;

public class Floor {
    private double width;
    private double length;

    public Floor(double width, double length) throws Exception {
        if (width < 0) {
            throw new Exception("Width ca not be " + width);
        } else {
            this.width = width;
        }
        if (length < 0) {
            throw new Exception("Length ca not be " + width);
        } else {
            this.length = length;
        }
    }

    public double getArea() {
        return this.width * this.length;
    }
}
