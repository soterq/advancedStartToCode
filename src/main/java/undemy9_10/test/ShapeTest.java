package undemy9_10.test;

import undemy9_10.abstractmethods.Circle;
import undemy9_10.abstractmethods.Rectangle;
import undemy9_10.abstractmethods.Square;

public class ShapeTest {
    public static void main(String[] args) throws Exception {
        Circle circle = new Circle(6);
        circle.showArea();
        circle.showPerimeter();

        Rectangle rectangle = new Rectangle(2, 6);
        rectangle.showArea();
        rectangle.showPerimeter();

        Square square = new Square(5);
        square.showArea();
        square.showPerimeter();

    }
}
