package tests;

import general_classes.BudgetReport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetReportTest {
    private static BudgetReport report1;

    @BeforeEach
    void setUp() {
         report1=new BudgetReport();
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test Started");
    }


    @Test
    public void totaldifference_test() {
        assertEquals(5000,report1.caculatedifference(10000,5000),0);
       assertEquals(0,report1.caculatedifference(50000,50000),0);
        assertEquals(-2000,report1.caculatedifference(4000,6000),0);
        assertEquals(-10000,report1.caculatedifference(-4000,6000),0);
        assertEquals(10000,report1.caculatedifference(4000,-6000),0);
        assertEquals(2000,report1.caculatedifference(-4000,-6000),0);
    }
}