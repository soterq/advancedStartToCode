package oop;

public class Point {
    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
    }

    public double distance(Point y) {
        return Math.sqrt(Math.pow(y.getX() - this.getX(), 2) + Math.pow(y.getY() - this.getY(), 2));
    }

    public double distance(double y, double z) {
        return Math.abs(Math.sqrt(Math.pow((this.getX() - y), 2) + (Math.pow(this.getY() - z, 2))));
    }

}
