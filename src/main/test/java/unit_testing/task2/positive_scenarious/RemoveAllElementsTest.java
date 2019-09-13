package unit_testing.task2.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task2.JsonData;

import java.util.HashMap;

public class RemoveAllElementsTest {
    @Test
    public void getDataFromFile() throws Exception {

        JsonData jsonData = new JsonData();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";

        HashMap map = jsonData.readDataFromFile(path);
        jsonData.removeAllMappedElements();
        Assert.assertEquals(map.size(), 0);

    }
}
