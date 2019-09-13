package unit_testing.task5.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.Duration;
import tasks_for_weeks.task5.objects.Person;
import tasks_for_weeks.task5.objects.Task;

public class DurationTest {

    @Test
    public void deleteNote() throws Exception {
        TaskReporter taskReporter = new TaskReporterImpl();

        Duration duration = new Duration(1, 100);
        Person person = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        Task task = new Task("Menu", "All page should have menu in the left side of the page", TaskPriority.MEDIUM, duration, TaskState.CREATED, person,person);
        taskReporter.addTask(task);

        Assert.assertEquals(duration.getHour(), 2);
        Assert.assertEquals(duration.getMinutes(), 40);
    }

}
