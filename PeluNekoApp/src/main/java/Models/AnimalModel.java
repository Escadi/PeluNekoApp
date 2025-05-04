package Models;

import Entity.*;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class AnimalModel {

    public static List<Animale> getAnimals() {
        List<Animale> animales = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            animales = session.createQuery("from Animale", Animale.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return animales;
    }
}
