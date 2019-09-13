package tasks_for_weeks.task5;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.log4j.Logger;
import tasks_for_weeks.exceptions.IllegalActionException;
import tasks_for_weeks.task5.enums.TaskState;
import tasks_for_weeks.task5.objects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class TaskReporterImpl implements TaskReporter {
    private List<Task> taskList;
    private List<Person> personList;
    private static Logger log;

    private static TaskReporterImpl taskReporter;


    public TaskReporterImpl() {
        this.taskList = new ArrayList<>();
        this.personList = new ArrayList<>();
        log = Logger.getLogger(TaskReporterImpl.class.getName());
    }

    public static TaskReporterImpl getInstance() {
        if (taskReporter == null) {
            taskReporter = new TaskReporterImpl();
        }
        return taskReporter;
    }

    @Override
    public void addTask(Task task) {
        if (!taskList.isEmpty()) {
            int id = generateId();
            task.setTaskId(id);
            log.info("id " + (id) + " was generified for task " + task.getName());
        } else {
            log.info("id '1' was generified for task " + task.getName());
            task.setTaskId(1);
        }
        taskList.add(task);
        log.info("Task : " + task.getName() + " was added to bug reporter");
    }

    public void addPerson(Person person) {
        if (!personList.isEmpty()) {
            int id = generatePersonId();
            person.setId(id);
            log.info("id " + (id) + " was generified for person " + person.getName() + " " + person.getSurname());
        } else {
            person.setId(1);
            log.info("id '1' was generified for person " + person.getName() + " " + person.getSurname());
        }
        personList.add(person);
    }

    @Override
    public void changeTaskState(int id, TaskState newState) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                log.info("State for task with " + id + " was changed to " + newState);
                taskList.get(getIndexOfTask(task)).setState(newState);
            }
        }
    }

    @Override
    public void addNoteToSpecificTask(int id, Note note) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                if (!task.getNotes().isEmpty()) {
                    note.setId(generateNoteId(task));
                } else {
                    note.setId(1);
                }
                task.setNote(note);
                log.info("User : " + note.getPerson().getName() + " " + note.getPerson().getSurname() + " " + note.getPerson().getRole() + " from department " + note.getPerson().getDepartment() +
                        "  add note on post " + task.getName() + " :" + note.getNote());
            }
        }
    }

    @Override
    public void addReplyToSpecificNote(int taskId, int noteId, Reply replyNote) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        replyNote.setReplyTo(note.getPerson());
                        if (note.getReplay().isEmpty()) {
                            replyNote.setId(1);
                        } else {
                            replyNote.setId(generateReplyId(note));
                        }
                        note.addReply(replyNote);
                    }
                }
            }
        }
    }

    @Override
    public void editNoteToSpecificTask(int taskId, int noteId, String newNotes) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note noteElement : task.getNotes()) {
                    if (noteElement.getId() == noteId) {
                        noteElement.setNote(newNotes);
                        log.info("Note " + noteElement.getNote() + "from task " + task.getName() + "was changed to " + newNotes);
                    }
                }
            }
        }
    }

    @Override
    public void editReplyFromSpecificNote(int taskId, int noteId, int replyMessageId, String newNotes) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        for (Reply reply : note.getReplay()) {
                            if (reply.getId() == replyMessageId) {
                                reply.setComment(newNotes);
                                log.info("Reply '" + reply.getComment() + "' for comment " + note.getNote() + "from task " + task.getName() + "was changed to " + newNotes);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void deleteNoteToSpecificTask(int id, int noteId) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        task.getNotes().remove(note);
                        log.info("Note with id " + noteId + "was removed from task with id" + id);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void deleteReplyFromSpecificNote(int taskId, int noteId, int replyMessageId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        for (Reply reply : note.getReplay()) {
                            if (reply.getId() == replyMessageId) {
                                note.getReplay().remove(reply);
                                log.info("Replay with id " + replyMessageId + " was removed from comment with id " + noteId + " from task with id" + taskId);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public void deleteAllNotes(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                task.getNotes().clear();
                log.info("All notes from task" + id + "was deleted");
            }
        }
    }


    @Override
    public void showNotes(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                for (Note note : task.getNotes()) {
                    System.out.println(note.toString());
                }
            }
        }
    }

    public void showSubNotes(int taskId, int noteId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        for (Reply reply : note.getReplay()) {
                            System.out.println(reply.toString());
                        }
                    }
                }
            }
        }
    }

    @Override
    public void viewTasks() {
        for (Task task : taskList) {
            System.out.println(task.toString());
        }
    }

    public void viewPersons() {
        personList.sort(new PersonComparator());
        for (Person person : personList) {
            System.out.println(person.toString());
        }

    }

    @Override
    public void viewTasksByState(TaskState taskState) {
        for (Task task : taskList) {
            if (task.getState().equals(taskState)) {
                System.out.println(task.toString());
            }
        }
    }

    @Override
    public void sortDescendingByPriority() {
        taskList.sort(new TaskComparator());
        log.info("Task list was descending sorted");
    }

    @Override
    public void sortAscendingByPriority() {
        taskList.sort(new TaskComparator());
        Collections.reverse(taskList);

    }


    @Override
    public Task getTaskById(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                return task;
            }
        }

        return null;
    }

    @Override
    public Note getNoteById(int taskId, int noteId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        return note;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Reply getReplyById(int taskId, int noteId, int replyId) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        for (Reply reply : note.getReplay()) {
                            if (reply.getId() == replyId) {
                                return reply;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public Person getPerson(String username) {
        for (Person person : personList) {
            if (person.getUserName().equals(username)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Task> getTaskList() {
        return taskList;
    }


    @Override
    public boolean taskIdExist(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean noteIdExist(int taskId, int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == id) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean replyIdExists(int taskId, int noteId, int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == taskId) {
                for (Note note : task.getNotes()) {
                    if (note.getId() == noteId) {
                        for (Reply reply : note.getReplay()) {
                            if (reply.getId() == id) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void deleteTask(int taskId) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getTaskId() == taskId) {
                System.out.println("Task with name '" + taskList.get(i).getName() + "' was removed");
                log.info("Task " + taskList.get(i).getName() + " was removed");
                taskList.remove(i);
                break;
            }
        }
    }

    @Override
    public Person findPersonByUsername(String userName) {
        for (Person person : personList) {
            if (person.getUserName().equals(userName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public void deletePerson(String surname) {
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getUserName().equals(surname)) {
                System.out.println("Person " + personList.get(i).toString() + " was removed");
                log.info("Person " + personList.get(i).toString() + " was removed");
                personList.remove(i);
                break;
            }
        }
    }

    @Override
    public void changeAssignedTo(int taskId, Person newPerson) {
        if (newPerson != null) {
            for (Task task : taskList) {
                if (task.getTaskId() == taskId) {
                    System.out.println("Assigned person '" + task.getAssignedTo().getName() + " " + task.getAssignedTo().getSurname()
                            + " to task: '" + task.getName() + "' was changed to " + newPerson.getName() + " " + newPerson.getSurname());
                    log.info("Assigned person '" + task.getAssignedTo().getName() + " " + task.getAssignedTo().getSurname()
                            + " to task: '" + task.getName() + "' was changed to " + newPerson.getName() + " " + newPerson.getSurname());
                    task.setAssignedTo(newPerson);
                }
            }
        }
    }

    @Override
    public List<Task> personIsAssigned(String userName) {
        List<Task> tasks = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getAssignedTo().getUserName().equals(userName)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    @Override
    public void changePassword(Person person, String newPassword) {
        log.info("Password for person" + person.getName() + " " + person.getSurname() + " was changed");
        person.setPassword(newPassword);
    }

    @Override
    public void getHistory(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                for (TaskStateHistory taskStateHistory : task.getTaskStateHistories()) {
                    System.out.println(taskStateHistory);
                }
            }
        }
    }

    @Override
    public void getAssignedHistory(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                for (TaskAssignedToHistory assignedToHistory : task.getTaskAssignedToHistories()) {
                    System.out.println(assignedToHistory);
                }
            }
        }
    }

    @Override
    public Person loginVerification(String userName) {
        for (Person person : personList) {
            if (person.getUserName().equals(userName)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public boolean usernameExist(String username) {
        for (Person person : personList) {
            if (person.getUserName().equals(username)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void loadTaskData(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try {
            taskList = mapper.readValue(new File(path), new TypeReference<List<Task>>() {
            });
        } catch (JsonMappingException e) {
            log.error("Json file from '" + path + "' is broken ");
            throw new IllegalActionException("Impossible to lod data from file :" + path + "\n Json file is broken pleas verify file and try again \n " + e);
        } catch (FileNotFoundException e) {
            throw new IllegalActionException("Impossible to lod data from file, file with path '" + path + "' do not exist \n" + e);
        }
    }


    @Override
    public void loadPersonData(String path) throws IOException, IllegalActionException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            personList = mapper.readValue(new File(path), new TypeReference<List<Person>>() {
            });
        } catch (JsonMappingException e) {
            log.error("Json file from '" + path + "' is broken ");
            throw new IllegalActionException("Impossible to lod data from file :" + path + "\n Json file is broken pleas verify file and try again \n " + e);
        } catch (FileNotFoundException e) {
            throw new IllegalActionException("Impossible to lod data from file, file with path '" + path + "' does not exist \n" + e);
        }
    }


    @Override
    public void importTaskData(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        List<Task> importedtask;
        try {
            importedtask = mapper.readValue(new File(path), new TypeReference<List<Task>>() {
            });
        } catch (JsonMappingException e) {
            log.error("Json file from '" + path + "' is broken ");
            throw new IllegalActionException("Impossible to lod data from file :" + path + "\n Json file is broken pleas verify file and try again \n " + e);
        } catch (FileNotFoundException e) {
            throw new IllegalActionException("Impossible to lod data from file, file with path '" + path + "' do not exist \n" + e);
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Some imported task can have the same id with task which is already present\n"
                + "We can generate new id for imported task\n" +
                "Do you want to generate new id for task who is repeated\n" +
                "1 - Yes\n2 - No");
        int option = scn.nextInt();
        if (option == 1) {
            for (Task task : importedtask) {
                if (containsId(task.getTaskId())) {
                    task.setTaskId(generateId());
                    taskList.add(task);
                } else {
                    taskList.add(task);
                }
            }
        } else {
            taskList.addAll(importedtask);
        }

    }

    private void regenerateId() {
        for (int i = 0; i < taskList.size(); i++) {
            for (int j = 0; j < taskList.size(); j++) {
                if (i != j) {
                    if (taskList.get(i).getTaskId() == taskList.get(j).getTaskId()) {
                        taskList.get(j).setTaskId(generateId());
                    }
                }
            }
        }
    }

    private boolean containsId(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void importPersonData(String path) throws IOException, IllegalActionException {
        ObjectMapper mapper = new ObjectMapper();
        List<Person> importedPersons;
        try {
            importedPersons = mapper.readValue(new File(path), new TypeReference<List<Person>>() {
            });
        } catch (JsonMappingException e) {
            log.error("Json file from '" + path + "' is broken ");
            throw new IllegalActionException("Impossible to lod data from file :" + path + "\n Json file is broken pleas verify file and try again \n " + e);
        } catch (FileNotFoundException e) {
            throw new IllegalActionException("Impossible to lod data from file, file with path '" + path + "' does not exist \n" + e);
        }
        Scanner scn = new Scanner(System.in);
        for (Person importedPerson : importedPersons) {
            for (Person currentPerson : personList) {
                if (importedPerson.getId() == currentPerson.getId()) {
                    System.out.println("Person with id " + importedPerson.getId() + " is already present in person list, and can not be added because id should be unique\n" +
                            "We can generate another id for current person \n" +
                            "Do you want to generate new id for current person" +
                            "1 - Yes\n2 - No");
                    int option = scn.nextInt();
                    if (option == 1) {
                        currentPerson.setId(generateId());
                        personList.add(importedPerson);
                    } else {
                        System.out.println("Person was not added");
                    }
                } else if (importedPerson.getUserName().equals(currentPerson.getUserName())) {
                    System.out.println("Person with username" + importedPerson.getUserName() + " is already in in person list, and can not be added because username should be unique" +
                            "We can generate random number after current username and current username will be different from existing username \n" +
                            "Do you want to generate new username for current person" +
                            "1 - Yes\n2 - No");
                    int option = scn.nextInt();
                    if (option == 1) {
                        String username = currentPerson.getUserName() + random();
                        currentPerson.setUserName(username);
                        System.out.println("New username is : " + username);
                    } else {
                        System.out.println("Person was not added");
                    }
                } else {
                    personList.add(importedPerson);
                }
            }
        }
    }

    @Override
    public void exportData(String path) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(path), taskList);
        } catch (FileNotFoundException e) {
            log.error("Json file from '" + path + "' do not exist");
            throw new IllegalActionException("Impossible to export data, this path '" + path + "' does not exist \n" + e);
        }
    }

    @Override
    public void exportPersonData(String path) throws IOException, IllegalActionException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        try {
            writer.writeValue(new File(path), personList);
        } catch (FileNotFoundException e) {
            log.error("Json file from '" + path + "' do not exist");
            throw new IllegalActionException("Impossible to export data, this path '" + path + "' does not exist \n" + e);
        }
    }

    public void showDescription(int id) {
        for (Task task : taskList) {
            if (task.getTaskId() == id) {
                System.out.println(task.getDescription());
            }
        }
    }

    private int getIndexOfTask(Task task) {
        for (int i = 0; i < taskList.size(); i++) {
            if (task.equals(taskList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private int generatePersonId() {
        int max = 0;
        for (Person person : personList) {
            if (person.getId() > max) {
                max = person.getId();
            }
        }
        return max + 1;
    }

    private int generateId() {
        int max = 0;
        for (Task task : taskList) {
            if (task.getTaskId() > max) {
                max = task.getTaskId();
            }
        }
        return max + 1;
    }

    private int generateNoteId(Task task) {
        int max = 0;
        for (Note note : task.getNotes()) {
            if (note.getId() > max) {
                max = note.getId();
            }
        }
        return max + 1;
    }

    private int generateReplyId(Note note) {
        int max = 0;
        for (Reply reply : note.getReplay()) {
            if (reply.getId() > max) {
                max = reply.getId();
            }
        }
        return max + 1;
    }

    private int random() {
        Random rand = new Random();
        return rand.nextInt(1000);
    }
}
