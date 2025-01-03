package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.LapTime;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class LapTimeDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.LapTimeDao {
    SessionFactory sessionFactory;

    public LapTimeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(LapTime entity) {
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
    public LapTime getById(int id) {
        Session session = sessionFactory.openSession();
        LapTime lapTime = null;
        try {
            lapTime = (LapTime) session.find(LapTime.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return lapTime;
    }

    @Override
    public void update(LapTime entity) {
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
    public void delete(LapTime entity) {
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

    @Override public List<LapTime> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT l FROM LapTime l ORDER BY l.id.lap ASC";
            List<LapTime> lapTimes = session.createQuery(hql, LapTime.class).list();
            session.getTransaction().commit();
            return lapTimes;
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
