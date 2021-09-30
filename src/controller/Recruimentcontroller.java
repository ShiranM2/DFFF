package controller;

import model.service.Recruimentservice;

import java.time.LocalDate;

public class Recruimentcontroller {

    private Recruimentservice recruimentservice;

    public Recruimentcontroller() throws Exception {
        recruimentservice=new Recruimentservice();
    }

    public void recruimentreport() throws Exception {
        recruimentservice.recruimentreport();
    }
    public void allreports(){
        recruimentservice.allreports();
    }
    public void specific(LocalDate local) throws Exception {
        recruimentservice.specific(local);
    }
}
