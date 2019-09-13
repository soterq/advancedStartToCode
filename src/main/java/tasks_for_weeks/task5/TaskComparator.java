package tasks_for_weeks.task5;

import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.objects.Task;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        TaskPriority p1 = o1.getPriority();
        TaskPriority p2 = o2.getPriority();

        if (p1.equals(p2)) {
            return 0;
        }
        if (p1.equals(TaskPriority.CRITICAL) && (p2.equals(TaskPriority.MEDIUM) || p2.equals(TaskPriority.LOW))) {
            return -1;
        }
        if (p1.equals(TaskPriority.MEDIUM) && p2.equals(TaskPriority.LOW)) {
            return -1;
        }
        return 1;

    }
}
