package unit_testing.task5.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task5.*;

public class AddPersonTest {
    @Test(expected = InvalidInputException.class)
    public void addNewPerson() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        bugReporter.addPerson(null);
    }
}
