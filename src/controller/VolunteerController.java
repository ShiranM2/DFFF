package controller;


import GeneralClasses.Volunteer_details;
import model.service.VolunteerService;


import java.io.IOException;

public class VolunteerController {
    private VolunteerService volunteermodel;

    public VolunteerController() throws IOException, ClassNotFoundException {
        volunteermodel=new VolunteerService();

    }

    public void addVolunteer(String name,String city,String telephone) throws Exception {
        Volunteer_details volunteer1 = new Volunteer_details(name, city, telephone);
        try {
            volunteermodel.addvolunteer(volunteer1);
        }
        catch (Exception ex){
            System.out.println("can't add this volunteer-already exist");
        }


    }

    public void showVolunteer() throws IOException {
        volunteermodel.showallvolunteer();

    }
    public void deletevolunteer(int id) throws IOException {
        volunteermodel.deletevolunteer(id);

    }

    public void findvolunteer(String command,String choise){
        volunteermodel.findvolunteer(command,choise);

    }


    public void editvolunteer(String command,int id,String newedit) throws Exception {

        volunteermodel.editvolunteer(command, id, newedit);
    }

}