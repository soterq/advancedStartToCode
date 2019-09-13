package unit_testing.task5.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.Duration;
import tasks_for_weeks.task5.objects.Person;
import tasks_for_weeks.task5.objects.Task;

public class ChangeNoteTest {
    @Test(expected = IllegalActionException.class)
    public void changeStatusFromUnExistingTask() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        Duration duration = new Duration(8, 0);
        Person alex = new Person("Alex", "Man", "Alex_man",Role.WEB_DEV, Department.QA,"123");
        Task task =  new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);

        bugReporter.addTask(task);

        bugReporter.changeTaskState(3, TaskState.IN_PROGRESS);

    }
}
