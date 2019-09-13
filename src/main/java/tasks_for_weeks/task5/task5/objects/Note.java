package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tasks_for_weeks.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Note {

    private int id;
    private Person person;
    private String note;
    private List<Reply> replay = new ArrayList<>();

    public Note() {
    }

    public Note(Person person, String comment) throws InvalidInputException {
        if (person == null) {
            throw new InvalidInputException("Person should be not null");
        }
        if (comment == null || comment.isEmpty()) {
            throw new InvalidInputException("You enter empty note");
        }
        this.person = person;
        this.note = comment;
    }


    @JsonGetter("Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("Person")
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @JsonGetter("Note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @JsonGetter("Reply")
    public List<Reply> getReplay() {
        return replay;
    }

    public void setReplay(List<Reply> replay) {
        this.replay = replay;
    }

    public void addReply(Reply reply) {
        replay.add(reply);
    }

    @Override
    public String toString() {
        return "Note{" +
                "Id='" + id +
                "', person=" + person + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
