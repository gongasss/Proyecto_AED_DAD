package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Qualifying;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QualifyingDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.QualifyingDao {
    SessionFactory sessionFactory;

    public QualifyingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Qualifying entity) {
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
    public Qualifying getById(int id) {
        Session session = sessionFactory.openSession();
        Qualifying qualifying = null;
        try {
            qualifying = (Qualifying) session.find(Qualifying.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return qualifying;
    }

    @Override
    public void update(Qualifying entity) {
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
    public void delete(Qualifying entity) {
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

    @Override public List<Qualifying> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT q FROM Qualifying q ORDER BY q.number";
            List<Qualifying> qualifyings = session.createQuery(hql, Qualifying.class).list();
            session.getTransaction().commit();
            return qualifyings;
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
