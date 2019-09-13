package undemy9_10.abstractmethods;

import undemy9_10.enums.ShapeType;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) throws Exception {
        super(ShapeType.RECTANGLE);
        if (length <= 0) {
            throw new Exception("Impossible to create rectangle with " + length + " length");
        }
        if (width <= 0) {
            throw new Exception("Impossible to create rectangle with " + width + " width");
        }

        this.length = length;
        this.width = width;

    }


    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    @Override
    public void showArea() {
        System.out.println("Area : " + calculateArea() + ", Shape Type : " + getShapeType());
    }

    @Override
    public void showPerimeter() {
        System.out.println("Perimeter : " + calculatePerimeter() + ", Shape Type : " + getShapeType());
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
