package oop.oop_test;

import oop.Person;

public class PersonTest {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        person.setAge(10);
        person.setAge(110);
        System.out.println(person.getAge());

        System.out.println("Full name =  " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setFirstName("John");
        person.setAge(18);
        System.out.println("Full name =  " + person.getFullName());
        System.out.println("teen= " + person.isTeen());
        person.setLastName("Smith");
        System.out.println("Full name =  " + person.getFullName());

    }
}
