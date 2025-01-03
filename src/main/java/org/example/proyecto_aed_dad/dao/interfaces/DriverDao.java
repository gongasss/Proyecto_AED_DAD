package org.example.proyecto_aed_dad.dao.interfaces;

import org.example.proyecto_aed_dad.entity.Circuit;
import org.example.proyecto_aed_dad.entity.Driver;

import java.util.Collection;
import java.util.List;

public interface DriverDao extends GenericDao<org.example.proyecto_aed_dad.entity.Driver> {
    Driver getByName(String name);

    List<Object[]> findTopDriversWithCountInCountry(String country); // devuelve los 10 pilotos con mayor cantidad de top10 en circuitos de Italia

    List<Object[]> findDriversWithMostRaces();
    List<Object[]> findDriversWithMostRacesByCircuit(Circuit circuit);
    List<Object[]> findDriversWithMostWins();
}
