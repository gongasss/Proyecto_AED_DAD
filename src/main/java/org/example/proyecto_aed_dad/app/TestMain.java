package org.example.proyecto_aed_dad.app;

import org.example.proyecto_aed_dad.dao.Mediator;
import org.example.proyecto_aed_dad.dao.impl.*;
import org.example.proyecto_aed_dad.dao.interfaces.*;
import org.example.proyecto_aed_dad.dataInputManager.processCsv;
import org.example.proyecto_aed_dad.entity.*;
import org.example.proyecto_aed_dad.utils.UtilsHibernate;
import org.hibernate.SessionFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = UtilsHibernate.getSessionFactory();

        Mediator mediator = new Mediator(sessionFactory);

//        List<Object[]> drivers = mediator.driversWithMostTop10ItalyCircuits();
//        for (Object[] result : drivers) {
//            Driver driver = (Driver) result[0];
//            long count = (long) result[1];
//            System.out.println(driver.getForename()+", "+driver.getSurname()+" | "+count);
//        }
//
//        List<Object[]> tracks = mediator.tracksWithMostRaces();
//        for (Object[] result : tracks) {
//            Circuit circuit = (Circuit) result[0];
//            long count = (long) result[1];
//
//            System.out.println(circuit.getCircuitRef()+" | "+count);
//            List<Object[]> constructors = mediator.constructorsWithMostWinsByCircuit(circuit);
//            System.out.println("-----CONSTRUCTORES CON MÁS VICTORIAS -----");
//            for (Object[] result2 : constructors) {
//                Constructor constructor = (Constructor) result2[0];
//                long count2 = (long) result2[1];
//                System.out.println(constructor.getConstructorRef()+" | "+count2);
//            }
//            System.out.println("-----FIN CONSTRUCTORES CON MÁS VICTORIAS -----");
//        }
//
//        List<Object[]> constructors = mediator.constructorsWithMostWinsByCountry("Italy");
//        for (Object[] result : constructors) {
//            Constructor constructor = (Constructor) result[0];
//            long count = (long) result[1];
//            System.out.println(constructor.getConstructorRef()+" | "+count);
//        }
//
//        List<Object[]> driversWithMostRaces = mediator.driversWithMostRaces();
//        System.out.println("-----DRIVERS CON MÁS CARRERAS -----");
//        for (Object[] result : driversWithMostRaces) {
//            Driver driver = (Driver) result[0];
//            long count = (long) result[1];
//            System.out.println(driver.getForename()+", "+driver.getSurname()+" | "+count);
//        }

        List<Circuit> circuits = mediator.getCircuitDao().findAll();


        for (Circuit circuit : circuits) {
            List<Object[]> driversWithMostRacesByCircuit = mediator.driversWithMostRacesByCircuit(circuit);
            System.out.println("-----DRIVERS CON MÁS CARRERAS EN "+circuit.getCircuitRef()+" -----");
            for (Object[] result : driversWithMostRacesByCircuit) {
                Driver driver = (Driver) result[0];
                long count = (long) result[1];
                System.out.println(driver.getForename()+", "+driver.getSurname()+" | "+count);
            }
        }

        List<Object[]> driversWithMostWins = mediator.driversWithMostWins();
        System.out.println("-----DRIVERS CON MÁS VICTORIAS -----");
        for (Object[] result : driversWithMostWins) {
            Driver driver = (Driver) result[0];
            long count = (long) result[1];
            System.out.println(driver.getForename()+", "+driver.getSurname()+" | "+count);
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
