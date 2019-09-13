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

public class ChangeTaskStateTest {
    @Test
    public void changeTaskState() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        Person alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        Duration duration = new Duration( 8,0);
        Task issue = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        bugReporter.addTask(issue);

        Assert.assertEquals(bugReporter.getTaskList().get(0).getState(), TaskState.CREATED);

        bugReporter.changeTaskState(0, TaskState.IN_PROGRESS);

        Assert.assertEquals(bugReporter.getTaskList().get(0).getState(), TaskState.IN_PROGRESS);

        bugReporter.changeTaskState(0, TaskState.COMPLETED);
        Assert.assertEquals(bugReporter.getTaskList().get(0).getState(), TaskState.COMPLETED);

    }
}
