package model.repository;

import java.time.LocalDate;
import java.time.Month;

public interface ReportRepository {
    public void add(Object obj) throws Exception;

    public void show();

    public void showspecificreport(LocalDate date) throws Exception;

}