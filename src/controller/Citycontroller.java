package controller;



import model.service.CityService;

import java.io.IOException;
import java.time.LocalDate;

public class Citycontroller {

    private CityService cityservice;
    private static Citycontroller INSTANCE;

    public Citycontroller () throws Exception {
        cityservice=new CityService();
    }
    public static  Citycontroller getInstance() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new  Citycontroller();
        }
        return INSTANCE;
    }

    public void cityreport() throws Exception {
        cityservice.cityreport();
    }
    public void allreports(){
       cityservice.allreports();
    }
    public void specific(LocalDate local) throws Exception {
        try {
            cityservice.specific(local);
        }catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
