package tasks_for_weeks.task1;


import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.exceptions.InvalidInputException;

import java.util.HashSet;
import java.util.List;

public interface TaskOne {
    void appendElementToEnd(String element) throws InvalidInputException;

    int numberOfElements();

    void removeElementFromSet(String element) throws InvalidInputException, IllegalActionException;

    void removeAllElements() throws IllegalActionException;

    List<String> convertToArrayList();

    HashSet cloneHashSet();

    HashSet<String> commonElements(HashSet<String> secondCollection);

}
