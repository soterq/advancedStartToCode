package tasks_for_weeks.task2;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import tasks_for_weeks.exceptions.IllegalActionException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class JsonData<T> {
    private Map<T, Employee> jsonMap;

    public JsonData() {
        this.jsonMap = new HashMap<>();
    }

    public HashMap<T, Employee> readDataFromFile(String path) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Employee> myObjects = mapper.readValue(new File(path), new TypeReference<List<Employee>>() {
        });

        for (Employee employee : myObjects) {
            jsonMap.put((T) employee.getName(), employee);
        }
        return (HashMap<T, Employee>) jsonMap;
    }

    public int size() {
        return jsonMap.size();
    }

    public void copy(Map<T, Employee> map) {
        map.putAll(jsonMap);
    }

    public void removeAllMappedElements()   {
        jsonMap.clear();
    }

    public boolean mapContainsKey(T nameKey) {
        return jsonMap.containsKey(nameKey);
    }
//haskey
    public boolean mapContainsValue(Employee employee) {
        for (Employee value : jsonMap.values()) {
            if (value.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public List<T> getKeys() {
        return new ArrayList<>(jsonMap.keySet());
    }

    public List<Employee> getValues() {
        return new ArrayList<>(jsonMap.values());
    }
}
