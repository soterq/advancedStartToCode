package unit_testing.task2.positive_scenarious;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task2.Employee;
import tasks_for_weeks.task2.JsonData;

import java.util.Arrays;
import java.util.List;


public class ContainsKeyAndValueTest {
    @Test
    public void containKey() throws Exception {
        JsonData jsonData = new JsonData();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";

        jsonData.readDataFromFile(path);

        Assert.assertTrue(jsonData.mapContainsKey("John"));
    }

    @Test
    public void containValue() throws Exception {
        JsonData jsonData = new JsonData();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";

        jsonData.readDataFromFile(path);

        List<String> countries = Arrays.asList("USA", "England", "Australia", "Romania");
        Employee employee = new Employee("John", 24, countries);

        Assert.assertTrue(jsonData.mapContainsValue(employee));
    }
}
