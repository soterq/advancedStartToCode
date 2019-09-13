package tasks_for_weeks.task5.objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Duration {
    private int hour;
    private int minutes;

    public Duration() {
    }


    public Duration(int hour, int minutes) {
        if (minutes > 59) {
            this.hour = hour + (minutes / 60);
            this.minutes = minutes % 60;
        } else {
            this.hour = hour;
            this.minutes = minutes;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return
                "hour=" + hour +
                        ", minutes=" + minutes
                ;
    }
}
