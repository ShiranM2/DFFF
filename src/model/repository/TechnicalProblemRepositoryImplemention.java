package model.repository;

import FileManager.FileManager;
import general_classes.Problems_details;
import general_classes.status;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class TechnicalProblemRepositoryImplemention implements  TechnicalProblemRepository {
    private final String FILENAME = "TechnicalProblemRepositoryImplementionFile";
    private FileManager<Problems_details> fileManager;
    public Set<Problems_details> ProblemsDetailsSet;
    private static TechnicalProblemRepositoryImplemention INSTANCE;



    @SuppressWarnings("unchecked")
    private TechnicalProblemRepositoryImplemention() throws Exception {
        this.fileManager = new FileManager<Problems_details>(FILENAME);
        ProblemsDetailsSet=new HashSet<Problems_details>();
        this.ProblemsDetailsSet = fileManager.read();

        //AFIK add this but it doesnt work :try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("technicalProblemsss.txt"))) {  //ProblemsDetailsSet = (Set<Problems_details>) oi.readObject();
        // ////////afik said that here we need to Read from file
    }
    public static TechnicalProblemRepositoryImplemention getInstance() throws Exception {
        if (INSTANCE==null)
        {
            INSTANCE=new TechnicalProblemRepositoryImplemention();
        }
        return INSTANCE;
    }
    public void add_new_problem(Problems_details pr)
    {
      //11:40\\  if(ProblemsDetailsSet.contains(pr)==true)
       //11:40\\  {System.out.println(" This problem already exist in set"); return; }
        int tmpId=forAllOverSetAndFindProblemByName(pr.getDescription());
        if(tmpId!=-1)//it exist in set already
        {
             System.out.println(" This problem already exist in set ( technical id of the exist problem is:"+tmpId+" )"); return;
        }
        ProblemsDetailsSet.add(pr);
        System.out.println("New problem add into the set-Technical_id :" + pr.getTechnical_id());
        fileManager.write(ProblemsDetailsSet);
        //try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("technicalProblemsss.txt"))) {
          //  oos.writeObject(ProblemsDetailsSet);} catch (Exception e) {
            //e.printStackTrace(); }

    }
    public void delete_problem(Problems_details pr) {

        int tmpId=forAllOverSetAndFindProblemById(pr);
        if(tmpId==-1)//it  not exist in set already
        {
            System.out.println(" Problem number  "+pr.getTechnical_id()+" not exist in set..."); return;
        }
        ProblemsDetailsSet.remove(pr);
        pr.setProblem_status(status.Fixed);
        System.out.println("Problem number " + pr.getTechnical_id() + " fixed and remove from set");
        fileManager.write(ProblemsDetailsSet);
       // try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("technicalProblemsss.txt"))) {
         //   oos.writeObject(ProblemsDetailsSet); } catch (Exception e) {
          //  e.printStackTrace(); }
    }
    public void printListOfProblems()
    {
        if(ProblemsDetailsSet.isEmpty()==true)
        {
            System.out.println ("The set is empty");
            return;
        }
        for (Problems_details p : ProblemsDetailsSet)
        {
            System.out.print("  technical_id number :" + p.getTechnical_id());
            System.out.print(" , description : " + p.getDescription());
            System.out.println (",  status : " + p.getProblem_status());
        }
    }
    public int forAllOverSetAndFindTheLastActionId()
    {
        int tmpId = 0;
        for (Problems_details var : ProblemsDetailsSet)
        {
            if (var.getTechnical_id() >= tmpId)
            {
                tmpId = var.getTechnical_id();
            }
        }
        return tmpId;
    }
    public int forAllOverSetAndFindProblemByName(String name)
    {
        for ( Problems_details var:ProblemsDetailsSet)
        {
            if (var.getDescription().equals(name))
                return var.getTechnical_id();
        }
        return -1;
    }
    public int forAllOverSetAndFindProblemById(Problems_details pr1)
    {
        for ( Problems_details var:ProblemsDetailsSet)
        {
            if (var.getTechnical_id()==pr1.getTechnical_id())
                return var.getTechnical_id();
        }
        return -1;
    }
    public void delete_problem_by_Technical_id( int idd)
    {
        for ( Problems_details var:ProblemsDetailsSet)
        {
            if (var.getTechnical_id()==idd)
            {
                delete_problem(var);
                return;

            }
        }
        System.out.println("technical_id number:" + idd+" Not exist in set!! ");



    }
    /*

    /*

    public void delete_problem(Problems_details pr) {
        //11:45\\if(ProblemsDetailsSet.contains(pr)==false)
        //11:45\\{System.out.println(" This problem  is not exist in set"); return; }
        int tmpId=forAllOverSetAndFindProblemByName(pr.getDescription());
        if(tmpId==-1)//it  not exist in set already
        {
            System.out.println(" This problem not exist in set..."); return;
        }
        ProblemsDetailsSet.remove(pr);
        pr.setProblem_status(status.Fixed);
        System.out.println("Problem number " + pr.getTechnical_id() + " fixed and remove from set");
        fileManager.write(ProblemsDetailsSet);
        // try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("technicalProblemsss.txt"))) {
        //   oos.writeObject(ProblemsDetailsSet); } catch (Exception e) {
        //  e.printStackTrace(); }
    }

 public void delete_problem_by_Technical_id( int idd)
    {
        //11:45\\if(ProblemsDetailsSet.contains(pr)==false)
        //11:45\\{System.out.println(" This problem  is not exist in set"); return; }
        for ( Problems_details var:ProblemsDetailsSet)
        {
            if (var.getTechnical_id()==idd)
            {
                var.setProblem_status(status.Fixed);
                System.out.println("Problem number " + var.getTechnical_id() + " fixed and remove from set");
                ProblemsDetailsSet.remove(var);
                fileManager.write(ProblemsDetailsSet);
                return;

            }
        }
        System.out.println("technical_id number:" + idd+" Not exist in set!! ");



    }
    /*
    public void tryToReadFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("technicalProblemsss.txt"))) {

            Set<Problems_details> fileObjects = (Set<Problems_details>) oi.readObject();
            fileObjects.forEach(System.out::print);
        }
    }
    /*
     */
}