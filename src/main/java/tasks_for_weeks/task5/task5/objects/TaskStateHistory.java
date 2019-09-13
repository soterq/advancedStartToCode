package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tasks_for_weeks.task5.enums.TaskState;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskStateHistory {
    private String previousActionDate;
    private String currentDate;
    private Person modifiedBy;
    private TaskState previousState;
    private TaskState currentState;

    public TaskStateHistory(String previousActionDate, Person modifiedBy, TaskState previousState, TaskState currentState) {
        this.previousActionDate = previousActionDate;
        this.currentDate = generateCurrentData();
        this.modifiedBy = modifiedBy;
        this.previousState = previousState;
        this.currentState = currentState;

    }

    String generateCurrentData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
    }

    public TaskStateHistory() {
    }


    @JsonGetter("PreviousActionDate")
    public String getPreviousActionDate() {
        return previousActionDate;
    }


    public void setPreviousActionDate(String previousActionDate) {
        this.previousActionDate = previousActionDate;
    }

    @JsonGetter("CurrentDate")
    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    @JsonGetter("ModifiedBy")
    public Person getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Person modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonGetter("PreviousState")
    public TaskState getPreviousState() {
        return previousState;
    }

    public void setPreviousState(TaskState previousState) {
        this.previousState = previousState;
    }

    @JsonGetter("CurrentState")
    public TaskState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(TaskState currentState) {
        this.currentState = currentState;
    }

    @Override
    public String toString() {
        return "previousActionDate='" + previousActionDate + '\'' +
                ", currentDate='" + currentDate + '\'' +
                ", modifiedBy=" + modifiedBy.getName() + " " + modifiedBy.getSurname() + " " + modifiedBy.getUserName() +
                ", previousState=" + previousState +
                ", currentState=" + currentState
                ;
    }
}
