package unit_testing.task5.negative_scearios;

import org.junit.Before;
import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task5.*;
import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;

public class EditNoteTest {
    private Person alex;
    private TaskReporter taskReporter;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA,"123");
        taskReporter = new TaskReporterImpl();
        Duration duration = new Duration(8, 0);
        Task task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        taskReporter.addTask(task);
    }

    @Test(expected = IllegalActionException.class)
    public void editNoteForUnExistingTask() throws Exception {
        Note note1 = new Note(alex, "Login button is transparent ");
        taskReporter.addNoteToSpecificTask(0, note1);
        String newNote1 = "It need to be transparent at 20%";
        taskReporter.editNoteToSpecificTask(1, 0, newNote1);

    }

    @Test(expected = IllegalActionException.class)
    public void editNoteForUnExistingNote() throws Exception {
        Note note1 = new Note(alex, "Login button is red bunt need to be blue");
        taskReporter.addNoteToSpecificTask(0, note1);
        String newNote1 = "done!";

        taskReporter.editNoteToSpecificTask(0, 99, newNote1);

    }

    @Test(expected = IllegalActionException.class)
    public void editUnExistingReply() throws Exception {
        Note note = new Note(alex, "Login button should be red");
        taskReporter.addNoteToSpecificTask(0, note);
        Reply reply = new Reply(alex, "Login button should be blue");
        taskReporter.addReplyToSpecificNote(0, 0, reply);
        String newReply = "Login button should be brown";

        taskReporter.editReplyFromSpecificNote(0, 0, 1, newReply);

    }
}
