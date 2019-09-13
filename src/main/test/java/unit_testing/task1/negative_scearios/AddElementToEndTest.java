package unit_testing.task1.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;
import tasks_for_weeks.exceptions.InvalidInputException;

public class AddElementToEndTest {

    @Test(expected = InvalidInputException.class)
    public void AddEmptyElementToEndTest() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.appendElementToEnd("");
    }

    @Test(expected = InvalidInputException.class)
    public void addBookByNullName() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.appendElementToEnd(null);
    }
}
