package tasks_for_weeks.task5;

import tasks_for_weeks.task5.exception.UserNotFound;
import tasks_for_weeks.task5.objects.Person;

public class RestorePassword {
    TaskReporter taskReporter = new TaskReporterImpl();

    private String username;
    private int phone;

    public RestorePassword(String username, int phone) {
        this.username = username;
        this.phone = phone;
    }

    public void restore() throws UserNotFound {
        Person person = taskReporter.findPersonByUsername(username);
        if (person == null) {
            throw new UserNotFound("User not found");
        }
    }
}
