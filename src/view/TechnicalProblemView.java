package view;



import controller.TechnicalProblemController;
import general_classes.Session;
import java.io.IOException;

import java.util.Scanner;

public class TechnicalProblemView {
    private TechnicalProblemController technicalProblemController;

    public TechnicalProblemView()
    {
        technicalProblemController= new TechnicalProblemController();
    }

    public void TechnicalProblemsCliImpl()
    {
        System.out.println("Welcome Technical Problems menu....options:");
        System.out.println("1. Add new technical problems");
        System.out.println("2. Delete technical problems by known id");
        System.out.println("3. Delete technical problems by searching description of problem");
        System.out.println("4. View all exist technical problems ");
        System.out.println("5.Return to general menu");
        try(Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch(command)
            { case "1":
                this.AddNewTechnicalProblem();
                case "2":
                    if(Session.getInstance().isTechnicalsupport())
                        this.DeleteTechnicalProblemsByKnownId();
                    else {
                        System.out.println("Only Technical support can do that");
                        TechnicalProblemsCliImpl();
                    }
                case "3":
                    if(Session.getInstance().isTechnicalsupport())
                        this.DeleteTechnicalProblemsBySearchingDescription();
                    else {
                        System.out.println("Only Technical support can do that");
                        TechnicalProblemsCliImpl();
                    }
                case "4":
                    if(Session.getInstance().isTechnicalsupport())
                        this.ViewExistTechnicalProblems();
                    else {
                        System.out.println("Only Technical support can do that");
                        TechnicalProblemsCliImpl();
                    }
                case "5":
                    ProgramView view12=new ProgramView();
                    view12.WelcomeProgram();
                case "q":
                case "Q":
                default:
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();

            }
        }
        catch (Exception e) {
            System.exit(1);
        }
    }
    //case1 function
    public void AddNewTechnicalProblem(){

        try (Scanner scanner = new Scanner(System.in))
        {
            System.out.println("Please write the description of the problem (string):");
            String description = scanner.nextLine();
            technicalProblemController.AddNewTechnicalProblems(description);
            System.out.println("Want to return to Technical problems menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                TechnicalProblemsCliImpl();
            }
            else if (what.equals("no"))
            {
                AddNewTechnicalProblem();
            }
            else {
                TechnicalProblemsCliImpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case2 function
    private void DeleteTechnicalProblemsByKnownId(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please write the id of the problem (int): ");
           int idd =   Integer.parseInt(scanner.nextLine());
            technicalProblemController.DeleteTechnicalProblemsByKnownId(idd);
            System.out.println("Want to return to Technical problems menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                TechnicalProblemsCliImpl();
            }
            else if (what.equals("no"))
            {
                DeleteTechnicalProblemsByKnownId();
            }
            else {
                TechnicalProblemsCliImpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case3 function
    private void DeleteTechnicalProblemsBySearchingDescription(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please write the descriptin of the problem (String): ");
            String description = scanner.nextLine();
            technicalProblemController.DeleteTechnicalProblemsBySearchingDescription(description);
            System.out.println("Want to return to Technical problems menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                TechnicalProblemsCliImpl();
            }
            else if (what.equals("no"))
            {
                ViewExistTechnicalProblems();
            }
            else {
                TechnicalProblemsCliImpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case4 function
    private void ViewExistTechnicalProblems(){
        try (Scanner scanner = new Scanner(System.in)) {
            technicalProblemController.ViewExistTechnicalProblems();
            System.out.println("Want to return to Technical problems menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                TechnicalProblemsCliImpl();
            }
            else if (what.equals("no"))
            {
               ViewExistTechnicalProblems();
            }
            else {
                TechnicalProblemsCliImpl();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}



