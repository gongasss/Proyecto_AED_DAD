package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.ConstructorStanding;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ConstructorStandingDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.ConstructorsStandingDao {
    SessionFactory sessionFactory;

    public ConstructorStandingDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(ConstructorStanding entity) {
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
    public ConstructorStanding getById(int id) {
        Session session = sessionFactory.openSession();
        ConstructorStanding constructorStanding = null;
        try {
            constructorStanding = (ConstructorStanding) session.find(ConstructorStanding.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return constructorStanding;
    }

    @Override
    public void update(ConstructorStanding entity) {
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
    public void delete(ConstructorStanding entity) {
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

    @Override public List<ConstructorStanding> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT c FROM ConstructorStanding c ORDER BY c.constructor.name";
            List<ConstructorStanding> constructorStandings = session.createQuery(hql, ConstructorStanding.class).list();
            session.getTransaction().commit();
            return constructorStandings;
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
