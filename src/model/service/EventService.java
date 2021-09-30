package model.service;


import general_classes.Event;
import model.repository.EventRepository;
import model.repository.EventRepositoryImpl;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class EventService {
    private EventRepository repo;

    public EventService() throws IOException, ClassNotFoundException {
        repo = EventRepositoryImpl.getInstance();
    }

    public void eventadd(Event event) throws Exception {
        try {
            repo.add(event);
        }
        catch (Exception ex){
            System.out.println("can't add this supporter-already exist");
        }
    }

    public void showallevents() throws IOException {
        try {
            repo.showallevents();
        } catch (IOException ex) {
            System.out.println("there is a problem");
        }
    }

    public void deleteevents(int id) throws IOException {
        repo.delete(id);

    }

    public void find(LocalDate date) throws Exception {
        Set<Event> help = new HashSet<>();
        help = repo.findbydate(date);
        for (Event event1 : help) {
            System.out.println(event1);
        }

    }

    public void editevent(String command, int id, String newedit) throws Exception {
        if (command.equals("1")) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(newedit, formatter);
            repo.editdate(id, date);
        }
        if (command.equals("2")) {
            repo.edittitle(id, newedit);
        }
        if (command.equals("3")) {
            repo.editdescription(id, newedit);
        }
        if (command.equals("4")){
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH mm");
            LocalTime time1 = LocalTime.parse(newedit, formatter1);
            repo.edittime(id,time1);
        }

    }
}
