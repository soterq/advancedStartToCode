package tasks_for_weeks.task5;

import tasks_for_weeks.task5.enums.Department;
import tasks_for_weeks.task5.enums.Role;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;

public class Select {
    TaskState selectState(int number) {
        TaskState bugState;
        switch (number) {
            case 0:
                bugState = TaskState.CREATED;
                break;
            case 1:
                bugState = TaskState.IN_PROGRESS;
                break;
            case 2:
                bugState = TaskState.COMPLETED;
                break;
            default:
                bugState = null;
                break;
        }
        return bugState;
    }

    Role selectRole(int number) {
        Role role;
        switch (number) {
            case 0:
                role = Role.ARCHITECT;
                break;
            case 1:
                role = Role.AUTOMATION_QA;
                break;
            case 2:
                role = Role.DEVELOPER;
                break;
            case 3:
                role = Role.HELP_DESK;
                break;
            case 4:
                role = Role.IT_MANAGER;
                break;
            case 5:
                role = Role.MANUAL_QA;
                break;
            case 6:
                role = Role.NETWORK_ADMINISTRATOR;
                break;
            case 7:
                role = Role.WEB_DEV;
                break;
            default:
                role = null;
                break;
        }
        return role;
    }

    Department selectDepartment(int departmentNumber) {
        Department department;
        switch (departmentNumber) {
            case 0:
                department = Department.QA;
                break;
            case 1:
                department = Department.TEH_SUPPORT;
                break;
            case 2:
                department = Department.DEV;
                break;
            default:
                department = null;
                break;
        }
        return department;
    }

    TaskPriority selectPriority(int number) {
        TaskPriority bugPriority;
        switch (number) {
            case 0:
                bugPriority = TaskPriority.LOW;
                break;
            case 1:
                bugPriority = TaskPriority.MEDIUM;
                break;
            case 2:
                bugPriority = TaskPriority.CRITICAL;
                break;
            default:
                bugPriority = null;
                break;
        }
        return bugPriority;
    }
    boolean confirmation(int number){
        boolean confirm = false ;
        if (number == 1) {
            confirm = true;
        }
        return confirm;
    }
}
