package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.ConstructorsResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ConstructorsResultDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.ConstructorsResultDao {
    SessionFactory sessionFactory;

    public ConstructorsResultDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(ConstructorsResult entity) {
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
    public ConstructorsResult getById(int id) {
        Session session = sessionFactory.openSession();
        ConstructorsResult constructorsResult = null;
        try {
            constructorsResult = (ConstructorsResult) session.find(ConstructorsResult.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return constructorsResult;
    }

    @Override
    public void update(ConstructorsResult entity) {
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
    public void delete(ConstructorsResult entity) {
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

    @Override public List<ConstructorsResult> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT c FROM ConstructorsResult c ORDER BY c.constructor.name";
            List<ConstructorsResult> constructorsResults = session.createQuery(hql, ConstructorsResult.class).list();
            session.getTransaction().commit();
            return constructorsResults;
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
