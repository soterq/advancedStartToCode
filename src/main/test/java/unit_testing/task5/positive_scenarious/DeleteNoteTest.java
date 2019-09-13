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

public class DeleteNoteTest {

    private Person alex;
    private Person marin;
    private TaskReporter bugReporter;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA, "123");
        marin = new Person("Marin", "Man", "Marin_man", Role.WEB_DEV, Department.QA, "123");
        bugReporter = new TaskReporterImpl();
        Duration duration = new Duration(8, 0);
        Task task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        bugReporter.addTask(task);
    }

    @Test
    public void deleteNote() throws Exception {
        String comment1 = "i think something is wrong in design";
        String comment2 = "maybe!";
        Note note = new Note(marin, comment1);
        Note note1 = new Note(alex, comment2);

        bugReporter.addNoteToSpecificTask(0, note);
        bugReporter.addNoteToSpecificTask(0, note1);

        Assert.assertEquals(String.valueOf(bugReporter.getTaskList().get(0).getNotes().get(0).getNote()), comment1);
        Assert.assertEquals(String.valueOf(bugReporter.getTaskList().get(0).getNotes().get(1).getNote()), comment2);
        int size = bugReporter.getTaskList().get(0).getNotes().size();

        bugReporter.deleteNoteToSpecificTask(0, 1);


        Assert.assertEquals(bugReporter.getTaskList().get(0).getNotes().size(), size - 1);
    }

    @Test
    public void deleteAllNotes() throws Exception {
        String comment1 = "i think something is wrong in design";
        String comment2 = "maybe!";
        Note note = new Note(marin, comment1);
        Note note1 = new Note(alex, comment2);

        bugReporter.addNoteToSpecificTask(0, note);
        bugReporter.addNoteToSpecificTask(0, note1);

        bugReporter.deleteAllNotes(0);

        Assert.assertEquals(bugReporter.getTaskList().get(0).getNotes().size(), 0);

    }

    @Test
    public void deleteReplyFromNote() throws Exception {
        String comment = "i think something is wrong in design";
        Note note = new Note(alex, comment);

        bugReporter.addNoteToSpecificTask(0, note);
        String replyMessage = "Ok maybe is ";
        Reply reply = new Reply(alex, replyMessage);
        bugReporter.addReplyToSpecificNote(0, 0, reply);
        int size = bugReporter.getTaskList().get(0).getNotes().get(0).getReplay().size();
        bugReporter.deleteReplyFromSpecificNote(0, 0, 0);

        Assert.assertEquals(bugReporter.getTaskList().get(0).getNotes().get(0).getReplay().size(), size - 1);

    }
}
