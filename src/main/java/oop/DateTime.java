package oop;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
    private int day;
    private int month;
    private int year;
    private int hours;
    private int minutes;
    private int seconds;

    public DateTime() {
    }

    public DateTime(int day, int month, int year, int hours, int minutes, int seconds) throws Exception {
        if (day <= 0 || day > 31) {
            throw new Exception("Entered day " + day + " is not valid for data time");
        } else
            this.day = day;
        if (month <= 0 || month > 12) {
            throw new Exception("Entered month " + month + " is not valid for data time");
        } else
            this.month = month;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (year < currentYear || year < 1500) {
            throw new Exception("Entered year " + month + " is not valid for data time");
        } else
            this.year = year;

        if (hours <= 0 || hours > 24) {
            throw new Exception("Entered year " + hours + " is not valid for data time");
        } else
            this.hours = hours;

        if (minutes <= 0 || minutes > 60) {
            throw new Exception("Entered year " + minutes + " is not valid for data time");
        } else
            this.minutes = minutes;
        if (seconds <= 0 || seconds > 60) {
            throw new Exception("Entered year " + seconds + " is not valid for data time");
        } else
            this.seconds = seconds;
    }


    public String displayDate() {
        return this.day + "/" + this.month + "/" + this.year;
    }

    public String displayTime() {
        return this.hours + ":" + this.minutes + ":" + this.seconds;
    }

    public DateTime getCurrentDateTime() {
        DateTime dateTime = new DateTime();
        long milliseconds = System.currentTimeMillis();
        Date resultDate = new Date(milliseconds);

        dateTime.setDay(resultDate.getDay());
        dateTime.setMonth(resultDate.getMonth());
        dateTime.setYear(resultDate.getYear());
        dateTime.setHours(resultDate.getHours());
        dateTime.setHours(resultDate.getHours());
        dateTime.setMinutes(resultDate.getMinutes());
        dateTime.setSeconds(resultDate.getSeconds());
        return dateTime;
    }

    @Override
    public String toString() {
        return displayDate() + " " + displayTime();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
