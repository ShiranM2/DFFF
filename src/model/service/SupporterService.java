package model.service;


import general_classes.Supporter_details;
import model.repository.SupporterRepository;
import model.repository.SupporterRepositoryImpl;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SupporterService {
    private SupporterRepository repo;

    public SupporterService() throws IOException, ClassNotFoundException {
        repo= SupporterRepositoryImpl.getInstance();
    }

    public void addsupporter(Supporter_details supprter) throws Exception {
        try {
            repo.add(supprter);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        }


    public void showallsupporter() throws IOException {
        try {
            repo.printallsupporters();
        }
        catch (IOException ex){
            System.out.println(ex);
        }
    }

    public void deletesupporter(int id) throws IOException {
         repo.delete(id);
    }

    public void findsupporter(String command,String choise) throws Exception {
        Set<Supporter_details> help=new HashSet<>();
        if (command.equals("1")){
           help=repo.findbycity(choise);
           for(Supporter_details supporter_details:help)
           {
               System.out.println(supporter_details);
           }
        }
        if (command.equals("2")){
            help=repo.findByName(choise);
            for(Supporter_details supporter_details:help)
            {
                System.out.println(supporter_details);
            }
        }
        if (command.equals("3")){
            help=repo.findbytelephone(choise);
            for(Supporter_details supporter_details:help)
            {
                System.out.println(supporter_details);
            }
        }

           // System.out.println(repo.findbyid(choise);


    }


    public void editsupporter(String command,int id,String newedit) throws Exception {
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
