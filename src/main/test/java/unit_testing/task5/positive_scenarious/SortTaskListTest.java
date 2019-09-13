package unit_testing.task5.positive_scenarious;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.Duration;
import tasks_for_weeks.task5.objects.Person;
import tasks_for_weeks.task5.objects.Task;

public class SortTaskListTest {
    private TaskReporter taskReporter;

    @Before
    public void init() throws Exception {
        taskReporter = new TaskReporterImpl();

        Person alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        Person ana = new Person("Ana", "Man", "Ana_man", Role.WEB_DEV, Department.QA, "123");
        Person derrick = new Person("Derrick", "Man", "Derrick_man", Role.WEB_DEV, Department.QA, "123");
        Person marry = new Person("Marry", "Man", "Mary_man", Role.WEB_DEV, Department.QA, "123");
        Duration duration = new Duration(8, 0);

        Task login = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        Task logout = new Task("Logout page", "User should be able to logout from his account", TaskPriority.CRITICAL, duration, TaskState.CREATED, ana,ana);
        Task goHome = new Task("goHome btn", "On all page should be button goHome btn to login page", TaskPriority.MEDIUM, duration, TaskState.CREATED, derrick,derrick);
        Task info = new Task("Info page", "Informational page should contains information about company", TaskPriority.LOW, duration, TaskState.CREATED, marry,marry);

        taskReporter.addTask(login);
        taskReporter.addTask(logout);
        taskReporter.addTask(goHome);
        taskReporter.addTask(info);

    }

    @Test
    public void ascendingSortingIssue() {

        taskReporter.sortDescendingByPriority();

        Assert.assertEquals(taskReporter.getTaskList().get(taskReporter.getTaskList().size() - 1).getPriority(), TaskPriority.LOW);
        Assert.assertEquals(taskReporter.getTaskList().get(0).getPriority(), TaskPriority.CRITICAL);
    }

    @Test
    public void descendingSortingIssue() {
        taskReporter.sortAscendingByPriority();

        Assert.assertEquals(taskReporter.getTaskList().get(taskReporter.getTaskList().size() - 1).getPriority(), TaskPriority.CRITICAL);
        Assert.assertEquals(taskReporter.getTaskList().get(0).getPriority(), TaskPriority.LOW);

    }

}
