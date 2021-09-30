package model.service;


import GeneralClasses.Volunteer_details;
import model.repository.VolunteerRepository;
import model.repository.VolunteerRepositoryImpl;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class VolunteerService {
    private VolunteerRepository repo;

    public VolunteerService() throws IOException, ClassNotFoundException {
        repo= VolunteerRepositoryImpl.getInstance();
    }

    public void addvolunteer(Volunteer_details volunteer) throws Exception {
        repo.add(volunteer);
    }


    public void showallvolunteer() throws IOException {
        try {
            repo.printallvolunteers();
        }
        catch (IOException ex){
            System.out.println("there is a problem");
        }
    }

    public void deletevolunteer(int id) throws IOException {
        repo.delete(id);
    }

    public void findvolunteer(String command,String choise){
        Set<Volunteer_details> help=new HashSet<>();
        if (command.equals("1")){
            help=repo.findbycity(choise);
            for(Volunteer_details volunteer_details:help)
            {
                System.out.println(volunteer_details);
            }
        }
        if (command.equals("2")){
            help=repo.findByName(choise);
            for(Volunteer_details volunteer_details:help)
            {
                System.out.println(volunteer_details);
            }
        }
        if (command.equals("3")){
            help=repo.findbytelephone(choise);
            for(Volunteer_details volunteer_details:help)
            {
                System.out.println(volunteer_details);
            }
        }

        // System.out.println(repo.findbyid(choise);


    }


    public void editvolunteer(String command,int id,String newedit) throws Exception {
        if (command.equals("1")){
            repo.editcity(id,newedit);
        }
        if (command.equals("2")){
            repo.editname(id,newedit);
        }
        if (command.equals("3")){
            repo.edittelephone(id,newedit);
        }

    }
}