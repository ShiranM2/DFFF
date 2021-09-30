package model.repository;

import FileManager.FileManager;
import GeneralClasses.Volunteer_details;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class VolunteerRepositoryImpl implements  VolunteerRepository {
    private final String FILENAME = "volunteers";
    private Set<Volunteer_details> volunteers;
    private FileManager<Volunteer_details> fileManager;
    private static VolunteerRepositoryImpl INSTANCE;


    private VolunteerRepositoryImpl() throws IOException, ClassNotFoundException {
        this.fileManager = new FileManager<Volunteer_details>(FILENAME);
        volunteers = new HashSet<Volunteer_details>();
        this.volunteers = fileManager.read();
    }

    public static VolunteerRepositoryImpl getInstance() throws IOException, ClassNotFoundException {
        if (INSTANCE == null) {
            INSTANCE = new VolunteerRepositoryImpl();
        }
        return INSTANCE;
    }


    @Override
    public void add(Volunteer_details volunteer) throws Exception {
        if (volunteer == null) {
            throw new Exception("must have a value");
        }
        for (Volunteer_details supporter1 : volunteers) {
            if (supporter1.equals(volunteer)) {
                throw new Exception("Already exists!");
            }
        }

        this.volunteers.add(volunteer);
        int id1=volunteers.size();
        volunteer.setadd_id(id1);
        this.fileManager.write(volunteers);
        System.out.println("new volunteer added!");
    }


    /*@Override
    public void add(Volunteer_details volunteer) throws Exception {
        if (volunteer == null) {
            throw new Exception("must have a value");
        }
        for (Volunteer_details volunteer1 : volunteers) {
            if (volunteer1.equals(volunteer)) {
                throw new Exception("Already exists!");
            }
        }
        this.volunteers.add(volunteer);
        this.fileManager.write(volunteers);
    }*/


    @Override
    public void delete(int id) throws IOException {
        int count =0;
        for(Volunteer_details volunteer : volunteers){
            if(volunteer.getVolunteer_id()== id) {
                volunteers.remove(volunteer);
                fileManager.write(volunteers);
                System.out.println(volunteer.getVolunteer_name() + " deleted");
                break;
            }
        }
        if(count==0){
            System.out.println("there is no such an ID");
        }
    }

    @Override
    public Set<Volunteer_details> showAll() {
        return this.volunteers;
    }


    @Override
    public Set<Volunteer_details> findbytelephone(String telephone) {

        Set<Volunteer_details> telephone_num = new HashSet<Volunteer_details>();
        for (Volunteer_details volunteer : volunteers) {
            String volunteer_num = volunteer.getVolunteer_telephone();
            if (volunteer_num==telephone) {
                System.out.println(volunteer);
                telephone_num.add(volunteer);
            }

        }
        if (telephone_num.isEmpty()){
            System.out.println("volunteer not found");
            return null;}
        else{
            return telephone_num;}
    }

    @Override
    public Set<Volunteer_details> findbycity(String city) {
        Set<Volunteer_details> cityfind = new HashSet<Volunteer_details>();
        for (Volunteer_details volunteer : volunteers) {
            String cityofvolunteer = volunteer.getVolunteer_city();
            if (volunteer.getVolunteer_city().equals(city)) {
                System.out.println(volunteer);
                cityfind.add(volunteer);
            }
        }
        if(cityfind.isEmpty())
        {
            System.out.println("There is no supporters on that City :(");
            return null;
        }
        else {
            return cityfind;
        }

    }

    @Override
    public Set<Volunteer_details> findByName(String choise) {
        Set<Volunteer_details> names = new HashSet<Volunteer_details>();
        for (Volunteer_details volunteer : volunteers) {
            //String nameofvolunteer = volunteer.getVolunteer_city();
            if (volunteer.getVolunteer_name().equals(choise)) {
                System.out.println(volunteer);
                names.add(volunteer);
            }
        }
        if(names.isEmpty())
        {
            System.out.println("There is no supporters by that name");
            return null;
        }
        return names;
    }


    @Override
    public void PrintAll() throws IOException {
        System.out.println(volunteers.size());
        if(volunteers.size()==0){
            System.out.println("there is no volunteers");

        }
        else
            for (Volunteer_details volunteer1 : volunteers) {
                System.out.println(volunteer1);
            }

    }

    @Override
    public void printSet(Set<Volunteer_details> theSet) {
        for(Volunteer_details setu: theSet){
            System.out.println(setu.toString());
        }

    }

    @Override
    public Boolean IsExist(Volunteer_details volunteer) {
        for(Volunteer_details volunteer1: volunteers){
            if(volunteer1 == volunteer){
                return true;
            }
        }
        return false;
    }

    @Override
    public void printallvolunteers() throws IOException {
        System.out.println(volunteers.size());
        for (Volunteer_details volunteer1 : volunteers) {
            System.out.println(volunteer1);
        }
    }


    @Override
    public void editname(int id, String name) throws IOException {

        for (Volunteer_details volunteer1 : volunteers) {
            if (volunteer1.getVolunteer_id()== id); {
                volunteer1.setVolunteer_name(name);
                fileManager.write(volunteers);
                break;
            }
        }

    }


    @Override
    public void editcity(int id, String city) throws IOException {
        for (Volunteer_details volunteer1 : volunteers) {
            if (volunteer1.getVolunteer_id() == id) {
                volunteer1.setVolunteer_city(city);
                fileManager.write(volunteers);
                break;
            }
        }
    }

    @Override
    public void edittelephone(int id, String telephone) throws Exception {
        for (Volunteer_details volunteer1 : volunteers) {
            if (volunteer1.getVolunteer_id() == id) {
                volunteer1.setVolunteer_telephone(telephone);
                fileManager.write(volunteers);
                break;
            }
        }
    }

}
