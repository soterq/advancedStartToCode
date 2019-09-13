package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ConvertToArrayListTest {

    @Test
    public void convertSetToArray() throws InvalidInputException {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("two");
        taskOne.appendElementToEnd("ok");

        int size = taskOne.numberOfElements();

        List<String> list = taskOne.convertToArrayList();

        Assert.assertEquals(list.size(), size);
        //validez tipul obiectului
    }
}
