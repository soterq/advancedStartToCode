package unit_testing.task2.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task2.JsonData;

public class RemoveElementsTest {

    @Test(expected = IllegalActionException.class)
    public void removeMappedElements() throws Exception {
        JsonData jsonData = new JsonData();
        jsonData.removeAllMappedElements();

    }

}
