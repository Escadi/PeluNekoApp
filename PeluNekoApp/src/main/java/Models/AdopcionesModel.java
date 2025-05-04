package Models;

import Entity.Adopcione;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class AdopcionesModel {

    public static List<Adopcione> getAdopciones() {
        List<Adopcione> adopciones = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            adopciones = session.createQuery("from Adopcione", Adopcione.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adopciones;
    }
}
