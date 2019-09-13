package unit_testing.task5.positive_scenarious;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;

public class AddNoteTest {
    private Person alex;
    private Person marin;
    private TaskReporter bugReporter;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA,"123");
        marin =  alex = new Person("Marin", "Man", "Marin_man",Role.WEB_DEV, Department.QA,"123");
        bugReporter = new TaskReporterImpl();
        Duration duration = new Duration(8, 0);
        Task task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        bugReporter.addTask(task);
    }

    @Test
    public void addNoteToTask() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        String comment1 = "Login button should be blue";
        String comment2 = "Login button should be red";
        Note note = new Note(marin, comment1);
        Note note1 = new Note(alex, comment2);

        bugReporter.addNoteToSpecificTask(0, note);
        bugReporter.addNoteToSpecificTask(0, note1);

        Assert.assertEquals(String.valueOf(bugReporter.getTaskList().get(0).getNotes().get(0).getNote()), comment1);
        Assert.assertEquals(String.valueOf(bugReporter.getTaskList().get(0).getNotes().get(1).getNote()), comment2);
    }

    @Test
    public void addReplyNoteToTask() throws Exception {
        String comment = "Login button should be blue";
        Note note1 = new Note(alex, comment);
        bugReporter.addNoteToSpecificTask(0, note1);
        String replyMessage = "No ,Login button should be red";
        Reply reply = new Reply(alex, replyMessage);

        bugReporter.addReplyToSpecificNote(0, 0, reply);

        Assert.assertEquals(String.valueOf(bugReporter.getTaskList().get(0).getNotes().get(0).getReplay().get(0).getComment()), replyMessage);

    }

}
