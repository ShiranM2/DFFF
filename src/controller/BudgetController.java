package controller;
import general_classes.*;

import general_classes.*;
import model.service.BudgetService;

public class BudgetController {
    private BudgetService budgetService;
    public BudgetController()//constractor
    {
        budgetService=new BudgetService();
    }

    public void AddIncomeIntoBudget(double sum,String description) throws Exception{
        general_classes.ExpensesAndIncomes newIncome = new general_classes.ExpensesAndIncomes(sum, 1, description);
        budgetService.addIncome(newIncome);
    }

    public void AddExpenseIntoBudget(double sum,String description)
    {
       ExpensesAndIncomes newExpense= new ExpensesAndIncomes(sum,2,description);
        budgetService.addExpense(newExpense);
    }
    public void deleteIncomeFromBudgetBy2Parameters(double sum,String description){
         budgetService.deleteIncomeBy2Parameters(sum, description);
    }
    public void deleteExpenseFromBudgetBy2Parameters(double sum,String description){
      budgetService.deleteExpenseBy2Parameters(sum, description);
    }
    public void ViewTotalBudget()
    {
        budgetService.getTotalBudget();
    }
    public void ReadTheSet(){
        budgetService.ReadTheSet();
    }
}