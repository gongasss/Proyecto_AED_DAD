package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Race;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RaceDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.RaceDao {
    SessionFactory sessionFactory;

    public RaceDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Race entity) {
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
    public Race getById(int id) {
        Session session = sessionFactory.openSession();
        Race race = null;
        try {
            race = (Race) session.find(Race.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return race;
    }

    @Override
    public void update(Race entity) {
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
    public void delete(Race entity) {
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

    @Override public List<Race> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT r FROM Race r ORDER BY r.year";
            List<Race> races = session.createQuery(hql, Race.class).list();
            session.getTransaction().commit();
            return races;
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
