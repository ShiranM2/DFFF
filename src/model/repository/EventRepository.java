package model.repository;



import general_classes.Event;
import general_classes.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public interface EventRepository  {
    public void add(Event event) throws Exception;

    public void delete(int id) throws IOException;
    void registerListener(User newlistener);

    void notifyAllObservers();
    public void editdescription(int id,String description) throws IOException;

    public void editdate(int id, LocalDate date) throws IOException;

    public void edittitle(int id, String title) throws IOException;
    public Set<Event> findbydate(LocalDate date) throws Exception;
    public void edittime(int id, LocalTime time) throws IOException;

    public Set<Event> getallevents();

    public void showallevents() throws IOException;


}
