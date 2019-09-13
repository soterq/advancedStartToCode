package unit_testing.task5.negative_scearios;

import org.junit.Before;
import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.Duration;
import tasks_for_weeks.task5.objects.Note;
import tasks_for_weeks.task5.objects.Person;
import tasks_for_weeks.task5.objects.Task;

public class ExportAndImportDataTest {
    private Person alex;
    private TaskReporter taskReporter;
    private Task task;
    private Duration duration;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA,"123");
        taskReporter = new TaskReporterImpl();
        duration = new Duration(8, 0);
        task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        taskReporter.addTask(task);
    }

    @Test(expected = IllegalActionException.class)
    public void exportData() throws Exception {

        Note note = new Note(alex, "It need to be done faster");
        taskReporter.addNoteToSpecificTask(0, note);
        String path = "C:/Users/vitalies";

        taskReporter.exportData(path);

    }

    @Test(expected = IllegalActionException.class)
    public void importData() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        String path = "C:/Users/vitalies/TaskRepository.json";
        bugReporter.loadTaskData(path);
    }

    @Test(expected = IllegalActionException.class)
    public void importDataWithBrokenJson() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task5/TaskRepository1.json";
        bugReporter.loadTaskData(path);
    }
}
