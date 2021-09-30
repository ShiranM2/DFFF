package model.repository;


import general_classes.Supporter_details;

import java.io.IOException;
import java.util.Set;



public interface SupporterRepository {

    public void add(Supporter_details supporter) throws Exception;


    public void editname(int id, String name) throws Exception;

    public void delete(int id) throws IOException;

    public Set<Supporter_details> showallsupporters();

    public void edittelephone(int id, String telephone) throws Exception;

    public void editcity(int id, String city) throws Exception;


    public Set<Supporter_details> findbytelephone(String telephone) throws Exception;

    public Set<Supporter_details> findbycity(String city) throws Exception;

    public Set<Supporter_details> findByName(String name) throws Exception;

    public void printallsupporters() throws IOException;

}



