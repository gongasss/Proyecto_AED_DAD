package org.example.proyecto_aed_dad.dao;

import org.example.proyecto_aed_dad.dao.impl.*;
import org.example.proyecto_aed_dad.dao.interfaces.*;
import org.example.proyecto_aed_dad.entity.Circuit;
import org.example.proyecto_aed_dad.entity.Driver;
import org.example.proyecto_aed_dad.entity.Race;
import org.example.proyecto_aed_dad.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Mediator {

    CircuitDao circuitDao;
    ConstructorDao constructorDao;
    ConstructorsResultDao constructorsResultDao;
    ConstructorsStandingDao constructorStandingDao;
    DriverDao driverDao;
    ResultDao resultDao;
    RaceDao raceDao;
    LapTimeDao lapTimeDao;
    DriverStandingDao driverStandingDao;
    SprintResultDao sprintResultDao;
    QualifyingDao qualifyingDao;
    PitStopDao pitStopDao;
    SeasonDao seasonDao;
    StatusDao statusDao;

    public Mediator(SessionFactory sessionFactory) {
        circuitDao = new CircuitDaoImpl(sessionFactory);
        constructorDao = new ConstructorDaoImpl(sessionFactory);
        constructorsResultDao = new ConstructorsResultDaoImpl(sessionFactory);
        constructorStandingDao = new ConstructorStandingDaoImpl(sessionFactory);
        driverDao = new DriverDaoImpl(sessionFactory);
        resultDao = new ResultDaoImpl(sessionFactory);
        raceDao = new RaceDaoImpl(sessionFactory);
        lapTimeDao = new LapTimeDaoImpl(sessionFactory);
        driverStandingDao = new DriverStandingDaoImpl(sessionFactory);
        sprintResultDao = new SprintResultDaoImpl(sessionFactory);
        qualifyingDao = new QualifyingDaoImpl(sessionFactory);
        pitStopDao = new PitStopDaoImpl(sessionFactory);
        seasonDao = new SeasonDaoImpl(sessionFactory);
        statusDao = new StatusDaoImpl(sessionFactory);
    }

    public List<Result> getResultsByCountry(String country){
        return resultDao.getResultsByCountry(country);
    }
    public List<Object[]> driversWithMostTop10ItalyCircuits() {
        // 10 pilotos con mayor cantidad de top10 en circuitos de Italia
        return driverDao.findTopDriversWithCountInCountry("Italy");
    }
    public List<Object[]> tracksWithMostRaces() {
        // 10 pistas con mayor cantidad de carreras
        return circuitDao.findTracksWithMostRaces();
    }
    public List<Object[]> constructorsWithMostWinsByCountry(String country) {
        // 10 constructores con mayor cantidad de victorias por país
        return constructorDao.findConstructorsWithMostWinsByCountry(country);
    }
    public List<Object[]> constructorsWithMostWinsByCircuit(Circuit circuit) {
        // 10 constructores con mayor cantidad de victorias en la carrera dada
        return constructorDao.findConstructorsWithMostWinsByCircuit(circuit);
    }
    public List<Object[]> driversWithMostRaces() {
        // 10 pilotos con mayor cantidad de carreras
        return driverDao.findDriversWithMostRaces();
    }
    public List<Object[]> driversWithMostRacesByCircuit(Circuit circuit) {
        // 10 pilotos con mayor cantidad de carreras
        return driverDao.findDriversWithMostRacesByCircuit(circuit);
    }
    public List<Object[]> driversWithMostWins() {
        // 10 pilotos con mayor cantidad de victorias
        return driverDao.findDriversWithMostWins();
    }

    public CircuitDao getCircuitDao() {
        return circuitDao;
    }
    public ConstructorDao getConstructorDao() {
        return constructorDao;
    }
    public ConstructorsResultDao getConstructorsResultDao() {
        return constructorsResultDao;
    }
    public ConstructorsStandingDao getConstructorStandingDao() {
        return constructorStandingDao;
    }
    public DriverDao getDriverDao() {
        return driverDao;
    }
    public ResultDao getResultDao() {
        return resultDao;
    }
    public RaceDao getRaceDao() {
        return raceDao;
    }
    public LapTimeDao getLapTimeDao() {
        return lapTimeDao;
    }
    public DriverStandingDao getDriverStandingDao() {
        return driverStandingDao;
    }
    public SprintResultDao getSprintResultDao() {
        return sprintResultDao;
    }
    public QualifyingDao getQualifyingDao() {
        return qualifyingDao;
    }
    public PitStopDao getPitStopDao() {
        return pitStopDao;
    }
    public SeasonDao getSeasonDao() {
        return seasonDao;
    }
    public StatusDao getStatusDao() {
        return statusDao;
    }

}
