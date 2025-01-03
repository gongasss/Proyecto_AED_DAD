package org.example.proyecto_aed_dad.dao.impl;

import org.example.proyecto_aed_dad.entity.Circuit;
import org.example.proyecto_aed_dad.entity.Constructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ConstructorDaoImpl implements org.example.proyecto_aed_dad.dao.interfaces.ConstructorDao {
    SessionFactory sessionFactory;

    public ConstructorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void insert(Constructor entity) {
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
    public Constructor getById(int id) {
        Session session = sessionFactory.openSession();
        Constructor constructor = null;
        try {
            constructor = (Constructor) session.find(Constructor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return constructor;
    }

    @Override
    public void update(Constructor entity) {
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
    public void delete(Constructor entity) {
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
    public List<Constructor> findAll() {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            String hql = "SELECT c FROM Constructor c ORDER BY c.name";
            List<Constructor> constructors = session.createQuery(hql, Constructor.class).list();
            session.getTransaction().commit();
            return constructors;
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
    public List<Object[]> findConstructorsWithMostWinsByCountry(String country) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        String hql = """
            SELECT c, COUNT(r)
            FROM Result r
            JOIN r.constructor c
            WHERE r.position = 1 AND r.race.circuit.country = :country
            GROUP BY c
            ORDER BY COUNT(r) DESC
            """;

        return session.createQuery(hql, Object[].class)
                .setParameter("country", country)
                .setMaxResults(10) // Limita a los 10 primeros pilotos
                .getResultList();
    }

    @Override
    public List<Object[]> findConstructorsWithMostWinsByCircuit(Circuit circuit) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            String hql = """
            SELECT c, COUNT(r)
            FROM Result r
            JOIN r.constructor c
            WHERE r.position = 1 AND r.race.circuit = :circuit
            GROUP BY c
            ORDER BY COUNT(r) DESC
            """;

            return session.createQuery(hql, Object[].class)
                    .setParameter("circuit", circuit)
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
