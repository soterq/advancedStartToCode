package unit_testing.task1.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

public class RemoveElementTest {
    @Test(expected = InvalidInputException.class)
    public void removeEmptyElementTest() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.removeElementFromSet("");
    }

    @Test(expected = InvalidInputException.class)
    public void removeNullElementTest() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.removeElementFromSet(null);
    }

    @Test(expected = IllegalActionException.class)
    public void clearCollection() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.removeAllElements();
    }
}
