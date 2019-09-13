package unit_testing.task5.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.objects.Person;

public class AddNewPersonTest {
    @Test()
    public void addNewPerson() throws Exception {
        TaskReporter taskReporter = new TaskReporterImpl();
        Person person = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        taskReporter.addPerson(person);

        Person person1 = taskReporter.getPerson("Alex_man");

        Assert.assertNotNull(person1);
    }
}
