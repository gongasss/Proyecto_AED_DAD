package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ResultDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.ResultDao {
    SessionFactory sessionFactory;

    public ResultDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Result entity) {
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
    public Result getById(int id) {
        Session session = sessionFactory.openSession();
        Result result = null;
        try {
            result = (Result) session.find(Result.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void update(Result entity) {
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
    public void delete(Result entity) {
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

    @Override public List<Result> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT r FROM Result r ORDER BY r.number";
            List<Result> results = session.createQuery(hql, Result.class).list();
            session.getTransaction().commit();
            return results;
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
    public List<Result> getResultsByCountry(String country) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            String hql = "SELECT r FROM Result r WHERE r.race.circuit.country = :country ORDER BY r.number";
            List<Result> results = session.createQuery(hql, Result.class)
                    .setParameter("country", country)
                    .list();
            session.getTransaction().commit();
            return results;
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
