package view;



import controller.EventController;
import general_classes.Session;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventView {
    private EventController eventcontroller;

    public EventView() throws Exception {
        eventcontroller = EventController.getInstance();
    }

    public static void main(String[] args) throws Exception {
        EventView welcomeHit = new EventView();
        welcomeHit.Eventscliimpl();
    }


    public void Eventscliimpl() {
        System.out.println("Welcome to Event's managing page");
        System.out.println("Options:");
        System.out.println("1.Show all Events");
        System.out.println("2.Add new Event");
        System.out.println("3.Delete Event");
        System.out.println("4.Find Event by the date of event");
        System.out.println("5.Edit Event");
        System.out.println("6.Return to the genetral menu");
        try (Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    this.showevents();
                    break;
                case "2":
                    if(Session.getInstance().isadmin())
                      this.addevent();
                      else {
                       System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Eventscliimpl();
                    }
                    break;
                case "3":
                    if(Session.getInstance().isadmin())
                        this.deleteevent();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Eventscliimpl();
                    }
                    break;
                case "4":
                    this.findevent();
                    break;
                case "5":
                    if(Session.getInstance().isadmin())
                        this.editevent();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Eventscliimpl();
                    }
                case "6":
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();
                case "q":
                case "Q":
                default:
                    Eventscliimpl();

            }
        } catch (Exception e) {
            System.exit(1);
        }

    }

    public void addevent() {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println(" Enter the date in the following Format: dd/mm/yyyy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String scan = scanner.nextLine();
                LocalDate date = LocalDate.parse(scan, formatter);
                System.out.println("Enter the time in the following Format: hh mm");
                String time = scanner.nextLine();
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH mm");
                LocalTime time1 = LocalTime.parse(time, formatter1);
                System.out.println("Enter Event's Title");
                String title = scanner.nextLine();
                System.out.println("Enter Event's description");
                String description = scanner.nextLine();
                eventcontroller.addevent(date, time1, title, description);
            }
            catch (Exception ex)
            {
                System.out.println("The building didn't went well");
            }
            System.out.println("Want to return to Event menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Eventscliimpl();
            }
            else if(what.equals("no"))
            {
                addevent();
            }
            else{
                Eventscliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showevents() throws IOException {
        eventcontroller.showevent();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
        String what = scanner.nextLine();
        if(what.equals("yes")) {
            Eventscliimpl();
        }
        else if (what.equals("no"))
        {
            showevents();
        }
        else {
            Eventscliimpl();
        }
    }

    public void deleteevent() throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter events's id:");
            int id = Integer.parseInt(scanner.nextLine());
            eventcontroller.deleteevent(id);
            Eventscliimpl();
        }
         catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findevent() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println(" Enter the date in the following Format: dd/mm/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String scan = scanner.nextLine();
            LocalDate date = LocalDate.parse(scan, formatter);
            try {
                eventcontroller.find(date);
            }
            catch (Exception ex)
            {
                System.out.println(ex);
            }
            System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Eventscliimpl();
            }
            else if (what.equals("no"))
            {
                findevent();
            }
            else {
                Eventscliimpl();
            }
        }


    }

    public void editevent()
            {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.Edit by date? ");
            System.out.println("2.Edit by Title");
            System.out.println("3.Edit by desctiption");
            System.out.println("4.Edit by time");
            System.out.println("5.come back to event's menu");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("Enter event's id please ");
                    int iddate= Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the date in the following Format: dd/mm/yyyy");
                    String newdate = scanner.nextLine();
                    try {
                        eventcontroller.editevent(command, iddate, newdate);
                    }catch (Exception ex) {
                        System.out.println(ex);
                    }
                        System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
                        String what = scanner.nextLine();
                        if (what.equals("yes")) {
                            Eventscliimpl();
                        } else if (what.equals("no")) {
                            editevent();
                        } else {
                            Eventscliimpl();
                        }
                case "2":
                    System.out.println("Enter event's id please ");
                    int idtitle = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter event's new title please ");
                    String newtitle = scanner.nextLine();
                    try {
                        eventcontroller.editevent(command, idtitle, newtitle);
                    }catch (Exception ex) {
                        System.out.println(ex);
                    }
                        System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
                        String what1 = scanner.nextLine();
                        if (what1.equals("yes")) {
                            Eventscliimpl();
                        } else if (what1.equals("no")) {
                            editevent();
                        } else {
                            Eventscliimpl();
                        }

                case "3":
                    System.out.println("Enter event's id please");
                    int iddescription = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter event's new description please ");
                    String newdescription = scanner.nextLine();
                    try {
                        eventcontroller.editevent(command, iddescription, newdescription);
                    }catch (Exception ex) {
                        System.out.println(ex);
                    }
                        System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
                        String what4 = scanner.nextLine();
                        if (what4.equals("yes")) {
                            Eventscliimpl();
                        } else if (what4.equals("no")) {
                            editevent();
                        } else {
                            Eventscliimpl();
                        }

                case  "4":
                    System.out.println("Enter event's id please");
                    int idtime = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter event's new time please like this!! hh mm ");
                    String newtime = scanner.nextLine();
                    try {
                        eventcontroller.editevent(command, idtime, newtime);
                    }catch (Exception ex) {
                        System.out.println(ex);
                    }
                        System.out.println("Want to return to  Event menu ? yes/no" + " yes- return no-repeat this action");
                        String what5 = scanner.nextLine();
                        if (what5.equals("yes")) {
                            Eventscliimpl();
                        } else if (what5.equals("no")) {
                            editevent();
                        } else {
                            Eventscliimpl();
                        }
                case "5":
                    Eventscliimpl();
                default:
                    Eventscliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}





