package controller;


import general_classes.Problems_details;
import model.service.TechnicalProblemService;

public class TechnicalProblemController {


    private TechnicalProblemService technicalProblemService;

    public TechnicalProblemController()//constractor
    {
        technicalProblemService=new TechnicalProblemService();
    }

    public  void AddNewTechnicalProblems(String description){
        Problems_details newProblem= new Problems_details( description);
        technicalProblemService.AddNewTechnicalProblems(newProblem);

    }

    public void DeleteTechnicalProblemsByKnownId(int idd){
        technicalProblemService.DeleteTechnicalProblemsByKnownId(  idd);
    }

    public void DeleteTechnicalProblemsBySearchingDescription(String description){
        technicalProblemService.DeleteTechnicalProblemsBySearchingDescription(description);
    }

    public void ViewExistTechnicalProblems(){
        technicalProblemService.ViewExistTechnicalProblems();
    }
}

