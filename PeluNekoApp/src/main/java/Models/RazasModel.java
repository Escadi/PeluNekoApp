package Models;

import Entity.Raza;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class RazasModel {

    public static List<Raza> getRazas() {;
        List<Raza> razas = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            razas = session.createQuery("from Raza", Raza.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return razas;
    }
}
