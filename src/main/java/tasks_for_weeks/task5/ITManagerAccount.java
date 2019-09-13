package tasks_for_weeks.task5;


import java.util.Scanner;

class ITManagerAccount {
    private ITManagerBaseAccount itManagerBaseAccount;

    ITManagerAccount(String username) throws Exception {
        itManagerBaseAccount = new ITManagerBaseAccount(username);
    }

    void itManagerInterface() throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        String menu = "1 View all tasks                           " + "2 View all persons" + "                          3 Sort data descending by priority \n" +
                "4 Sort data ascending by priority          " + "5 Create new task  " + "                         6 Show task description\n" +
                "7 Add new person in company                " + "8 Change state to specific task    " + "         9 Change assigned person to task\n" +
                "10 Delete task                             " + "11 Delete Person                   " + "         12 Add note for a specific task\n" +
                "13 Edit note for a specific task           " + "14 Delete note from a specific task      " + "   15 Delete all notes from a specific task\n" +
                "16 Add replay to note for a specific task  " + "17 Edit reply for a specific note           " + "18 Delete reply from a specific note\n" +
                "19 View list of State changes for task     " + "20 View notes from specific task            " + "21 View reply note from specific task\n" +
                "22 View task by status                     " + "23 Export task list                         " + "24 Import task list\n" +
                "25  Logout                                 " + "25 Export Persons data                      " + "26 Import Person data\n" +
                "27 Change password                         " + "28 Task list reorganization                 " + "29 Person list reorganization\n" +
                "0 Exit";
        while (!quit) {
            System.out.println("\n" + menu);
            System.out.print("\nChoose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    itManagerBaseAccount.viewTasks();
                    break;
                case 2:
                    itManagerBaseAccount.viewPersons();
                    break;
                case 3:
                    itManagerBaseAccount.showTasksDescending();
                    break;
                case 4:
                    itManagerBaseAccount.showTasksAscending();
                    break;
                case 5:
                    itManagerBaseAccount.newTask();
                    break;
                case 6:
                    itManagerBaseAccount.showDescription();
                    break;
                case 7:
                    itManagerBaseAccount.addPerson();
                case 8:
                    itManagerBaseAccount.changeTaskState();
                    break;
                case 9:
                    itManagerBaseAccount.changeAssignedTo();
                    break;
                case 10:
                    itManagerBaseAccount.deleteTask();
                    break;
                case 11:
                    itManagerBaseAccount.deletePerson();
                case 12:
                    itManagerBaseAccount.addNoteForSpecificTask();
                    break;
                case 13:
                    itManagerBaseAccount.editNoteFromSpecificTask();
                    break;
                case 14:
                    itManagerBaseAccount.deleteNote();
                    break;
                case 15:
                    itManagerBaseAccount.deleteAllNotes();
                    break;
                case 16:
                    itManagerBaseAccount.addReplayMessage();
                    break;
                case 17:
                    itManagerBaseAccount.editReplayMessage();
                    break;
                case 18:
                    itManagerBaseAccount.deleteReply();
                    break;
                case 19:
                    itManagerBaseAccount.viewListStateChanges();
                    break;
                case 20:
                    itManagerBaseAccount.viewNotes();
                    break;
                case 21:
                    itManagerBaseAccount.viewReply();
                    break;
                case 22:
                    itManagerBaseAccount.viewTaskByStatus();
                    break;
                case 23:
                    itManagerBaseAccount.exportTasksList();
                    break;
                case 24:
                    itManagerBaseAccount.importTaskList();
                    break;
                case 25:
                    itManagerBaseAccount.exportPersonData();
                    break;
                case 26:
                    itManagerBaseAccount.importPersonData();
                    break;
                case 27:
                    itManagerBaseAccount.changePassword();
                case 28:
                    itManagerBaseAccount.tasksIdReorganization();
                    break;
                case 29:
                    itManagerBaseAccount.personIdAndUsernameReorganization();
                    break;
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

