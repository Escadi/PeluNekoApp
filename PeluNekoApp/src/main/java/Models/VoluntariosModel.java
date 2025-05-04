package Models;

import Entity.Voluntarioscentro;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

import java.util.List;

public class VoluntariosModel {

    public static List<Voluntarioscentro> getVoluntarios(){
        List<Voluntarioscentro> voluntarios = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            voluntarios = session.createQuery("from Voluntarioscentro", Voluntarioscentro.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voluntarios;
    }
}
