package Models;

import Entity.Nuevosdueno;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class PropietariosModel {

    public static List<Nuevosdueno> getPropietarios() {
        List<Nuevosdueno> propietarios = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            propietarios = session.createQuery("from Nuevosdueno", Nuevosdueno.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return propietarios;
    }
}
