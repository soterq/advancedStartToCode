package tasks_for_weeks.task2;

import com.fasterxml.jackson.annotation.*;
import tasks_for_weeks.exceptions.InvalidInputException;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
   //id
    private String name;
    private int age;
    private List<String> countries;

    public String getName() {
        return name;
    }

    @JsonSetter(value = "Name", nulls = Nulls.AS_EMPTY)
    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    @JsonSetter(value = "Age", nulls = Nulls.AS_EMPTY)
    public void setAge(int age) {
        this.age = age;
    }


    public List<String> getCountries() {
        return countries;
    }

    @JsonSetter(value = "Countries", nulls = Nulls.AS_EMPTY)
    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", countries=" + countries;
    }

    public Employee() {
    }

    public Employee(String name, int age, List<String> countries) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Name can not be empty");
        }
        if (age < 0) {
            throw new InvalidInputException("Age can not be negative value");
        }
        this.name = name;
        this.age = age;
        this.countries = countries;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(countries, employee.countries);
    }

}
