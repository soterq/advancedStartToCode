package unit_testing.task2.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task2.Employee;
import tasks_for_weeks.task2.JsonData;

import java.util.HashMap;
import java.util.Map;

public class CopyMapTest {

    @Test
    public void getDataFromFile() throws Exception {

        JsonData jsonData = new JsonData();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";
        jsonData.readDataFromFile(path);
        Map<String, Employee> destination = new HashMap<>();

        jsonData.copy(destination);

        System.out.println(destination);
        Assert.assertEquals(jsonData.readDataFromFile(path), destination);
    }
}
