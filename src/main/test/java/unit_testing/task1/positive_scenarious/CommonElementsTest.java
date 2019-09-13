package unit_testing.task1.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task1.TaskOne;
import tasks_for_weeks.task1.TaskOneImpl;

import java.util.HashSet;

public class CommonElementsTest {

    @Test
    public void commonElements() throws Exception {
        TaskOne taskOne = new TaskOneImpl();
        HashSet<String> source = new HashSet<>();
        source.add("One");
        source.add("two");
        source.add("three");

        taskOne.appendElementToEnd("One");
        taskOne.appendElementToEnd("two");
        taskOne.appendElementToEnd("four");

        HashSet<String> destination ;

        destination = taskOne.commonElements(source);

        Assert.assertEquals(destination.size(), 2);
        //validare assert cu elemente concrete

    }
}
