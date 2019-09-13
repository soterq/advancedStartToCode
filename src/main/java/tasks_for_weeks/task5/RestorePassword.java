package tasks_for_weeks.task5;

import tasks_for_weeks.task5.exception.UserNotFound;
import tasks_for_weeks.task5.objects.Person;

public class RestorePassword {
    private TaskReporter taskReporter;

    private String username;
    private String phoneNumber;

    public RestorePassword(String username, String phoneNumber) {
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.taskReporter = TaskReporterImpl.getInstance();
    }

    public void restorePassword() throws Exception {
        Person person = taskReporter.findPersonByUsername(username);
        if (person == null) {
            throw new UserNotFound("User not found");
        }
        if (!phoneNumber.matches("/^\\d+$")) {
            throw new Exception("Invalid entered phone number");
        }

        System.out.println("New password was sending to your phoneNumber, please confirm new password");
    }
}
