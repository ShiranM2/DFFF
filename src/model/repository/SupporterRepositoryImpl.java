package model.repository;


import FileManager.FileManager;
import general_classes.Supporter_details;

import java.io.IOException;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;


public class SupporterRepositoryImpl  implements SupporterRepository {
    private final String FILENAME = "supporters";
    private Set<Supporter_details> supporters;
    private FileManager<Supporter_details> fileManager;
    private static SupporterRepositoryImpl INSTANCE;


    private SupporterRepositoryImpl() throws IOException, ClassNotFoundException {
        this.fileManager = new FileManager<Supporter_details>(FILENAME);
        supporters = new HashSet<Supporter_details>();
        this.supporters = fileManager.read();
    }

    public static SupporterRepositoryImpl getInstance() throws IOException, ClassNotFoundException {
        if (INSTANCE==null)
        {
            INSTANCE=new SupporterRepositoryImpl();
        }
        return INSTANCE;
    }


    @Override
    public void add(Supporter_details supporter) throws Exception {
        if (supporter == null) {
            throw new Exception("must have a value");
        }
        for (Supporter_details supporter1 : supporters) {
            if (supporter1.equals(supporter)) {
                throw new Exception("Already exists!");
            }
        }

        this.supporters.add(supporter);
        int id1=supporters.size();
        supporter.setadd_id(id1);
        this.fileManager.write(supporters);
        System.out.println("new user added!");
        System.out.println(supporter);
    }


    @Override
    public void delete(int id) throws IOException {
        int count=0;
        for (Supporter_details supporter : supporters) {
            if (supporter.getSupporter_id() == id) {
                count++;
                supporters.remove(supporter);
                fileManager.write(supporters);
                System.out.println("supporter deleted");
                break;
            }

        }
        fileManager.write(supporters);
        if(count==0){
            System.out.println("no such supporter");
        }
            int i=1;
              for(Supporter_details supporter:supporters)
              {
                  supporter.setdeleteid(i);
                  i++;
              }

            }




    @Override
    public Set<Supporter_details> showallsupporters() {
        if(supporters.isEmpty()){
            return null;
        }
        else {
            return this.supporters;
        }
    }



    @Override
    public Set<Supporter_details> findbytelephone(String telephone) throws Exception {
        Set<Supporter_details> telephone_num = new HashSet<Supporter_details>();
        for (Supporter_details supporter : supporters) {
            String supporter_num = supporter.getSupporter_telephone();
            if (supporter_num == telephone) {
                telephone_num.add(supporter);
            }
        }
        if(telephone_num.isEmpty())
        {
            throw new Exception("supporters not found");
        }
        else {
            return telephone_num;
        }
    }

    @Override
    public Set<Supporter_details> findbycity(String city) throws Exception {
        Set<Supporter_details> cityfind = new HashSet<Supporter_details>();
        for (Supporter_details supporter : supporters) {
            String cityofsupporter = supporter.getSupporter_city();
            if (cityofsupporter.equals(city)) {
                cityfind.add(supporter);
            }
        }
        if(cityfind.isEmpty())
        {
           throw new Exception("supporters not found");
        }
        else {
            return cityfind;
        }

    }


    @Override
    public Set<Supporter_details> findByName(String name) throws Exception {
        Set<Supporter_details> names = new HashSet<Supporter_details>();
        for (Supporter_details supporter : supporters) {
            if (supporter.getSupporter_name().equals(name)) {
                names.add(supporter);
            }
        }
        if(names.isEmpty())
        {
            throw new Exception("supporters not found");
        }
        return names;
    }

    @Override
    public void printallsupporters() throws IOException {
        System.out.println(supporters.size());
        for (Supporter_details supporter1 : supporters) {
            System.out.println(supporter1);
        }
    }

    @Override
    public void editname(int id, String name) throws Exception {

       int count=0;
        for (Supporter_details supporter1 : supporters) {
            if (supporter1.getSupporter_id() == id) {
                if(supporter1.getSupporter_name().equals(name))
                {
                    System.out.println("There is no changes,please try another name...");
                    count++;
                    break;
                }
                else {
                    supporter1.setSupporter_name(name);
                    fileManager.write(supporters);
                    count++;
                    System.out.println("change is done");
                    System.out.println(supporter1);
                    break;
                }
            }
        }
        if(count==0){
            throw new Exception("supporter not found");
        }

    }

    @Override
    public void editcity(int id, String city1) throws Exception {
        int count=0;
        for (Supporter_details supporter1 : supporters) {
            if (supporter1.getSupporter_id() == id) {
                if(supporter1.getSupporter_city().equals(city1))
                {
                    System.out.println("There is no changes,please try another city...");
                    count++;
                    break;
                }
                else {
                    supporter1.setSupporter_city(city1);
                    fileManager.write(supporters);
                    System.out.println("change is done");
                    System.out.println(supporter1);
                    count++;
                    break;
                }
            }
        }
        if(count==0){
            throw new Exception("supporters not found");
       }

    }

    @Override
    public void edittelephone(int id, String telephone) throws Exception {
        int count=0;
        for (Supporter_details supporter1 : supporters) {
            if (supporter1.getSupporter_id() == id) {
                if(supporter1.getSupporter_telephone().equals(telephone))
                {
                    System.out.println("There is no changes,please try another telephone...");
                    count++;
                    break;
                }
                else {
                    supporter1.setSupporter_telephone(telephone);
                    fileManager.write(supporters);
                    System.out.println("change is done");
                    System.out.println(supporter1);
                    count++;
                    break;
                }
            }
        }
        if(count==0){
            throw new Exception("supporters not found");
        }
    }

}