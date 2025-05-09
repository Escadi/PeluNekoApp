package Models;

import Entity.Voluntarioscentro;
import Hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public static void addVoluntario(Voluntarioscentro voluntario) {
       Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(voluntario);
        tx.commit();
        session.close();
    }
    public static void updateVoluntario(Voluntarioscentro voluntario) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(voluntario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteVoluntario(Voluntarioscentro voluntario) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(voluntario);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
