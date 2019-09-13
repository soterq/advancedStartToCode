package oop;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private double monthlySalary;

    public Employee(String firstName, String lastName, int age, double monthlySalary) throws Exception {
        this.firstName = firstName;
        this.lastName = lastName;
        if (age <= 0) {
            throw new Exception("Invalid age : " + age);
        }
        this.age = age;
        if (monthlySalary < 0) {
            throw new Exception("Salary: " + monthlySalary + "is inadmissible");
        } else {
            this.monthlySalary = monthlySalary;
        }
    }

    @Override
    public String toString() {
        return
                "Full Name: " + firstName + " " + lastName +
                        ", Age: " + age +
                        ", Monthly Salary: " + monthlySalary;
    }

    public boolean haveSameAgeAndSalary(Employee employee) {
        return this.age == employee.age && this.monthlySalary == employee.getMonthlySalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void riseSalaryWith(int percentage) {
        setMonthlySalary(this.monthlySalary + (monthlySalary * percentage) / 100);
    }

    public double getYearlySalary() {
        return this.monthlySalary * 12;
    }
}
