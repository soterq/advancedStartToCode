package tasks_for_weeks.task5;


import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.exception.UserNotFound;
import tasks_for_weeks.task5.objects.Person;

public class Login {
    private TaskReporter taskReporter = new TaskReporterImpl();

    private String userName;
    private String password;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    public void login() throws Exception {
        String personPath = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task5/Persons.json";
        taskReporter.loadPersonData(personPath);
        Person person = taskReporter.loginVerification(userName);
        if (person == null) {
            throw new UserNotFound("User not found");
        }
        if (!password.equals(person.getPassword())) {
            throw new Exception("Incorrect username or password");
        }

        if (person.getRole().equals(Role.IT_MANAGER)) {
            ITManagerAccount itManagerAccount = new ITManagerAccount(userName);
            itManagerAccount.itManagerInterface();
        } else {
            EmployeeAccount employeeAccount = new EmployeeAccount(userName);
            employeeAccount.employeeInterface();
        }
    }

}