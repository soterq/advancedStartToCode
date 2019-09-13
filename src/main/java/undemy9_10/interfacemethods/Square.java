package undemy9_10.interfacemethods;


import undemy9_10.enums.ShapeType;

public class Square extends Rectangle {

    public Square(double length) throws Exception {
        super(length, length);
        setShapeType(ShapeType.SQUARE);
    }
}