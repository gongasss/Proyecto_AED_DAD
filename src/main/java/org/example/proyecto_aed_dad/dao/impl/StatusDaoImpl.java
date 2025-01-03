package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.dao.interfaces.StatusDao;
import org.example.proyecto_aed_dad.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StatusDaoImpl implements StatusDao {
    SessionFactory sessionFactory;

    public StatusDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Status entity) {

    }

    @Override
    public Status getById(int id) {
        return null;
    }

    @Override
    public void update(Status entity) {

    }

    @Override
    public void delete(Status entity) {

    }

    @Override public List<Status> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT s FROM Status s ORDER BY s.status";
            List<Status> statuses = session.createQuery(hql, Status.class).list();
            session.getTransaction().commit();
            return statuses;
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
