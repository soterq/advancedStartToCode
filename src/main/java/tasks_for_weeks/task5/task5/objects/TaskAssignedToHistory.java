package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskAssignedToHistory {
    private String currentDate;
    private Person modifiedBy;
    private Person previousAssignedBy;
    private Person currentAssignedBy;

    public TaskAssignedToHistory(Person modifiedBy, Person previousAssignedBy, Person currentAssignedBy) {
        this.currentDate = generateCurrentData();
        this.modifiedBy = modifiedBy;
        this.previousAssignedBy = previousAssignedBy;
        this.currentAssignedBy = currentAssignedBy;
    }

    public TaskAssignedToHistory() {
    }

    String generateCurrentData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return dtf.format(LocalDateTime.now());
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

    @JsonGetter("PreviousAssignedBy")
    public Person getPreviousAssignedBy() {
        return previousAssignedBy;
    }

    public void setPreviousAssignedBy(Person previousAssignedBy) {
        this.previousAssignedBy = previousAssignedBy;
    }

    @JsonGetter("CurrentAssignedBy")
    public Person getCurrentAssignedBy() {
        return currentAssignedBy;
    }

    public void setCurrentAssignedBy(Person currentAssignedBy) {
        this.currentAssignedBy = currentAssignedBy;
    }

    @Override
    public String toString() {
        return "currentDate='" + currentDate + '\'' +
                ", modifiedBy=" + modifiedBy.getName() + " " + modifiedBy.getSurname() + " " + modifiedBy.getUserName() +
                ", previousAssignedBy=" + previousAssignedBy.getName() + " " + previousAssignedBy.getSurname() + " " + previousAssignedBy.getUserName() +
                ", currentAssignedBy=" + currentAssignedBy.getName() + " " + currentAssignedBy.getSurname() + " " + currentAssignedBy. getUserName()
                ;
    }
}
