package unit_testing.task5.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task5.*;

public class NewIssueTest {
    @Test(expected = InvalidInputException.class)
    public void createIssueBug() throws Exception {
        TaskReporter bugReporter = new TaskReporterImpl();
        bugReporter.addTask(null);
    }
}
