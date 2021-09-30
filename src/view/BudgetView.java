package view;



import controller.BudgetController;

import java.util.Scanner;

public class BudgetView  {
    private BudgetController budgetController;

    public BudgetView()
    {budgetController=new BudgetController();}


    public void budgetCliImpl(){
        System.out.println("Welcome Budget Managing....options:");
        System.out.println("1. Add new Incomes");
        System.out.println("2. Add new Expenses");
        System.out.println("3. Remove Income");
        System.out.println("4. Remove Expenses ");
        System.out.println("5. View total budget sum");
        System.out.println("6. Show list of Expenses and Incomes");
        System.out.println("7.Return to general menu");
        try(Scanner scanner = new Scanner(System.in)) {
            String command = scanner.nextLine();
            switch(command)
            {case "1":
                this.AddNewIncomes();
                break;
                case "2":
                    this.AddNewExpense();
                    break;
                case "3":
                    this.RemoveIncome();
                case "4":
                    this.RemoveExpense();
                case "5":
                    this.ViewTotalBudget();
                    break;
                case "6":
                    this.ReadTheSet();
                case "7":
                    ProgramView view1=new ProgramView();
                    view1.WelcomeProgram();
                case "q":
                case "Q":
                default:
                    budgetCliImpl();
            }
        }
        catch (Exception e) {
            System.exit(1);
        }
    }


    //case1 function
    public void AddNewIncomes(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please insert the sum of income( double):");
            double sum = Double.parseDouble(scanner.nextLine());
            System.out.println("Please write the description of action(string): ");
            String description = scanner.nextLine();
            budgetController.AddIncomeIntoBudget(sum,description);
            System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                budgetCliImpl();
            }
            else if (what.equals("no"))
            {
                AddNewIncomes();
            }
            else {
                budgetCliImpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //case2 function
    public void AddNewExpense()
    {
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Please insert the sum of expense( double): ");
          double sum = Double.parseDouble(scanner.nextLine());
        System.out.println("Please write the description of action(string): ");
        String description = scanner.nextLine();
        budgetController.AddExpenseIntoBudget(sum, description);
        System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
        String what = scanner.nextLine();
        if(what.equals("yes")) {
            budgetCliImpl();
        }
        else
        {
            AddNewExpense();
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case3 function
    public void RemoveIncome(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please insert the sum of income you want to remove( double): ");
            double sum = Double.parseDouble(scanner.nextLine());
            System.out.println("Please write the description of action(string): ");
            String description = scanner.next();
            budgetController.deleteIncomeFromBudgetBy2Parameters(sum,description);
            System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                budgetCliImpl();
            }
            else
            {
                RemoveIncome();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case4 function
    public void RemoveExpense(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Please insert the sum of expense you want to remove( double): ");
            double sum = Double.parseDouble(scanner.nextLine());
            System.out.println("Please write the description of action(string): ");
            String description = scanner.next();
            budgetController.deleteExpenseFromBudgetBy2Parameters(sum,description);
            System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                budgetCliImpl();
            }
            else
            {
                RemoveExpense();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case5 function
    public void ViewTotalBudget(){
        budgetController.ViewTotalBudget();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                budgetCliImpl();
            }
            else if (what.equals("no"))
            {
                ViewTotalBudget();
            }
            else {
                budgetCliImpl();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //case6 function
    private void ReadTheSet()
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            budgetController.ViewTotalBudget();
            budgetController.ReadTheSet();
            System.out.println("Want to return to Budget menu ? yes/no" + " yes- return no-repeat this action");
            String what = scanner.nextLine();
            if(what.equals("yes")) {
                budgetCliImpl();
            }
            else if (what.equals("no"))
            {
                ReadTheSet();
            }
            else {
                budgetCliImpl();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();    }
    }

}