package controller;


import general_classes.Event;
import model.service.EventService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class EventController {
    private EventService eventmodel;
    private static EventController INSTANCE;

    public EventController() throws IOException, ClassNotFoundException {
        eventmodel=new EventService ();

    }
    public static  EventController getInstance() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new  EventController();
        }
        return INSTANCE;
    }

    public void addevent(LocalDate date, LocalTime time, String event_title, String description) throws Exception {
        try{
            if(date.isBefore(LocalDate.now())){
                throw new Exception();
            }
            else{
                Event event = new Event(date,time,event_title,description);
                eventmodel.eventadd(event);
            }
        }catch (Exception newexception){
            System.out.println("date passed please try again");
        }



    }


    public void showevent() throws IOException {
        try {
            eventmodel.showallevents();
        } catch (IOException ex) {
            System.out.println("there is a problem");
        }

    }
    public void deleteevent(int id) throws IOException {
        eventmodel.deleteevents( id);
    }
    public void find(LocalDate date){
        try {
            eventmodel.find(date);
        }
        catch (Exception c){
            System.out.println(c);
        }
    }

    public void editevent(String command,int id,String newedit) throws Exception {

        eventmodel.editevent(command,id,newedit);
    }

}
