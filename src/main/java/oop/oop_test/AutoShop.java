package oop.oop_test;

import oop.Car;
import oop.Ford;
import oop.Sedan;
import oop.Truck;

import java.util.ArrayList;
import java.util.List;

public class AutoShop {
    public static void main(String[] args) throws Exception {
        List<Car> cars = new ArrayList<>();
        cars.add(new Truck(150, "white", 5000, 1500));
        cars.add(new Truck(150, "white", 5000, 1500));
        cars.add(new Ford(250, "blue", 3000, 2005, 10));
        cars.add(new Ford(255, "red", 2500, 2004, 15));
        cars.add(new Sedan(270, "black", 3600, 6));
        cars.add(new Sedan(300, "white", 4200, 5));


        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }
}
