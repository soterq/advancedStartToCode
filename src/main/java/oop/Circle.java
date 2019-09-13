package oop;

public class Circle {
    double radius;

    public Circle(double radius) throws Exception {
        if (radius < 0) {
            throw new Exception("number" + radius + " is not a valid value for radius");
        } else {
            this.radius = radius;
        }
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return ((radius * radius) * Math.PI);
    }

}
