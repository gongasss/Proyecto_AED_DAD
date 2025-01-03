package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Circuit;
import org.example.proyecto_aed_dad.entity.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.DriverDao {
    SessionFactory sessionFactory;

    public DriverDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Driver entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Driver getById(int id) {
        Session session = sessionFactory.openSession();
        Driver driver = null;
        try {
            driver = (Driver) session.find(Driver.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return driver;
    }

    @Override
    public void update(Driver entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Driver entity) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.remove(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override public List<Driver> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT d FROM Driver d ORDER BY d.forename ASC";
            List<Driver> drivers = session.createQuery(hql, Driver.class).list();
            session.getTransaction().commit();
            return drivers;
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return null;
    }
    @Override
    public Driver getByName(String name) {
        Session session = sessionFactory.openSession();
        Driver driver = null;
        try {
            session.beginTransaction();
            driver = (Driver) session.createQuery("SELECT d FROM Driver d WHERE d.forename = :name OR d.surname = :name", Driver.class)
                    .setParameter("name", name)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            if(session.getTransaction().isActive()) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return driver;
    }
    @Override
    public List<Object[]> findDriversWithMostRaces() {
        // devuelve los 10 pilotos con mayor cantidad de carreras
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = """
            SELECT d, COUNT(r)
            FROM Result r
            JOIN r.driver d
            GROUP BY d
            ORDER BY COUNT(r) DESC
            """;
        return session.createQuery(hql, Object[].class)
                .setMaxResults(10) // Limita a los 10 primeros pilotos
                .getResultList();
    }
    @Override
    public List<Object[]> findDriversWithMostRacesByCircuit(Circuit circuit) {
        // devuelve los 10 pilotos con mayor cantidad de carreras
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = """
            SELECT d, COUNT(r)
            FROM Result r
            JOIN r.driver d
            JOIN r.race.circuit c
            WHERE c = :circuit
            GROUP BY d
            ORDER BY COUNT(r) DESC
            """;
        session.getTransaction().commit();
        return session.createQuery(hql, Object[].class)
                .setParameter("circuit", circuit)
                .setMaxResults(10) // Limita a los 10 primeros pilotos
                .getResultList();
    }
    @Override
    public List<Object[]> findDriversWithMostWins() {
        // devuelve los 10 pilotos con mayor cantidad de victorias
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String hql = """
            SELECT d, COUNT(r)
            FROM Result r
            JOIN r.driver d
            GROUP BY d
            ORDER BY COUNT(r) DESC
            """;
        session.getTransaction().commit();
        return session.createQuery(hql, Object[].class)
                .setMaxResults(10) // Limita a los 10 primeros pilotos
                .getResultList();
    }

    public List<Object[]> findTopDriversWithCountInCountry(String country) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = """
            SELECT r.driver, COUNT(r)
            FROM Result r
            WHERE r.position <= 10 AND r.race.circuit.country = :country
            GROUP BY r.driver.id
            ORDER BY COUNT(r) DESC
            """;
            session.getTransaction().commit();
            return session.createQuery(hql, Object[].class)
                    .setParameter("country", country)
                    .setMaxResults(10) // Limita a los 10 primeros pilotos
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        return null;
    }




}
