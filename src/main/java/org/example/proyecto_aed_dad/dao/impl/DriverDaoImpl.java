package org.example.proyecto_aed_dad.dao.impl;

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
}
