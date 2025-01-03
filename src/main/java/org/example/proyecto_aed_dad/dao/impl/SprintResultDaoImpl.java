package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.dao.interfaces.SprintResultDao;
import org.example.proyecto_aed_dad.entity.SprintResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SprintResultDaoImpl implements SprintResultDao {
    SessionFactory sessionFactory;

    public SprintResultDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(SprintResult entity) {

    }

    @Override
    public SprintResult getById(int id) {
        return null;
    }

    @Override
    public void update(SprintResult entity) {

    }

    @Override
    public void delete(SprintResult entity) {

    }

    @Override public List<SprintResult> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT s FROM SprintResult s ORDER BY s.race.year";
            List<SprintResult> sprintResults = session.createQuery(hql, SprintResult.class).list();
            session.getTransaction().commit();
            return sprintResults;
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
