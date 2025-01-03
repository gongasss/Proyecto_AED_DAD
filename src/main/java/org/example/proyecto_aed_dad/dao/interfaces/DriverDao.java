package org.example.proyecto_aed_dad.dao.interfaces;

import org.example.proyecto_aed_dad.entity.Driver;

public interface DriverDao extends GenericDao<org.example.proyecto_aed_dad.entity.Driver> {
    Driver getByName(String name);
}
