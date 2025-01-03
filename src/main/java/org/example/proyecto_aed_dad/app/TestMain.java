package org.example.proyecto_aed_dad.app;

import org.example.proyecto_aed_dad.dao.impl.*;
import org.example.proyecto_aed_dad.dao.interfaces.*;
import org.example.proyecto_aed_dad.dataInputManager.processCsv;
import org.example.proyecto_aed_dad.entity.*;
import org.example.proyecto_aed_dad.utils.UtilsHibernate;
import org.hibernate.SessionFactory;

import java.io.File;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = UtilsHibernate.getSessionFactory();
        CircuitDao circuitDao = new CircuitDaoImpl(sessionFactory);
        DriverDao driverDao = new DriverDaoImpl(sessionFactory);
        ResultDao resultDao = new ResultDaoImpl(sessionFactory);
        RaceDao raceDao = new RaceDaoImpl(sessionFactory);
        LapTimeDao lapTimeDao = new LapTimeDaoImpl(sessionFactory);

        List<Race> races = raceDao.findAll();
        List<Driver> drivers = driverDao.findAll();
        List<LapTime> lapTimes = lapTimeDao.findAll();
        int i = 0;
        for (LapTime lapTime : lapTimes) {
            System.out.println(i++ + ". "+lapTime.getId().getDriver().getSurname()+", "+lapTime.getId().getDriver().getForename()+" | "+lapTime.getId().getRace().getName()+" | "+lapTime.getPosition()+" | "+lapTime.getTime()+" | "+lapTime.getMilliseconds() + " | "+lapTime.getId().getLap());
        }


        //        int i = 0;
//        System.out.println("-----CIRCUITS-----");
//        for (Circuit circuit : circuits) {
//            System.out.println(i++ + ". " + circuit.getCircuitRef());
//
//        }
//        i = 0;
//        System.out.println("-----DRIVERS-----");
//        for (Driver driver : drivers) {
//            System.out.println(i++ + ". " + driver.getSurname()+", "+driver.getForename());
//        }
//
//        System.out.println("-----DRIVER BY NAME-----");
//        Driver driver = driverDao.getByName("Fernando");
//        System.out.println(driver.getSurname()+", "+driver.getForename());
    }
}
