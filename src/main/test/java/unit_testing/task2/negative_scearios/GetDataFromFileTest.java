package unit_testing.task2.negative_scearios;

import org.junit.Test;
import tasks_for_weeks.task2.Employee;
import tasks_for_weeks.task2.JsonData;

import java.io.FileNotFoundException;

public class GetDataFromFileTest {
    @Test(expected = FileNotFoundException.class)
    public void getDataFromFile() throws Exception {

        JsonData<Integer> jsonData = new JsonData<>();
        String path = "json.json";
        jsonData.readDataFromFile(path);

    }
}
