package view;




import controller.VolunteerController;
import general_classes.Session;

import java.io.IOException;
import java.util.Scanner;

class VolunteerView {

    private VolunteerController volunteercontroller;

    public VolunteerView() throws IOException, ClassNotFoundException {
        volunteercontroller = new VolunteerController();
    }

    public static void main(String[] args) throws Exception {
        VolunteerView welcomeHit = new VolunteerView();
        welcomeHit.Volunteerscliimpl();
    }


    public void Volunteerscliimpl() throws Exception {
        System.out.println("Welcome to Volunteer's managing page");
        System.out.println("Options:");
        System.out.println("1.Show all volunteer");
        System.out.println("2.Add new volunteer");
        System.out.println("3.Delete volunteer");
        System.out.println("4.Find volunteer");
        System.out.println("5.Edit volunteer");
        System.out.println("6.Return to menu");
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine() ){
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    this.showvolunteer();
                    break;
                case "2":
                    this.addvolunteer();
                    break;
                case "3":
                    if(Session.getInstance().isadmin())
                        this.deletevolunteer();
                    else {
                        System.out.println("Only Campign manager and City Headquarter manager can do that");
                        Volunteerscliimpl();
                    }
                    break;
                case "4":
                    this.findvolunteer();
                    break;
                case "5":
                    this.editvolunteer();
                    break;
                case "6":
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();
                    break;
                case "q":
                case "Q":
                default:
                    System.exit(0);
                    //  Volunteerscliimpl();


                    scanner.close();

            }
        }


    }


    public void addvolunteer(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write volunteer's name:");
            String name = scanner.nextLine();
            System.out.println("Write volunteer's city");
            String city = scanner.nextLine();
            System.out.println("Write volunteer's telephone");
            String Telephone = scanner.nextLine();
            try {
                volunteercontroller.addVolunteer(name, city, Telephone);
            }
            catch (Exception ex) {
                System.out.println(ex);
            }
                System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
                String what = scanner.nextLine();
                if (what.equals("yes")) {
                    Volunteerscliimpl();
                } else if (what.equals("no")) {
                    addvolunteer();
                } else {
                    Volunteerscliimpl();
                }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void showvolunteer() throws Exception {
        volunteercontroller.showVolunteer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
        String what = scanner.nextLine();
        if(what.equals("yes")) {
            Volunteerscliimpl();
        }
        else if (what.equals("no"))
        {
            showvolunteer();
        }
        else {
            Volunteerscliimpl();
        }
    }

    public void deletevolunteer() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write volunteer's id:");
            int volunteerid = Integer.parseInt(scanner.nextLine());
            volunteercontroller.deletevolunteer(volunteerid);
            Volunteerscliimpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void findvolunteer() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.find by city? ");
            System.out.println("2.find by name?");
            System.out.println("3.find by telephone?");
            System.out.println("4.come back to volunteer's menu");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("write the city please ");
                    String city = scanner.nextLine();
                    volunteercontroller.findvolunteer(command,city);
                    break;
                case "2":
                    System.out.println("write the name please");
                    String name = scanner.nextLine();
                    volunteercontroller.findvolunteer(command,name);
                    break;
                case "3":
                    System.out.println("write the telephone please");
                    String telephone = scanner.nextLine();
                    volunteercontroller.findvolunteer(command,telephone);
                    break;
                case  "5":
                    Volunteerscliimpl();
                default:
                    Volunteerscliimpl();
            }
            System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                Volunteerscliimpl();
            }
            else if (what.equals("no"))
            {
                 findvolunteer();
            }
            else {
                Volunteerscliimpl();
            }

        }
    }


    public void editvolunteer() throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("1.edit by city? ");
            System.out.println("2.edit by name?");
            System.out.println("3.edit by telephone?");
            System.out.println("4.come back to volunteer's menu");
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    System.out.println("write volunteers id please ");
                    int idcity = Integer.parseInt(scanner.nextLine());
                    System.out.println("write volunteers new city please ");
                    String newcity = scanner.nextLine();
                    volunteercontroller.editvolunteer(command, idcity, newcity);
                    System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
                    String what = scanner.nextLine();
                    if(what.equals("yes")) {
                        Volunteerscliimpl();
                    }
                    else if (what.equals("no"))
                    {
                       editvolunteer();
                    }
                    else {
                        Volunteerscliimpl();
                    }
                case "2":
                    System.out.println("write volunteers id please ");
                    int idname = Integer.parseInt(scanner.nextLine());
                    System.out.println("write volunteers new name please ");
                    String newname = scanner.nextLine();
                    volunteercontroller.editvolunteer(command, idname, newname);
                    System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
                    String what1 = scanner.nextLine();
                    if(what1.equals("yes")) {
                        Volunteerscliimpl();
                    }
                    else if (what1.equals("no"))
                    {
                        editvolunteer();
                    }
                    else {
                        Volunteerscliimpl();
                    }
                case "3":
                    System.out.println("write volunteers id please ");
                    int idtelephone = Integer.parseInt(scanner.nextLine());
                    System.out.println("write volunteers new telephone please ");
                    String newtelephone = scanner.nextLine();
                    volunteercontroller.editvolunteer(command, idtelephone, newtelephone);
                    System.out.println("Want to return to Volunteer menu ? yes/no" + " yes- return no-repeat this action");
                    String what3 = scanner.nextLine();
                    if(what3.equals("yes")) {
                        Volunteerscliimpl();
                    }
                    else if (what3.equals("no"))
                    {
                        editvolunteer();
                    }
                    else {
                        Volunteerscliimpl();
                    }
                case "4":
                    Volunteerscliimpl();
                default:
                    Volunteerscliimpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}