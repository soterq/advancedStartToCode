package undemy9_10.interfacemethods;

import undemy9_10.enums.ShapeType;

public class Circle implements Shape {
    private double radius;
    private ShapeType shapeType;

    public Circle(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("Impossible to create circle with " + radius + " radius");
        }
        this.radius = radius;
        setShapeType(ShapeType.CIRCLE);
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

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }


}
