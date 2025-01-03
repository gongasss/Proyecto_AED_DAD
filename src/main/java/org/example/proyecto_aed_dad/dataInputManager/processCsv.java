package org.example.proyecto_aed_dad.dataInputManager;

import org.example.proyecto_aed_dad.dao.impl.CircuitDaoImpl;
import org.example.proyecto_aed_dad.dao.impl.ConstructorDaoImpl;
import org.example.proyecto_aed_dad.dao.impl.DriverDaoImpl;
import org.example.proyecto_aed_dad.dao.impl.RaceDaoImpl;
import org.example.proyecto_aed_dad.dao.interfaces.CircuitDao;
import org.example.proyecto_aed_dad.dao.interfaces.ConstructorDao;
import org.example.proyecto_aed_dad.dao.interfaces.DriverDao;
import org.example.proyecto_aed_dad.dao.interfaces.RaceDao;
import org.example.proyecto_aed_dad.entity.*;
import org.hibernate.SessionFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class processCsv {
    File file;
    SessionFactory sessionFactory;
    public processCsv(File file, SessionFactory sessionFactory){
        this.file = file;
        this.sessionFactory = sessionFactory;
    }
    public List<Result> processResults(){
        List<Result> results = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                List<String> split = java.util.Arrays.asList(line.split(","));
                Result result = new Result();
                // resultId,raceId,driverId,constructorId,number,grid,position,positionText,positionOrder,points,laps,time,milliseconds,fastestLap,rank,fastestLapTime,fastestLapSpeed,statusId
                int resultId = Integer.parseInt(split.get(0));
                result.setResultId(resultId);
                Race race = getOrCreateRace(Integer.parseInt(split.get(1)));
                result.setRace(race);
                Driver driver = getOrCreateDriver(Integer.parseInt(split.get(2)));
                result.setDriver(driver);
                Constructor constructor = getOrCreateConstructor(Integer.parseInt(split.get(3)));
                result.setConstructor(constructor);
                if(processItem(split.get(4)) != ""){
                    result.setNumber(Integer.parseInt(processItem(split.get(4))));
                }
                if(processItem(split.get(5)) != ""){
                    result.setGrid(Integer.parseInt(processItem(split.get(5))));
                }
                if(processItem(split.get(6)) != ""){
                    result.setPosition(Integer.parseInt(processItem(split.get(6))));
                }
                if(processItem(split.get(7)) != ""){
                    result.setPositionText(processItem(split.get(7)));
                }
                if(processItem(split.get(8)) != ""){
                    result.setPositionOrder(Integer.parseInt(processItem(split.get(8))));
                }
                if(processItem(split.get(9)) != ""){
                    result.setPoints(BigDecimal.valueOf(Double.parseDouble(processItem(split.get(9)))));
                }
                if(processItem(split.get(10)) != ""){
                    result.setLaps(Integer.parseInt(processItem(split.get(10))));
                }
                if(processItem(split.get(11)) != ""){
                    result.setTime(processItem(split.get(11)));
                }
                if(processItem(split.get(12)) != ""){
                    result.setMilliseconds(Long.parseLong(processItem(split.get(12))));
                }
                if(processItem(split.get(13)) != ""){
                    result.setFastestLap(Integer.parseInt(processItem(split.get(13))));
                }
                if(processItem(split.get(14)) != ""){
                    result.setRank(Integer.parseInt(processItem(split.get(14))));
                }
                if(processItem(split.get(15)) != ""){
                    result.setFastestLapTime(processItem(split.get(15)));
                }

                if(processItem(split.get(16)) != ""){
                    result.setFastestLapSpeed(BigDecimal.valueOf(Double.parseDouble(processItem(split.get(16)))));
                }

                if(processItem(split.get(17)) != ""){
                    result.setStatusId(Integer.parseInt(processItem(split.get(17))));
                }
                results.add(result);
            }
            br.close();
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Race> processRaces(){
        List<Race> races = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                List<String> split = java.util.Arrays.asList(line.split(","));
                Race race = new Race();
                // raceId,year,round,circuitId,name,date,time,url,fp1_date,fp1_time,fp2_date,fp2_time,fp3_date,fp3_time,quali_date,quali_time,sprint_date,sprint_time
                int raceId = Integer.parseInt(split.get(0));
                race.setId(raceId);
                if(processItem(split.get(1)) != ""){
                    race.setYear(Integer.parseInt(processItem(split.get(1))));
                }
                if(processItem(split.get(2)) != ""){
                    race.setRound(Integer.parseInt(processItem(split.get(2))));
                }
                Circuit circuit = getOrCreateCircuit(Integer.parseInt(split.get(3)));
                race.setCircuit(circuit);
                if(processItem(split.get(4)) != ""){
                    race.setName(processItem(split.get(4)));
                }
                if(processItem(split.get(5)) != ""){
                    race.setDate(LocalDate.parse(processItem(split.get(5))));
                }
                if(processItem(split.get(6)) != ""){
                    race.setTime(LocalTime.parse(processItem(split.get(6))));
                }
                if(processItem(split.get(7)) != ""){
                    race.setUrl(processItem(split.get(7)));
                }
                if(processItem(split.get(8)) != ""){
                    race.setFp1Date(LocalDate.parse(processItem(split.get(8))));
                }
                if(processItem(split.get(9)) != ""){
                    race.setFp1Time(LocalTime.parse(processItem(split.get(9))));
                }
                if(processItem(split.get(10)) != ""){
                    race.setFp2Date(LocalDate.parse(processItem(split.get(10))));
                }
                if(processItem(split.get(11)) != ""){
                    race.setFp2Time(LocalTime.parse(processItem(split.get(11))));
                }
                if(processItem(split.get(12)) != ""){
                    race.setFp3Date(LocalDate.parse(processItem(split.get(12))));
                }
                if(processItem(split.get(13)) != ""){
                    race.setFp3Time(LocalTime.parse(processItem(split.get(13))));
                }
                if(processItem(split.get(14)) != ""){
                    race.setQualiDate(LocalDate.parse(processItem(split.get(14))));
                }
                if(processItem(split.get(15)) != ""){
                    race.setQualiTime(LocalTime.parse(processItem(split.get(15))));
                }
                if(processItem(split.get(16)) != ""){
                    race.setSprintDate(LocalDate.parse(processItem(split.get(16))));
                }
                if(processItem(split.get(17)) != ""){
                    race.setSprintTime(LocalTime.parse(processItem(split.get(17))));
                }
                races.add(race);
            }
            br.close();
            return races;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Circuit getOrCreateCircuit(int id) {
        CircuitDao circuitDao = new CircuitDaoImpl(sessionFactory);
        Circuit circuit = circuitDao.getById(id);
        if(circuit == null){
            circuit = new Circuit();
            circuit.setId(id);
            circuitDao.insert(circuit);
        }
        return circuit;
    }

    public String  processItem(String item){
        if(item.charAt(0) == '"'){
            item = item.substring(1, item.length()-1);
        }
        if(item.equals("\\N")){
            return "";
        }
        return item;
    }
    public Driver getOrCreateDriver(int id){
        DriverDao driverDao = new DriverDaoImpl(sessionFactory);
        Driver driver = driverDao.getById(id);
        if(driver == null){
            driver = new Driver();
            driver.setId(id);
            driverDao.insert(driver);
        }
        return driver;
    }
    public Race getOrCreateRace(int id){
        RaceDao raceDao = new RaceDaoImpl(sessionFactory);
        Race race = raceDao.getById(id);
        if(race == null){
            race = new Race();
            race.setId(id);
            raceDao.insert(race);
        }
        return race;
    }
    public Constructor getOrCreateConstructor(int id){
        ConstructorDao constructorDao = new ConstructorDaoImpl(sessionFactory);
        Constructor constructor = constructorDao.getById(id);
        if(constructor == null){
            constructor = new Constructor();
            constructor.setId(id);
            constructorDao.insert(constructor);
        }
        return constructor;
    }
}
