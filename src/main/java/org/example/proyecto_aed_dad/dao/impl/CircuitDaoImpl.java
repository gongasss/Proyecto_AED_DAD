package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Circuit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CircuitDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.CircuitDao {
    SessionFactory sessionFactory;

    public CircuitDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Circuit entity) {
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
    public Circuit getById(int id) {
        Session session = sessionFactory.openSession();
        Circuit circuit = null;
        try {
            circuit = (Circuit) session.find(Circuit.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return circuit;
    }

    @Override
    public void update(Circuit entity) {
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
    public void delete(Circuit entity) {
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

    @Override
    public List<Circuit> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT c FROM Circuit c ORDER BY c.name";
            List<Circuit> circuits = session.createQuery(hql, Circuit.class).list();
            session.getTransaction().commit();
            return circuits;
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
    public List<Object[]> findTracksWithMostRaces() {
        try {
            // devuelve los 10 circuitos con más carreras
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            String hql = """
            SELECT c, COUNT(r)
            FROM Race r
            JOIN r.circuit c
            GROUP BY c
            ORDER BY COUNT(r) DESC
            """;

            return session.createQuery(hql, Object[].class)
                    .setMaxResults(10) // Limita a los 10 primeros pilotos
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
        return null;
    }
}
