package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import tasks_for_weeks.task5.objects.Person;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reply {
    private int id;
    private Person person;
    private String comment;
    private Person replyTo;

    public Reply(Person person, String note) {
        this.person = person;
        this.comment = note;
    }

    public Reply() {
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
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @JsonGetter("ReplyTo")
    public Person getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Person replyTo) {
        this.replyTo = replyTo;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", person=" + person.getName() + " " + person.getSurname() + "  " + person.getUserName() +
                ", comment='" + comment + '\'' +
                ", replyTo=" + replyTo.getName() + " " + replyTo.getSurname() + "  " +person.getUserName() +
                '}';
    }
}
