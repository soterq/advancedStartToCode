package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.*;
import org.apache.log4j.Logger;
import tasks_for_weeks.exceptions.InvalidInputException;
import tasks_for_weeks.task5.TaskReporterImpl;
import tasks_for_weeks.task5.enums.TaskPriority;
import tasks_for_weeks.task5.enums.TaskState;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    private static Logger log;
    private int taskId;
    private String name;
    private String description;
    private TaskPriority priority;
    private String startDate;
    private Duration duration;
    private TaskState state;
    private Person createdBy;
    private Person assignedTo;
    private List<Note> notes = new ArrayList<>();
    private List<TaskStateHistory> taskStateHistories = new ArrayList<>();
    private List<TaskAssignedToHistory> taskAssignedToHistories = new ArrayList<>();

    public void setNote(Note notes) {
        this.notes.add(notes);
    }

    public Task() {
    }

    public Task(String name, String description, TaskPriority priority, Duration duration, TaskState states, Person createdBy, Person assignedTo) throws Exception {
        log = Logger.getLogger(TaskReporterImpl.class.getPackage().getName());

        emptyField(name);
        emptyField(description);

        if (priority == null) {
            log.error("User try to create new Task with empty priority");
            System.out.println("Task priority to field is empty");
        }
        if (states == null) {
            log.error("User try to create new Task with empty state");
            System.out.println("Task state to field is empty");
        }
        if (assignedTo == null) {
            log.error("User try to create new Task without assigned issue to person");
            System.out.println("Assigned to field is empty");
        }
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.state = states;
        this.duration = duration;
        this.assignedTo = assignedTo;
        this.createdBy = createdBy;
        this.startDate = generateCurrentData();
    }

    public String generateCurrentData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    @JsonGetter("Id")
    public int getTaskId() {
        return taskId;
    }

    @JsonSetter(value = "Id", nulls = Nulls.AS_EMPTY)
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @JsonGetter("AssignedTo")
    public Person getAssignedTo() {
        return assignedTo;
    }

    @JsonSetter(value = "AssignedTo", nulls = Nulls.AS_EMPTY)
    public void setAssignedTo(Person assignedTo) {
        this.assignedTo = assignedTo;
    }

    @JsonGetter("Notes")
    public List<Note> getNotes() {
        return notes;
    }

    @JsonSetter(value = "Notes", nulls = Nulls.AS_EMPTY)
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @JsonGetter("TaskStateHistory")
    public List<TaskStateHistory> getTaskStateHistories() {
        return taskStateHistories;
    }

    @JsonSetter(value = "TaskStateHistory", nulls = Nulls.AS_EMPTY)
    public void setTaskStateHistories(List<TaskStateHistory> taskStateHistories) {
        this.taskStateHistories = taskStateHistories;
    }

    public void addToStateHistory(TaskStateHistory taskHistory) {
        taskStateHistories.add(taskHistory);
    }

    private LocalDateTime currentData() {
        return LocalDateTime.now();
    }

    @JsonGetter("Name")
    public String getName() {
        return name;
    }

    @JsonSetter(value = "Name", nulls = Nulls.AS_EMPTY)
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("CreatedBy")
    public Person getCreatedBy() {
        return createdBy;
    }

    @JsonGetter("CreatedBy")
    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    @JsonGetter("Description")
    public String getDescription() {
        return description;
    }

    @JsonSetter(value = "Description", nulls = Nulls.AS_EMPTY)
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonGetter("Priority")
    public TaskPriority getPriority() {
        return priority;
    }

    @JsonSetter(value = "Priority", nulls = Nulls.AS_EMPTY)
    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }


    @JsonGetter("StartDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonSetter(value = "StartDate", nulls = Nulls.AS_EMPTY)
    public void setStartDate(String date) {
        this.startDate = date;
    }

    @JsonGetter("Duration")
    public Duration getDuration() {
        return duration;
    }

    @JsonSetter(value = "Duration", nulls = Nulls.AS_EMPTY)
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @JsonGetter("State")
    public TaskState getState() {
        return state;
    }

    @JsonSetter(value = "State", nulls = Nulls.AS_EMPTY)
    public void setState(TaskState state) {
        this.state = state;
    }

    @JsonGetter("TaskAssignedToHistories")
    public List<TaskAssignedToHistory> getTaskAssignedToHistories() {
        return taskAssignedToHistories;
    }

    @JsonSetter(value = "TaskAssignedToHistories", nulls = Nulls.AS_EMPTY)
    public void setTaskAssignedToHistories(List<TaskAssignedToHistory> taskAssignedToHistories) {
        this.taskAssignedToHistories = taskAssignedToHistories;
    }

    public void addToAssignedHistory(TaskAssignedToHistory taskAssignedToHistory) {
        taskAssignedToHistories.add(taskAssignedToHistory);
    }

    @Override
    public String toString() {
        return "\n" + "Task:" +
                " id='" + taskId + '\'' +
                ", Name='" + name + '\''
                + "  Priority=" + priority +
                "   Created at ='" + startDate + '\''
                + "  Duration=" + duration +
                "    State=" + state + "\n" +
                "Created by:" + createdBy.getName() + " " + createdBy.getSurname() + ", " + createdBy.getUserName() + "'      " +
                "  Assigned To: " + assignedTo.getName() + " " + assignedTo.getSurname() + ", " + assignedTo.getUserName()
                ;
    }

    private void emptyField(String name) throws InvalidInputException {
        if (name == null || name.isEmpty()) {
            throw new InvalidInputException("Name is required");
        }
    }
}
