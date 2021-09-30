
package model.repository;


import general_classes.ExpensesAndIncomes;
import general_classes.TotalUpdateBudget;

import java.util.ArrayList;
import java.util.Set;

public interface BudgetRepository {
    public void Add_New_Income(ExpensesAndIncomes in)   ;
    public void Add_New_Expense(ExpensesAndIncomes ex) ;
    public void delete_Income_From_Set(ExpensesAndIncomes i);
    public void delete_Expense_From_Set(ExpensesAndIncomes e)  ;
    public void print_total_budget();
    public double getTotal_update_budget() ;
    public void setTotal_update_budget(double total_update_budget);
    public int findActionBy2Parameters(double sum,String description);
    public void printAllTheSet();
    public ArrayList<TotalUpdateBudget> showList();
    public double ForAlloverSetAndCalculateSum();
    public void delete_Income_by_actionID(int actionId);
    public void delete_Expense_by_actionID(int actionId);
    public int forAllOverSetAndFindTheLastActionId();
}
