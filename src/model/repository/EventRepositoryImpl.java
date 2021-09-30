package model.repository;

import FileManager.FileManager;
import general_classes.Event;
import general_classes.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class EventRepositoryImpl  extends Observable implements EventRepository {
    private final String FILENAME = "Events";
    private Set<Event> events;
    private FileManager<Event> fileManager;
    private static EventRepositoryImpl INSTANCE;




    private EventRepositoryImpl() throws IOException, ClassNotFoundException {
        this.fileManager = new FileManager<Event>(FILENAME);
        events = new HashSet<Event>();
        this.events = fileManager.read();
    }



    public void notifyAllObservers(){
        super.notifyObservers(this);
    }


    public static EventRepositoryImpl getInstance() throws IOException, ClassNotFoundException {
        if (INSTANCE == null) {
            INSTANCE = new EventRepositoryImpl();
        }
        return INSTANCE;
    }

    public void registerListener(User newlistener) {
       this.addObserver((Observer) newlistener);

    }

    /*public void notifyAllListeners(Event event1) {
        int size = listeners.size();
       for (int i = 0; i < size; i++) {
         listeners.elementAt(i).NewEventadded(event1);
       }
    } */

    @Override
    public void add(Event event) throws Exception {
        if (event == null) {
            throw new Exception("must have a value");
        }
        for (Event event1: events) {
            if (event.equals(event1)) {
                throw new Exception("Already exists!");
            }
        }

        this.events.add(event);
        int id1=events.size();
        event.setadd_id(id1);
        this.fileManager.write(events);
        System.out.println("new event added!");
        System.out.println(event);
    }


    @Override
    public void delete(int id) throws IOException {
        int count=0;
        for (Event event1: events) {
            if (event1.getId() == id) {
                count++;
                events.remove(event1);
                fileManager.write(events);
                System.out.println("event deleted");
                break;
            }

        }
        fileManager.write(events);
        if(count==0){
            System.out.println("no such event");
        }
        int i=1;
        for(Event event1: events)
        {
            event1.setdeleteid(i);
            i++;
        }

    }

    @Override
    public Set<Event> findbydate(LocalDate date) throws Exception {
        Set<Event> date1= new HashSet<Event>();
        for (Event event1 : events) {
            if (event1.getDate_of_event().isEqual(date)) {
                date1.add(event1);
            }
        }
        if(date1.isEmpty())
        {
           throw new Exception("event not found");
        }
        else {
            return date1;
        }
    }

    @Override
    public void editdescription(int id, String description) throws IOException {
        for (Event event1 : events) {
            if (event1.getId() == id) {
                if(event1.getDescription().equals(description)){
                    System.out.println("There is no change,please try another desctiption");
                    break;
                }
                else {
                    event1.setDescription(description);
                    fileManager.write(events);
                    System.out.println("change is done");
                    System.out.println(event1);
                    break;
                }
            }
        }

    }

    @Override
    public void editdate(int id, LocalDate date) throws IOException {
        for (Event event1 : events) {
            if (event1.getId() == id) {
                if(event1.getDate_of_event().isEqual(date)){
                    System.out.println("There is no change,please try another date..");
                    break;
                }
                else {
                    event1.setDate_of_event(date);
                    fileManager.write(events);
                    System.out.println("change is done");
                    System.out.println(event1);
                    break;
                }
            }
        }

    }
    @Override
    public void edittime(int id, LocalTime time) throws IOException {
        int count=0;
        for (Event event1 : events) {
            if (event1.getId() == id) {
                if(event1.getTime().equals(time)){
                    System.out.println("There is no change,please try another time..");
                    break;
                }
                else {
                    event1.setTime(time);
                    fileManager.write(events);
                    System.out.println("change is done");
                    System.out.println(event1);
                    break;
                }
            }
        }
    }


    @Override
    public void edittitle(int id, String title) throws IOException {
        for (Event event1 : events) {
            if (event1.getId() == id) {
                if(event1.getEvent_title().equals(title)){
                    System.out.println("There is no change,please try another title..");
                    break;
                }
                else {
                    event1.setEvent_title(title);
                    fileManager.write(events);
                    System.out.println("change is done");
                    System.out.println(event1);
                    break;
                }
            }
        }

    }

    @Override
    public Set<Event> getallevents() {
        if (events.isEmpty())
        {
            return null;
        }
        else {
            return this.events;
        }
    }

    @Override
    public void showallevents() throws IOException {
        System.out.println(events.size());
        for (Event event1 : events) {
            System.out.println(event1);
        }
    }

}
