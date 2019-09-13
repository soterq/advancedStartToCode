package unit_testing.task5.negative_scearios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;

import tasks_for_weeks.task5.TaskReporter;
import tasks_for_weeks.task5.TaskReporterImpl;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;


public class AddNoteTest {
    private Person alex;
    private TaskReporter taskReporter;
    private Task task;
    private Duration duration;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man",Role.WEB_DEV, Department.QA,"123");
        taskReporter = new TaskReporterImpl();
        duration = new Duration(8, 0);
        task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);

    }

    @Test(expected = IllegalActionException.class)
    public void addNoteToUnExistingTask() throws Exception {
        taskReporter.addTask(task);
        String comment = "Background color should be blue";
        Note note1 = new Note(alex, comment);
        taskReporter.addNoteToSpecificTask(999, note1);

        Assert.assertEquals(String.valueOf(taskReporter.getTaskList().get(0).getNotes().get(1).getNote()), comment);
    }

    @Test(expected = IllegalActionException.class)
    public void addReplyNoteToUnExistingTask() throws Exception {
        taskReporter.addTask(task);
        String comment = "Background color should be blue";
        Note note1 = new Note(alex, comment);
        taskReporter.addNoteToSpecificTask(0, note1);
        String replyMessage = "No, it need be aqua";
        Reply reply = new Reply(alex, replyMessage);

        taskReporter.addReplyToSpecificNote(0, 999, reply);

        Assert.assertEquals(String.valueOf(taskReporter.getTaskList().get(0).getNotes().get(0).getReplay().get(0).getComment()), replyMessage);

    }

}
