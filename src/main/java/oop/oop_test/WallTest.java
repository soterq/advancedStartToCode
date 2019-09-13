package oop.oop_test;

import oop.Wall;

public class WallTest {
    public static void main(String[] args) throws Exception {
        Wall wall = new Wall( 5,4);
        System.out.println("area=" +wall.getArea());

        wall.setHeight(-1.5);
        System.out.println("width=" + wall.getWidth());
        System.out.println("height=" + wall.getHeight());
        System.out.println("width=" + wall.getArea());
    }
}
