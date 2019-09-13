package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

public class RemoveTest {
    @Test
    public void removeAllElement() throws Exception {
        TaskOne taskOne = new TaskOneImpl();

        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("Two");
        taskOne.appendElementToEnd("Three");

        taskOne.removeElementFromSet("One");

        Assert.assertEquals(taskOne.numberOfElements(), 2);
//au ramas eleemntele respective
        //elemetul nu mai este in lista
    }

    @Test
    public void removeElements() throws Exception {
        TaskOne taskOne = new TaskOneImpl();

        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("Two");
        taskOne.appendElementToEnd("Three");

        taskOne.removeAllElements();

        Assert.assertEquals(taskOne.numberOfElements(), 0);


    }

}
