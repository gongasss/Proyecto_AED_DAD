package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.DriverStanding;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class DriverStandingDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.DriverStandingDao {
    SessionFactory sessionFactory;

    public DriverStandingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(DriverStanding entity) {
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
    public DriverStanding getById(int id) {
        Session session = sessionFactory.openSession();
        DriverStanding driverStanding = null;
        try {
            driverStanding = (DriverStanding) session.find(DriverStanding.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return driverStanding;
    }

    @Override
    public void update(DriverStanding entity) {
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
    public void delete(DriverStanding entity) {
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

    @Override public List<DriverStanding> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT d FROM DriverStanding d ORDER BY d.driver.name";
            List<DriverStanding> driverStandings = session.createQuery(hql, DriverStanding.class).list();
            session.getTransaction().commit();
            return driverStandings;
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
}
