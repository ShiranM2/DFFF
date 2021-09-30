package general_classes;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;


public class Event  implements Serializable  {

    public LocalDate Date_of_event;
    public LocalTime time;
    private String event_title;
    private String description;
    private int id = 0;
    private static int count = 0;





    public Event(LocalDate date, LocalTime time, String event_title, String description) {
        Date_of_event =date;
        this.time=time;
        this.event_title = event_title;
        this.description = description;
        set_id();

    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public void setDate_of_event(LocalDate date) {
        Date_of_event = date;
    }
    public  int getId() {
        return id;
    }

    public void set_id() {
        count = count + 1;
        this.id = count;
    }
    public void setadd_id(int id){
        this.id=id;
    }

    public void setdeleteid(int id){
        this.id=id;
    }


    @Override
    public String toString() {
        return "Event{" +
                "Date_of_event=" +   Date_of_event +
                ", Time of event=" + time + '\'' +
                ", event_title='" + event_title + '\'' +
                ", description='" + description + '\'' +
                ", id='"+ id + '\'' +  '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals( Date_of_event, event.Date_of_event) &&
                Objects.equals( time, event.time) &&
                Objects.equals(event_title, event.event_title) &&
                Objects.equals(description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Date_of_event, event_title, description);
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public LocalDate getDate_of_event() {
        return Date_of_event;
    }

    public String getEvent_title() {
        return event_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
