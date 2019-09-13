package oop.oop_test;

import oop.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) throws Exception {


        Employee employee1 = new Employee("Aleosa", "Popovici", 25, 560);
        Employee employee2 = new Employee("Mihail", "Cot", 32, 600);


        System.out.println(employee1.getMonthlySalary());
        System.out.println(employee2.getMonthlySalary());

        employee1.riseSalaryWith(10);
        employee2.riseSalaryWith(10);

        System.out.println(employee1.getYearlySalary());
        System.out.println(employee2.getYearlySalary());

        System.out.println(employee1.haveSameAgeAndSalary(employee2));

        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(employee1);
        employeesList.add(employee2);
        employeesList.add(new Employee("Michael", "Om", 25, 2864));
        employeesList.add(new Employee("William", "Popa", 18, 2019));
        employeesList.add(new Employee("Marin", "Om", 32, 777));
        employeesList.add(new Employee("Anatol", "Petrescu", 32, 666));
        employeesList.add(new Employee("Papa", "Rimskii", 24, 555));
        employeesList.add(new Employee("Mamba", "Mantra", 21, 950));
        employeesList.add(new Employee("Cristi", "Amen", 22, 630));
        employeesList.add(new Employee("Marin", "Sonii", 36, 325));

        Employee maxSalaryEmployee = employeesList.stream().max(Comparator.comparingDouble(Employee::getMonthlySalary)).get();
        Employee minSalaryEmployee = employeesList.stream().min(Comparator.comparingDouble(Employee::getMonthlySalary)).get();

        double average = employeesList.stream().mapToDouble(Employee::getAge).average().orElse(0.0);

        System.out.println("Max salary per employee" + maxSalaryEmployee);
        System.out.println("Min salary per employee" + minSalaryEmployee);
        System.out.println(average);

        //refacut
        Employee testEmployee = new Employee("Aleosa", "Tot", -35, 560);
        System.out.println(testEmployee);

    }


}
