package tasks_for_weeks.task5;

import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;

import java.util.Scanner;

public class EmployeeBaseAccount {
    private String username;
    private Scanner scanner;
    private String personPath;
    private String path;
    private Person currentPerson;
    private TaskReporter taskReporter;
    private Select select;

    EmployeeBaseAccount(String username) throws Exception {
        this.taskReporter = TaskReporterImpl.getInstance();
        this.select = new Select();
        this.username = username;
        this.scanner = new Scanner(System.in);
        this.personPath = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task5/Persons.json";
        this.path = "C:/Users/vitalies/IdeaProjects/testing/src/main/java/tasks_for_weeks/task5/TaskRepository.json";
        this.taskReporter.loadTaskData(path);
        this.taskReporter.loadPersonData(personPath);
        this.currentPerson = taskReporter.findPersonByUsername(username);
    }

    String getPersonPath() {
        return personPath;
    }

    Select getSelect() {
        return select;
    }

    public String getPath() {
        return path;
    }

    Person getCurrentPerson() {
        return currentPerson;
    }

    public TaskReporter getTaskReporter() {
        return taskReporter;
    }

    Scanner getScanner() {
        return scanner;
    }


    void viewTasks() {
        getTaskReporter().viewTasks();
    }

    void viewPersons() {
        getTaskReporter().viewPersons();
    }

    void showTasksDescending() {
        getTaskReporter().sortDescendingByPriority();
        getTaskReporter().viewTasks();
    }

    void showTasksAscending() {
        getTaskReporter().sortAscendingByPriority();
        getTaskReporter().viewTasks();
    }

    void newTask() throws Exception {
        System.out.print("Enter task name");
        String name = getScanner().nextLine();
        if (name == null || name.isEmpty()) {
            System.out.println("Name field is required and can not to be empty");
            return;
        }
        System.out.print("Enter description to task");
        String description = getScanner().nextLine();
        if (description == null || description.isEmpty()) {
            System.out.println("Description filed is required and can to to be empty");
            return;
        }
        System.out.println("Choose task priority\n" +
                "0 Low \n" +
                "1 Medium  \n" +
                "2 Critical");
        int choicePriority = getScanner().nextInt();
        if (choicePriority < 0 || choicePriority > 2) {
            System.out.println("The option you chose for task priority do not exist");
            return;
        }
        TaskPriority taskPriority;
        taskPriority = select.selectPriority(choicePriority);

        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter hours for this task");
        int hours = getScanner().nextInt();
        if (hours < 0) {
            System.out.print("Value for hours should be positive number");
            return;
        }
        System.out.print("and minutes");
        int minutes = getScanner().nextInt();
        if (minutes < 0) {
            System.out.print("Value for minutes should be positive number");
            return;
        }
        if (hours == 0 && minutes == 0) {
            System.out.println("Can not create task without time period");
            return;
        }
        System.out.println("Now we need assign task to person");
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter person userName");
        String personName = getScanner().nextLine();
        if (personName.isEmpty()) {
            System.out.println("Username field is required and can not to be empty");
            return;
        }
        Person person = getTaskReporter().findPersonByUsername(personName);
        if (person == null) {
            System.out.println("This employee does not in the company");
            return;
        }
        Duration duration = new Duration(hours, minutes);
        Task task = new Task(name, description, taskPriority, duration, TaskState.CREATED, currentPerson, person);
        getTaskReporter().addTask(task);
        getTaskReporter().exportData(path);
        System.out.println("New task was created");
    }

    void showDescription() {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        getTaskReporter().showDescription(taskId);
    }

    public void changeTaskState() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        if (!(getTaskReporter().getTaskById(taskId).getAssignedTo().getUserName().equals(currentPerson.getUserName()) || getTaskReporter().getTaskById(taskId).getCreatedBy().getUserName().equals(currentPerson.getUserName()))) {
            System.out.println("This operation is available only for person who create this task or who is assigned to");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.println("Choose new priority for current task\n" +
                "0 Created \n" +
                "1 In progress  \n" +
                "2 Completed \n");

        int stateNumber = getScanner().nextInt();
        if (stateNumber < 0 || stateNumber > 2) {
            System.out.println("The option you chose for task priority does not exist");
            return;
        }
        Task task = getTaskReporter().getTaskById(taskId);
        TaskState taskState = select.selectState(stateNumber);

        if (getTaskReporter().getTaskById(taskId).getState().equals(taskState)) {
            System.out.println("This task is already set to " + taskState);
            return;
        }

        TaskStateHistory taskHistory = new TaskStateHistory(task.getStartDate(), currentPerson, task.getState(), taskState);
        task.addToStateHistory(taskHistory);
        task.setStartDate(task.generateCurrentData());
        getTaskReporter().changeTaskState(taskId, taskState);
        System.out.println("Task state was changed to" + taskState);
        System.out.println(task);
        getTaskReporter().exportData(path);
    }

    public void changeAssignedTo() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }

        if (!getTaskReporter().getTaskById(taskId).getCreatedBy().getUserName().equals(currentPerson.getUserName())) {
            System.out.println("You are not the author of the task and can not change assigned person");
            return;
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
        task1.getTaskAssignedToHistories().add(new TaskAssignedToHistory(currentPerson, task1.getAssignedTo(), taskReporter.findPersonByUsername(userName)));
        getTaskReporter().changeAssignedTo(taskId, person);
        System.out.println("Task assigned person was changed to" + person.getName() + " " + person.getSurname() + " " + person.getUserName());
        getTaskReporter().exportData(path);
    }

    public void deleteTask() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Task with this id does not exist");
            return;
        }

        if (getTaskReporter().getTaskById(taskId).getCreatedBy().equals(currentPerson)) {
            boolean confirmation;
            if (!getTaskReporter().getTaskById(taskId).getState().equals(TaskState.COMPLETED)) {
                System.out.println("This task does not completed, do you really want to delete this task ? ");
                System.out.println("1 Yes \n" +
                        "2 No");
                System.out.print("Choice an above option");
                int confirm = getScanner().nextInt();
                if (confirm != 1) {
                    System.out.println("The deletion process was canceled");
                    return;
                }
                confirmation = select.confirmation(confirm);
                if (confirmation) {
                    getTaskReporter().deleteTask(taskId);
                    System.out.println("Task with id : '" + taskId + "' was removed");
                    getTaskReporter().exportData(path);
                }
            } else {
                getTaskReporter().deleteTask(taskId);
                System.out.println("Task with id : '" + taskId + "' was removed");
                getTaskReporter().exportData(path);
            }
        } else {
            System.out.println("You can not delete this task because you are not the author of the task");
        }
    }

    void addNoteForSpecificTask() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Task with this id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter your note");
        String noteMessage = getScanner().nextLine();
        if (noteMessage == null || noteMessage.isEmpty()) {
            System.out.println("Can not add empty note for this task");
            return;
        }
        Note note = new Note(currentPerson, noteMessage);
        getTaskReporter().addNoteToSpecificTask(taskId, note);
        System.out.println("Note '" + noteMessage + "' was added");
        getTaskReporter().exportData(path);
    }

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
        if (noteId < 0 || !getTaskReporter().noteIdExist(taskId, noteId)) {
            System.out.println("Note with this id does not exist");
            return;
        }
        if (getTaskReporter().getNoteById(taskId, noteId).getPerson().equals(currentPerson)) {
            getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.print("Enter new note");
            String newNote = getScanner().nextLine();

            if (newNote == null || newNote.isEmpty()) {
                System.out.println("Can not edit current note with empty note");
                return;
            }
            getTaskReporter().editNoteToSpecificTask(taskId, noteId, newNote);
            System.out.println("Old note was edited with" + newNote);
            getTaskReporter().exportData(path);
        } else {
            System.out.println("You can not edit this note because you are not the author of the note");
        }
    }

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
        if (getTaskReporter().getNoteById(taskId, noteId).getPerson().equals(currentPerson)) {
            getTaskReporter().deleteNoteToSpecificTask(taskId, noteId);
            System.out.println("Note with id " + noteId + " was removed from task");
            getTaskReporter().exportData(path);
        } else {
            System.out.println("You can not delete this post because you are not the author of this post");
        }
    }

    public void deleteAllNotes() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        if (getTaskReporter().getTaskById(taskId).getCreatedBy().equals(currentPerson)) {
            getTaskReporter().deleteAllNotes(taskId);
            System.out.println("All notes from task with id '" + taskId + "' was removed");
            getTaskReporter().exportData(path);
        } else {
            System.out.println("You can not delete all notes from this task because you are not the author of this task");
        }
    }

    void addReplayMessage() throws Exception {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered Task id does not exist");
            return;
        }
        System.out.print("Enter note id");
        int noteId = getScanner().nextInt();
        if (noteId < 0 || !getTaskReporter().noteIdExist(taskId, noteId)) {
            System.out.println("Entered note id does not exist");
            return;
        }
        getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        System.out.print("Enter your note");
        String noteMessage = getScanner().nextLine();
        if (noteMessage.isEmpty()) {
            System.out.println("New reply message is empty and can not be added to note");
            return;
        }
        Reply reply = new Reply(currentPerson, noteMessage);

        getTaskReporter().addReplyToSpecificNote(taskId, noteId, reply);
        System.out.println("Reply message was added");
        getTaskReporter().exportData(path);
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
        if (getTaskReporter().getReplyById(taskId, noteId, replyId).getPerson().equals(currentPerson)) {
            getScanner().skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.print("Enter new Note");
            String newNote = getScanner().nextLine();
            if (newNote.isEmpty()) {
                System.out.println("New reply is empty and old reply message can not be edited");
                return;
            }
            getTaskReporter().editReplyFromSpecificNote(taskId, noteId, replyId, newNote);
            System.out.println("Old reply message was edited");
            getTaskReporter().exportData(path);
        } else {
            System.out.println("Can not edit current reply message with empty message");
        }
    }

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
            System.out.println("Entered task id does not exist");
            return;
        }
        System.out.print("Enter reply message id");
        int replyId = getScanner().nextInt();
        if (replyId < 0 || !taskReporter.replyIdExists(taskId, noteId, replyId)) {
            System.out.println("Entered reply message id does not exist");
            return;
        }
        if (getTaskReporter().getReplyById(taskId, noteId, replyId).getPerson().equals(currentPerson)) {
            getTaskReporter().deleteReplyFromSpecificNote(taskId, noteId, replyId);
            System.out.println("Reply message was removed");
            getTaskReporter().exportData(path);
        } else {
            System.out.println("You can not delete this replay because you are not the author of the replay message ");
        }
    }

    void viewListStateChanges() {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id is not exist");
            return;
        }
        getTaskReporter().getHistory(taskId);

    }

    void viewNotes() {
        System.out.print("Enter task id");
        int taskId = getScanner().nextInt();
        if (taskId < 0 || !getTaskReporter().taskIdExist(taskId)) {
            System.out.println("Entered task id does not exist");
            return;
        }
        getTaskReporter().showNotes(taskId);

    }

    void viewReply() {
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
        getTaskReporter().showSubNotes(taskId, noteId);
    }

    void viewTaskByStatus() {
        System.out.println("Choose task state\n" +
                "0 Created \n" +
                "1 In progress  \n" +
                "2 Completed \n");
        int stateNumber = getScanner().nextInt();
        if (stateNumber < 0 || stateNumber > 2) {
            System.out.println("The option you chose for task state does not exist");
            return;
        }
        TaskState taskState = select.selectState(stateNumber);
        getTaskReporter().viewTasksByState(taskState);
    }

    void exportTasksList() throws Exception {
        System.out.print("Enter path to file please !");
        String pathToExport = getScanner().nextLine();
        if (pathToExport == null || pathToExport.isEmpty()) {
            System.out.println("Can not export data to empty path");
            return;
        }
        getTaskReporter().exportData(pathToExport);
    }

    void importTaskList() throws Exception {
        System.out.print("Enter path to file please !");
        String pathToImport = getScanner().nextLine();
        if (pathToImport == null || pathToImport.isEmpty()) {
            System.out.println("Can not import file if path to file is empty");
            return;
        }
        getTaskReporter().importTaskData(pathToImport);
        getTaskReporter().exportData(path);
    }

    void changePassword() throws Exception {
        System.out.print("Enter old password");
        String oldPassword = getScanner().nextLine();
        if (!currentPerson.getPassword().equals(oldPassword)) {
            System.out.println("Incorrect password");
            return;
        }
        System.out.print("Enter new password");
        String newPassword = getScanner().nextLine();
        if (newPassword == null || newPassword.length() < 6) {
            System.out.println("New password should contains minimum 6 characters");
            return;
        }
        System.out.print("Repeat password");
        String repeat = getScanner().nextLine();
        if (!repeat.equals(newPassword)) {
            System.out.println("Password do not match");
            return;
        }
        getTaskReporter().changePassword(currentPerson, repeat);
        getTaskReporter().exportPersonData(personPath);
        System.out.println("Password was changed");
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
