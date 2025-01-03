package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.PitStop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PitStopDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.PitStopDao {
    SessionFactory sessionFactory;

    public PitStopDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(PitStop entity) {
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
    public PitStop getById(int id) {
        Session session = sessionFactory.openSession();
        PitStop pitStop = null;
        try {
            pitStop = (PitStop) session.find(PitStop.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pitStop;
    }

    @Override
    public void update(PitStop entity) {
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
    public void delete(PitStop entity) {
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

    @Override public List<PitStop> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT p FROM PitStop p ORDER BY p.stop";
            List<PitStop> pitStops = session.createQuery(hql, PitStop.class).list();
            session.getTransaction().commit();
            return pitStops;
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
