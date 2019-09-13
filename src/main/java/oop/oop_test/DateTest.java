package oop.oop_test;

import oop.DateTime;

public class DateTest {
    public static void main(String[] args) throws Exception {
        DateTime dateTime = new DateTime(3, 2, 1990, 12, 5, 06);
        System.out.println(dateTime.displayDate());
        System.out.println(dateTime.displayTime());

        DateTime dataAndTime = new DateTime(35, 102, 2360, 13, 5, 68);
        System.out.println(dataAndTime.displayDate());
        System.out.println(dataAndTime.displayTime());

        DateTime dateTime2 = new DateTime();
        System.out.println(dateTime2.getCurrentDateTime());
    }
}
