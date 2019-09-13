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

public class EditNoteTest {
    private Person alex;
    private Person marin;
    private TaskReporter taskReporter;

    @Before
    public void init() throws Exception {
        taskReporter = new TaskReporterImpl();

        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        marin = new Person("Marin", "Man", "Marin_man", Role.WEB_DEV, Department.QA, "123");
        Duration duration = new Duration(8, 0);
        Task task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);

        taskReporter.addTask(task);
    }

    @Test
    public void editNote() throws Exception {
        Note note = new Note(marin, "Login button should be red");
        taskReporter.addNoteToSpecificTask(0, note);
        String newNote = "Login button should be red";

        taskReporter.editNoteToSpecificTask(0, 0, newNote);
        Assert.assertEquals(String.valueOf(taskReporter.getTaskList().get(0).getNotes().get(0).getNote()), newNote);
    }

    @Test
    public void editReplyNote() throws Exception {
        Note note = new Note(marin, "Login button should be red");
        taskReporter.addNoteToSpecificTask(0, note);
        Reply reply = new Reply(alex, "Login button should be blue");
        taskReporter.addReplyToSpecificNote(0, 0, reply);
        String newReply = "Login button should be brown";

        taskReporter.editReplyFromSpecificNote(0, 0, 0, newReply);

        Assert.assertEquals(taskReporter.getTaskList().get(0).getNotes().get(0).getReplay().get(0).getComment(), newReply);

    }


}
