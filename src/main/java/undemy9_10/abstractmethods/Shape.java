package undemy9_10.abstractmethods;

import undemy9_10.enums.ShapeType;

public abstract class Shape {
    private ShapeType shapeType;

    abstract double calculateArea();

    abstract double calculatePerimeter();

    abstract void showArea();

    abstract void showPerimeter();

    public Shape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }
}
