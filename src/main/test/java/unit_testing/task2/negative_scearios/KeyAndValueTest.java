package unit_testing.task2.negative_scearios;

import org.junit.Assert;
import org.junit.Test;
import tasks_for_weeks.task2.Employee;
import tasks_for_weeks.task2.JsonData;

import java.util.Arrays;
import java.util.List;


public class KeyAndValueTest {
    @Test
    public void containKey() throws Exception {
        JsonData jsonData = new JsonData();
        String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";

        jsonData.readDataFromFile(path);

        Assert.assertFalse(jsonData.mapContainsKey("Michael"));
    }

    @Test
    public void containValue() throws Exception {
       JsonData jsonData = new JsonData();
       String path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task2/json.json";

       jsonData.readDataFromFile(path);

        List<String> countries = Arrays.asList("USA", "England", "Australia", "Romania");
        Employee employee = new Employee("Maria", 24, countries);

        Assert.assertFalse(jsonData.mapContainsValue(employee));
    }
}
