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

public class DeleteTask {

    private TaskReporter taskReporter;
    private Person alex;

    @Before
    public void init() throws Exception {
        alex = new Person("Alex", "Man", "Alex_man", Role.WEB_DEV, Department.QA,"123");
        taskReporter = new TaskReporterImpl();
        Duration duration = new Duration(8, 0);
         Task task = new Task("login page", "Login Page need contains fields for logging in to account ", TaskPriority.CRITICAL, duration, TaskState.CREATED, alex,alex);
        taskReporter.addTask(task);
    }

    @Test(expected = IllegalActionException.class)
    public void deleteNoteFromUnExistingTask() throws Exception {
        taskReporter.deleteNoteToSpecificTask(0, 0);
    }

    @Test(expected = IllegalActionException.class)
    public void deleteAllNotesFromUnExistingTask() throws Exception {
        taskReporter.deleteAllNotes(0);
    }

    @Test(expected = IllegalActionException.class)
    public void deleteUnExistingReplyNote() throws Exception {
        String comment = "login button should be green color";
        Note note1 = new Note(alex, comment);
        taskReporter.addNoteToSpecificTask(0, note1);

        taskReporter.deleteReplyFromSpecificNote(0, 0, 0);

    }
}
