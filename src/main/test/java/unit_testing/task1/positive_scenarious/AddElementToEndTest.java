package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

public class AddElementToEndTest {
    @Test
    public void addElements() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("two");
        taskOne.appendElementToEnd("three");

        Assert.assertEquals(taskOne.numberOfElements(), 3);


    }
}
