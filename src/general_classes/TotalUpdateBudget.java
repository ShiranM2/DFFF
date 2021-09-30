package general_classes;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


import java.time.LocalDate;
public class TotalUpdateBudget implements Serializable{
    public double sum;
    public LocalDate date;
    //CONSTRACTOR WITH VALUES
    public TotalUpdateBudget(double sum ,LocalDate date )
    {
        this.date =LocalDate.now();
        this.sum=sum;
    }
    public double getSum(){
        return sum;
    }
    public void setSum(double sum){
        this.sum = sum;
    }
    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date = date;
    }

    @Override
    public String toString() {
    return "TotalUpdateBudget{" +
            "sum=" + sum +
            ", date=" + date +
            '}';
}

}
