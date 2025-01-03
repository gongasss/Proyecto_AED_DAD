package org.example.proyecto_aed_dad.dao.interfaces;

import org.example.proyecto_aed_dad.entity.Result;

import java.util.List;

public interface ResultDao extends GenericDao<org.example.proyecto_aed_dad.entity.Result> {
    List<Result> getResultsByCountry(String country);
}
