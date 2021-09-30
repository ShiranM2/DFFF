package model.service;


import general_classes.Problems_details;
import model.repository.TechnicalProblemRepository;
import model.repository.TechnicalProblemRepositoryImplemention;

public class TechnicalProblemService {


    public TechnicalProblemRepository technicalProblemRepo ;

    public TechnicalProblemService() {
        try {
            technicalProblemRepo =  TechnicalProblemRepositoryImplemention.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public   void AddNewTechnicalProblems(Problems_details newProblem){
        technicalProblemRepo.add_new_problem(newProblem);
    }
    public   void DeleteTechnicalProblemsByKnownId(int id){
        technicalProblemRepo.delete_problem_by_Technical_id(id);
    }

    public void DeleteTechnicalProblemsBySearchingDescription(String description){
       int id= technicalProblemRepo.forAllOverSetAndFindProblemByName(description);
       technicalProblemRepo.delete_problem_by_Technical_id(id);
    }

    public void ViewExistTechnicalProblems(){
        technicalProblemRepo.printListOfProblems();
    }
}
