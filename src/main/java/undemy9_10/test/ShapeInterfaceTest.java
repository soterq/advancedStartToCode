package undemy9_10.test;

import undemy9_10.interfacemethods.Circle;
import undemy9_10.interfacemethods.Rectangle;
import undemy9_10.interfacemethods.Square;

public class ShapeInterfaceTest {
    public static void main(String[] args) throws Exception {
        Circle circleClass = new Circle(2.5);
        circleClass.showArea();
        circleClass.showPerimeter();

        Rectangle rectangle = new Rectangle(2, 6);
        rectangle.showArea();
        rectangle.showPerimeter();

        Square square = new Square(6);
        square.showArea();
        square.showPerimeter();

    }
}
