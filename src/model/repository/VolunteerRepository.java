package model.repository;

import GeneralClasses.Volunteer_details;

import java.io.IOException;
import java.util.Set;

public interface VolunteerRepository {

    public void add(Volunteer_details volunteer) throws Exception;


    public void editname(int id, String name) throws IOException;

    public void delete(int id) throws IOException;

    public Set<Volunteer_details> showAll();

    public void edittelephone(int id, String telephone) throws Exception;

    public void editcity(int id, String city) throws IOException;


    public Set<Volunteer_details> findbytelephone(String telephone);

    public Set<Volunteer_details> findbycity(String city);

    public Set<Volunteer_details> findByName(String name);

    public void PrintAll() throws IOException;

    public void printSet(Set<Volunteer_details> theSet);

    public Boolean IsExist (Volunteer_details volunteer);

    public void printallvolunteers() throws IOException;



}
