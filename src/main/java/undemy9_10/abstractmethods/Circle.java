package undemy9_10.abstractmethods;

import undemy9_10.enums.ShapeType;


public class Circle extends Shape {

    private double radius;

    public Circle(double radius) throws Exception {
        super(ShapeType.CIRCLE);
        if (radius <= 0) {
            throw new Exception("Impossible to create circle with " + radius + " radius");
        }
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void showArea() {
        System.out.println("Area : " + calculateArea() + ", Shape Type : " + getShapeType());
    }

    @Override
    public void showPerimeter() {
        System.out.println("Perimeter : " + calculatePerimeter() + ", Shape Type : " + getShapeType());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
