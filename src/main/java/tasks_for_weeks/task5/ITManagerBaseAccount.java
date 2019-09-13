package tasks_for_weeks.task5;

import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.Person;
import tasks_for_weeks.task5.objects.Task;
import tasks_for_weeks.task5.objects.TaskAssignedToHistory;
import tasks_for_weeks.task5.objects.TaskStateHistory;

import java.util.List;

public class ITManagerBaseAccount extends EmployeeBaseAccount {
    ITManagerBaseAccount(String username) throws Exception {
        super(username);
    }

    @Override
    public void changeTaskState() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("Choose new task priority\n" +
                "0 Created \n" +
                "1 In progress  \n" +
                "2 Completed \n");
        int stateNumber = getScanner().nextInt();
        if (stateNumber < 0 || stateNumber > 2) {
            System.out.println("The option you chose for task priority does not exist");
            return;
        }
        Task task = getTaskReporter().getTaskById(taskId);
        TaskState taskState = getSelect().selectState(stateNumber);

        if (getTaskReporter().getTaskById(taskId).getState().equals(taskState)) {
            System.out.println("This task is already set to " + taskState);
            return;
        }

        TaskStateHistory taskHistory = new TaskStateHistory(task.getStartDate(), getCurrentPerson(), task.getState(), taskState);
        task.addToStateHistory(taskHistory);

        task.setStartDate(task.generateCurrentData());
        getTaskReporter().changeTaskState(taskId, taskState);
        System.out.println(getTaskReporter().getTaskById(taskId));
        getTaskReporter().exportData(getPath());
    }

    @Override
    public void changeAssignedTo() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.print("Enter person user name");
        String userName = getScanner().nextLine();
        if (userName == null || userName.isEmpty()) {
            System.out.println("Username filed is required and can to to be empty");
            return;
        }
        Person person = getTaskReporter().findPersonByUsername(userName);
        if (person == null) {
            System.out.println("This person does not in the company");
            return;
        }
        if (getTaskReporter().getTaskById(taskId).getAssignedTo().equals(person)) {
            System.out.println("Entered person is already assigned to this task");
            return;
        }
        Task task1 = getTaskReporter().getTaskById(taskId);
        task1.getTaskAssignedToHistories().add(new TaskAssignedToHistory(getCurrentPerson(), task1.getAssignedTo(), getTaskReporter().findPersonByUsername(userName)));
        getTaskReporter().changeAssignedTo(taskId, person);
        System.out.println("Task assigned person was changed to" + person.getName() + " " + person.getSurname() + " " + person.getUserName());
        getTaskReporter().exportData(getPath());
    }

    @Override
    public void deleteTask() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        if (!getTaskReporter().getTaskById(taskId).getState().equals(TaskState.COMPLETED)) {
            System.out.println("This task is not completed, do you really want to delete this task ? ");
            System.out.println("1 Yes \n" +
                    "2 No");
            System.out.print("Choice an above option");
            int confirm = getScanner().nextInt();
            if (confirm != 1) {
                System.out.println("The deletion process was canceled");
                return;
            }
            boolean confirmation;
            confirmation = getSelect().confirmation(confirm);
            if (confirmation) {
                getTaskReporter().deleteTask(taskId);
                System.out.println("Task with id : '" + taskId + "' was removed");
                getTaskReporter().exportData(getPath());
            }
        } else {
            getTaskReporter().deleteTask(taskId);
            System.out.println("Task with id : '" + taskId + "' was removed");
            getTaskReporter().exportData(getPath());
        }
    }

    void addPerson() throws Exception {
        System.out.print("Enter person name");
        String personName = getScanner().nextLine();
        if (personName.isEmpty()) {
            System.out.println("Name filed is required and can to to be empty");
            return;
        }
        System.out.print("Enter person surname");
        String personSurname = getScanner().nextLine();
        if (personSurname.isEmpty()) {
            System.out.println("Surname filed is required and can to to be empty");
            return;
        }
        System.out.print("Enter person username");
        String personUsername = getScanner().nextLine();
        if (personUsername.isEmpty()) {
            System.out.println("Username filed is required and can to to be empty");
            return;
        }
        if (getTaskReporter().usernameExist(personUsername)) {
            boolean usernameExist = true;
            while (usernameExist) {
                System.out.println("This username already exist please enter another username");
                personUsername = getScanner().nextLine();
                if (!getTaskReporter().usernameExist(personUsername)) {
                    usernameExist = false;
                }
            }
        }

        System.out.print("Enter password for new employee\n");
        String password = getScanner().nextLine();
        if (password.isEmpty()) {
            System.out.println("Password field should be not empty");

        }
        System.out.print("Repeat please password\n");
        String repeatPassword = getScanner().nextLine();
        if (repeatPassword.isEmpty()) {
            System.out.println("Repeat password field should be not empty");
            return;
        }
        if (!repeatPassword.equals(password)) {
            System.out.println("Passwords do not match");
            return;
        }
        System.out.println("Choose person role\n" +
                "0 ARCHITECT \n" +
                "1 AUTOMATION_QA  \n" +
                "2 Developer \n" +
                "3 HELP_DESK \n" +
                "4 IT_MANAGER \n" +
                "5 MANUAL_QA \n" +
                "6 NETWORK_ADMINISTRATOR \n" +
                "7 WEB_DEV "
        );
        Role role;
        int roleNumber = getScanner().nextInt();
        if (roleNumber < 0 || roleNumber > 7) {
            System.out.println("The option you chose for person role does not exist");
            return;
        }
        role = getSelect().selectRole(roleNumber);
        System.out.println("Choose person department\n" +
                "0 QA \n" +
                "1 Teh Support  \n" +
                "2 Developer \n");
        int departmentNumber = getScanner().nextInt();
        if (departmentNumber < 0 || departmentNumber > 2) {
            System.out.println("The option you chose for person department does not exist");
            return;
        }
        Department department = getSelect().selectDepartment(departmentNumber);

        Person newPerson = new Person(personName, personSurname, personUsername, role, department, password);
        getTaskReporter().addPerson(newPerson);
        System.out.println("New person was created");
        System.out.println(newPerson.toString());
        getTaskReporter().exportPersonData(getPersonPath());
    }

    void deletePerson() throws Exception {
        System.out.print("Enter person userName");
        String userName = getScanner().nextLine();
        if (userName == null) {
            System.out.println("Username filed is required and can to to be empty");
            return;
        } else if (getTaskReporter().findPersonByUsername(userName) == null) {
            System.out.println("This person is no in our company");
            return;
        } else if (userName.equalsIgnoreCase(getCurrentPerson().getUserName())) {
            System.out.println("You can not delete you self");
            return;
        }

        List<Task> assignedTo = getTaskReporter().personIsAssigned(userName);
        if (assignedTo.size() > 0) {
            System.out.println("Can not delete person because this person is attached to tasks:");
            System.out.println(assignedTo);
            return;
        }
        getTaskReporter().deletePerson(userName);
        getTaskReporter().exportPersonData(getPersonPath());

    }

    @Override
    public void editNoteFromSpecificTask() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter note id");
        int noteId = getScanner().nextInt();
        if (noteId < 0) {
            System.out.println("Note with this id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter new Note");
        String newNote = getScanner().nextLine();
        if (newNote == null || newNote.isEmpty()) {
            System.out.println("Can not edit current note with empty new note");
            return;
        }
        getTaskReporter().editNoteToSpecificTask(taskId, noteId, newNote);
        System.out.println("Old note was edited with '" + newNote + "'");
        getTaskReporter().exportData(getPath());
    }

    @Override
    public void deleteNote() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        System.out.print("Enter note id");
        int noteId = getScanner().nextInt();
        if (noteId < 0 || !getTaskReporter().noteIdExist(taskId, noteId)) {
            System.out.println("Entered note id does not exist");
            return;
        }
        getTaskReporter().deleteNoteToSpecificTask(taskId, noteId);
        getTaskReporter().exportData(getPath());
    }

    @Override
    public void deleteAllNotes() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        getTaskReporter().deleteAllNotes(taskId);
        getTaskReporter().exportData(getPath());
    }

    public void editReplayMessage() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        System.out.print("Enter note id");
        int noteId = getScanner().nextInt();
        if (noteId < 0 || !getTaskReporter().noteIdExist(taskId, noteId)) {
            System.out.println("Entered note id does not exist");
            return;
        }
        System.out.print("Enter reply note id");
        int replyId = getScanner().nextInt();
        if (replyId < 0 || !getTaskReporter().replyIdExists(taskId, noteId, replyId)) {
            System.out.println("Entered reply message id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter new Note");
        String newNote = getScanner().nextLine();
        if (newNote.isEmpty()) {
            System.out.println("Can not edit current reply message with empty message");
            return;
        }

        getTaskReporter().editReplyFromSpecificNote(taskId, noteId, replyId, newNote);
        System.out.println("Old replay message was edited");
        getTaskReporter().exportData(getPath());
    }

    @Override
    public void deleteReply() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        System.out.print("Enter note id");
        int noteId = getScanner().nextInt();
        if (noteId < 0 || !getTaskReporter().noteIdExist(taskId, noteId)) {
            System.out.println("Entered note id does not exist");
            return;
        }
        System.out.print("Enter reply message id");
        int replyId = getScanner().nextInt();
        if (replyId < 0 || !getTaskReporter().replyIdExists(taskId, noteId, replyId)) {
            System.out.println("Entered reply message id does not exist");
            return;
        }
        getTaskReporter().deleteReplyFromSpecificNote(taskId, noteId, replyId);
        System.out.println("Reply message was removed");
        getTaskReporter().exportData(getPath());
    }

    void exportPersonData() throws Exception {
        System.out.print("Enter path to file please !");
        String pathToExport = getScanner().nextLine();
        if (pathToExport == null || pathToExport.isEmpty()) {
            System.out.println("Can not export file if path to file is empty");
            return;
        }
        getTaskReporter().exportPersonData(pathToExport);

    }

    void importPersonData() throws Exception {
        System.out.print("Enter path to file please !");
        String pathToImport = getScanner().nextLine();
        if (pathToImport == null || pathToImport.isEmpty()) {
            System.out.println("Can not import file if path to file is empty");
            return;
        }
        getTaskReporter().importPersonData(pathToImport);
        getTaskReporter().exportPersonData(getPersonPath());
    }

    void personIdAndUsernameReorganization() throws Exception {
        System.out.print("After this process every person with duplicated id will have new id and every person with duplicated username will have new username\n" +
                "Do you want to reorganize persons collection ?\n" +
                "1 - Yes\n2 - No");
        int response = getScanner().nextInt();
        if (response == 1) {
            getTaskReporter().personIdAndUsernameReorganization();
            getTaskReporter().exportPersonData(getPersonPath());
        } else {
            System.out.println("Process is successful cancelled");
        }
    }

    void tasksIdReorganization() throws Exception {
        System.out.print("After this process every task with duplicated id will have new id\n" +
                "Do you want to reorganize task collection ?\n" +
                "1 - Yes\n2 - No");
        int response = getScanner().nextInt();
        if (response == 1) {
            getTaskReporter().tasksIdReorganization();
            getTaskReporter().exportData(getPath());
        } else {
            System.out.println("Process is successful cancelled");
        }
    }
}
