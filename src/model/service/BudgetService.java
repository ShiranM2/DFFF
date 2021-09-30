package model.service;

import general_classes.ExpensesAndIncomes;
import model.repository.BudgetRepository;
import model.repository.BudgetRepositoryImplementaition;

public class BudgetService
{
    public BudgetRepository budgetRepo;
    public BudgetService() {
        try
        {
            budgetRepo =  BudgetRepositoryImplementaition.getInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addIncome(ExpensesAndIncomes income1) {
        budgetRepo.Add_New_Income(income1);
    }
    public void addExpense(ExpensesAndIncomes expesne1)
    {
        budgetRepo.Add_New_Expense(expesne1);
    }
    public void deleteIncome(ExpensesAndIncomes income1){budgetRepo.delete_Income_From_Set(income1);}
    public void deleteExpense(ExpensesAndIncomes expense1){budgetRepo.delete_Expense_From_Set(expense1);}
    public void deleteIncomeBy2Parameters(double sum,String description){
        int IdFound=budgetRepo.findActionBy2Parameters(sum,description);
        budgetRepo.delete_Income_by_actionID(IdFound);
    }
    public void deleteExpenseBy2Parameters(double sum,String description){
        int IdFound=budgetRepo.findActionBy2Parameters(sum,description);
        budgetRepo.delete_Expense_by_actionID(IdFound);
    }
    public void  getTotalBudget()
    {
        System.out.println("Total Budget now is:  "+ budgetRepo.getTotal_update_budget());
    }
    public void ReadTheSet(){
        budgetRepo.printAllTheSet();
    }
}