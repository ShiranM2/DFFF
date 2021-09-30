package model.repository;


import general_classes.Problems_details;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface TechnicalProblemRepository {

    public void add_new_problem(Problems_details pr)  ;

    public void delete_problem(Problems_details pr) ;

    public void printListOfProblems();
    public int forAllOverSetAndFindTheLastActionId();
    public int forAllOverSetAndFindProblemById(Problems_details pr1);
     public void delete_problem_by_Technical_id(int idd );
    public int forAllOverSetAndFindProblemByName(String name);

    //public void tryToReadFile() throws FileNotFoundException, IOException, ClassNotFoundException;
}
