package tasks_for_weeks.task5;

import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;

import java.io.IOException;
import java.util.List;

public interface TaskReporter {

    void addTask(Task task) throws Exception;

    void addPerson(Person person) throws Exception;

    void changeTaskState(int taskId, TaskState newState);

    void addNoteToSpecificTask(int taskId, Note note) throws Exception;

    void addReplyToSpecificNote(int taskId, int noteId, Reply replyNote);

    void editNoteToSpecificTask(int taskId, int noteId, String newNotes);

    void editReplyFromSpecificNote(int taskId, int noteId, int replyMessageId, String newNotes);

    void deleteNoteToSpecificTask(int taskId, int noteId) throws Exception;

    void deleteReplyFromSpecificNote(int taskId, int noteId, int replyMessageId);

    void deleteAllNotes(int id);

    void showNotes(int id);

    void showSubNotes(int taskId, int noteId);

    void viewTasks();

    void viewPersons();

    void viewTasksByState(TaskState bugState);

    void sortDescendingByPriority();

    void sortAscendingByPriority();

    Task getTaskById(int id);

    Note getNoteById(int taskId, int noteId);

    Reply getReplyById(int taskID, int noteId, int replyId);

    Person getPerson(String userName);

    List<Task> getTaskList();

    boolean taskIdExist(int id);

    boolean noteIdExist(int taskId, int id);

    boolean replyIdExists(int taskId, int noteId, int id);

    Person findPersonByUsername(String userName);

    void deletePerson(String surname);

    void deleteTask(int taskId);

    void changeAssignedTo(int taskID, Person newPerson);

    List<Task> personIsAssigned(String userName);

    void changePassword(Person person, String newPassword);

    void getHistory(int id);

    void getAssignedHistory(int id);

    Person loginVerification(String userName);

    boolean usernameExist(String username);

    void showDescription(int id);

    void loadTaskData(String path) throws Exception;

    void loadPersonData(String path) throws Exception;

    void importTaskData(String path) throws Exception;

    void importPersonData(String path) throws IOException, IllegalActionException;

    void exportData(String path) throws Exception;

    void exportPersonData(String path) throws Exception;

    void personIdAndUsernameReorganization();

    void tasksIdReorganization();

    void restorePassword(Person person, String password);
}
