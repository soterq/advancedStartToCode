package tasks_for_weeks.task5;


import java.util.Scanner;

class EmployeeAccount {
    private EmployeeBaseAccount employeeBaseAccount;

    EmployeeAccount(String username) throws Exception {
        employeeBaseAccount = new EmployeeBaseAccount(username);
    }

    void employeeInterface() throws Exception {
        boolean quit = false;
        Scanner scanner = new Scanner(System.in);
        String menu = "1 View all tasks                           " + "2 View all persons" + "                          3 Sort data descending by priority \n" +
                "4 Sort data ascending by priority          " + "5 Create new task  " + "                         6 Show task description\n" +
                "7 Change state to specific task            " + "8 Change assigned person to task   " + "         9 Delete task\n" +
                "10 Add note for a specific task            " + "11 Edit note for a specific task   " + "         12 Delete note from a specific task\n" +
                "13 Delete all notes from a specific task   " + "14 Add replay to note for a specific task" + "   15 Edit reply for a specific note\n" +
                "16 Delete reply from a specific note       " + "17 View list of State changes for task      " + "18 View list of assigned changes for task\n" +
                "19 View notes from specific task           " + "20 View reply note from specific task       " + "21 View task by status\n" +
                "22 Export tasks                            " + "23 Import data                              " + "24 Change password\n" +
                "0  Logout";
        while (!quit) {
            System.out.println(menu);
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    employeeBaseAccount.viewTasks();
                    break;
                case 2:
                    employeeBaseAccount.viewPersons();
                    break;
                case 3:
                    employeeBaseAccount.showTasksDescending();
                    break;
                case 4:
                    employeeBaseAccount.showTasksAscending();
                    break;
                case 5:
                    employeeBaseAccount.newTask();
                    break;
                case 6:
                    employeeBaseAccount.showDescription();
                    break;
                case 7:
                    employeeBaseAccount.changeTaskState();
                    break;
                case 8:
                    employeeBaseAccount.changeAssignedTo();
                    break;
                case 9:
                    employeeBaseAccount.deleteTask();
                    break;
                case 10:
                    employeeBaseAccount.addNoteForSpecificTask();
                    break;
                case 11:
                    employeeBaseAccount.editNoteFromSpecificTask();
                    break;
                case 12:
                    employeeBaseAccount.deleteNote();
                    break;
                case 13:
                    employeeBaseAccount.deleteAllNotes();
                    break;
                case 14:
                    employeeBaseAccount.addReplayMessage();
                    break;
                case 15:
                    employeeBaseAccount.editReplayMessage();
                    break;
                case 16:
                    employeeBaseAccount.deleteReply();
                    break;
                case 17:
                    employeeBaseAccount.viewListStateChanges();
                    break;
                case 18:
                    employeeBaseAccount.viewNotes();
                    break;
                case 19:
                    employeeBaseAccount.viewReply();
                    break;
                case 20:
                    employeeBaseAccount.viewTaskByStatus();
                    break;
                case 21:
                    employeeBaseAccount.exportTasksList();
                    break;
                case 22:
                    employeeBaseAccount.importTaskList();
                    break;
                case 23:
                    employeeBaseAccount.changePassword();
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("This option in menu does not exist");
                    break;
            }
        }
    }
}
