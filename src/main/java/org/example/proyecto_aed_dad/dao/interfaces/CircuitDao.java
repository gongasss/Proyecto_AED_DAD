package org.example.proyecto_aed_dad.dao.interfaces;

import org.example.proyecto_aed_dad.entity.Circuit;

import java.util.List;

public interface CircuitDao extends GenericDao<Circuit> {
    List<Object[]> findTracksWithMostRaces(); // devuelve los 10 circuitos con más carreras
}
