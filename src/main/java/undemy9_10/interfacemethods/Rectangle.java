package undemy9_10.interfacemethods;

import undemy9_10.enums.ShapeType;

public class Rectangle implements Shape {
    private double length;
    private double width;
    private ShapeType shapeType;

    public Rectangle(double length, double width) throws Exception {
        if (length <= 0) {
            throw new Exception("Impossible to create rectangle with " + length + " length");
        }
        if (width <= 0) {
            throw new Exception("Impossible to create rectangle with " + width + " width");
        }

        this.length = length;
        this.width = width;
        setShapeType(ShapeType.RECTANGLE);
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
        System.out.println("Area : " + calculateArea() + ", Shape Type : " + shapeType);
    }

    @Override
    public void showPerimeter() {
        System.out.println("Perimeter : " + calculatePerimeter() + ", Shape Type : " + shapeType);
    }

    @Override
    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
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

    public ShapeType getShapeType() {
        return shapeType;
    }

}
