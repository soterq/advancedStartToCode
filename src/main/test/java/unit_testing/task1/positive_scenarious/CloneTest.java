package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

import java.util.HashSet;

public class CloneTest {

    @Test
    public void cloneMap() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("two");
        taskOne.appendElementToEnd("tree");
        int size = taskOne.numberOfElements();

        HashSet destination ;

        destination = taskOne.cloneHashSet();

        Assert.assertEquals(destination.size(), size);


    }
}
