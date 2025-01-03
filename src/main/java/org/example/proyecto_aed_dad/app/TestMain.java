package org.example.proyecto_aed_dad.app;

import org.example.proyecto_aed_dad.dao.Mediator;
import org.example.proyecto_aed_dad.ui.UserInterface;
import org.example.proyecto_aed_dad.utils.UtilsHibernate;
import org.hibernate.SessionFactory;

public class TestMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = UtilsHibernate.getSessionFactory();

        Mediator mediator = new Mediator(sessionFactory);

        UserInterface userInterface = new UserInterface(mediator);
        userInterface.mainLoop();
    }
}
