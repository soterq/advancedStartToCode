package undemy9_10.interfacemethods;

import undemy9_10.enums.ShapeType;

public interface Shape {
    double calculateArea();

    double calculatePerimeter();

    void showArea();

    void showPerimeter();

    void setShapeType(ShapeType shapeType);
}
