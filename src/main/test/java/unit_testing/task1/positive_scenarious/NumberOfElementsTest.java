package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

public class NumberOfElementsTest {

    @Test
    public void setSize() throws Exception {
        TaskOne taskOne = new TaskOneImpl();

        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("Two");
        taskOne.appendElementToEnd("Three");

        Assert.assertEquals(taskOne.numberOfElements(), 3);
//mai multe scenarii
    }
}
