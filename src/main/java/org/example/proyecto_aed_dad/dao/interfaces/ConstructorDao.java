package org.example.proyecto_aed_dad.dao.interfaces;

import org.example.proyecto_aed_dad.entity.Circuit;

import java.util.List;

public interface ConstructorDao extends GenericDao<org.example.proyecto_aed_dad.entity.Constructor> {
    List<Object[]> findConstructorsWithMostWinsByCountry(String country); // devuelve los 10 constructores con mayor cantidad de victorias en el país dado

    List<Object[]> findConstructorsWithMostWinsByCircuit(Circuit circuit); // devuelve los 10 constructores con mayor cantidad de victorias en el circuito dada
}
