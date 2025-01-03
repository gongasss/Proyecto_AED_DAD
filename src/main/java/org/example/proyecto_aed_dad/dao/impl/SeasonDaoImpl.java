package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.dao.interfaces.SeasonDao;
import org.example.proyecto_aed_dad.entity.Season;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class SeasonDaoImpl implements SeasonDao {
    SessionFactory sessionFactory;

    public SeasonDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Season entity) {

    }

    @Override
    public Season getById(int id) {
        return null;
    }

    @Override
    public void update(Season entity) {

    }

    @Override
    public void delete(Season entity) {

    }

    @Override public List<Season> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT s FROM Season s ORDER BY s.id";
            List<Season> seasons = session.createQuery(hql, Season.class).list();
            session.getTransaction().commit();
            return seasons;
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
