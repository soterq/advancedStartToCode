package tasks_for_weeks.task1;

import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskOneImpl implements TaskOne {
    private Set<String> set;

    public TaskOneImpl() {
        this.set = new HashSet<>();
    }


    @Override
    public void appendElementToEnd(String element) throws InvalidInputException {
        isNullOrEmpty(element);
        set.add(element);
    }

    @Override
    public int numberOfElements() {
        return set.size();
    }

    @Override
    public void removeElementFromSet(String element) throws InvalidInputException, IllegalActionException {
        isNullOrEmpty(element);
        if (set.contains(element)) {
            set.remove(element);
        } else {
            throw new IllegalActionException("This element is not in the set");
        }
    }

    @Override
    public void removeAllElements() throws IllegalActionException {
        if (set.size() > 0) {
            set.clear();
        } else {
            throw new IllegalActionException("Collection is already empty");
        }
    }

    @Override
    public List<String> convertToArrayList() {
        return new ArrayList<>(set);

    }

    @Override
    public HashSet cloneHashSet() {
        return (HashSet) ((HashSet) set).clone();
    }

    @Override
    public HashSet<String> commonElements(HashSet<String> secondCollection) {
        secondCollection.retainAll(set);
        return secondCollection;
    }

    private void isNullOrEmpty(String element) throws InvalidInputException {
        if (element == null || element.isEmpty()) {
            throw new InvalidInputException("Entered values is null or is empty");
        }
    }
}
