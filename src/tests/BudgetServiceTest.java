package tests;


import general_classes.ExpensesAndIncomes;
import model.service.BudgetService;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetServiceTest {
    private BudgetService budgetService;
    public ExpensesAndIncomes inc1;
    public ExpensesAndIncomes exp1;
    @BeforeAll
    static void setUpWelcome()
    {
        System.out.println("Beginning Test");
    }
    @BeforeEach
    public void setUp() throws Exception {
        budgetService=new BudgetService();
        inc1=new ExpensesAndIncomes (1001,1,"income1");
        exp1=new ExpensesAndIncomes (1002,2,"expense1");
    }
    @Test
    void testAddingIncome()
    {
        double forComparation =budgetService.budgetRepo.getTotal_update_budget();
        budgetService.addIncome(inc1);
        forComparation += inc1.getSum();
        assertEquals(forComparation , budgetService.budgetRepo.getTotal_update_budget(),0);
    }
    @Test
    public void testAddingExpense( ) throws Exception {
        double forComparation=budgetService.budgetRepo.getTotal_update_budget();
        budgetService.addExpense(exp1);
        forComparation -=exp1.getSum();
        assertEquals(forComparation ,budgetService.budgetRepo.getTotal_update_budget(),0);
    }
    @Test
    public void testDeleteIncome( ) throws Exception {
        double forComparation=budgetService.budgetRepo.getTotal_update_budget();
        budgetService.deleteIncome(inc1);
        forComparation -=inc1.getSum();
        assertEquals(forComparation ,budgetService.budgetRepo.getTotal_update_budget(),0);
    }
    @Test
    public void testDeleteExpense( ) throws Exception{
        double forComparation = budgetService.budgetRepo.getTotal_update_budget();
        budgetService.deleteExpense(exp1);
        forComparation += exp1.getSum();
        assertEquals(forComparation, budgetService.budgetRepo.getTotal_update_budget(), 0);
    }
    @AfterAll
    static void tearDown()
    {
        System.out.println("All tests end successfully");
    }
}