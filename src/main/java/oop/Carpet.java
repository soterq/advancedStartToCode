package oop;

public class Carpet {
    private double cost;

    public Carpet(double cost) throws Exception {
        if (cost < 0) {
            throw new Exception("price should be more than 0");
        }
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }
}
