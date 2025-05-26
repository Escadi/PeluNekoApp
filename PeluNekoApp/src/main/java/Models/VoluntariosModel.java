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
            Transaction tx = session.beginTransaction();
            Voluntarioscentro voluntarioUpdate = session.get(Voluntarioscentro.class, voluntario.getDNIVoluntario());
            if (voluntarioUpdate != null) {
                voluntarioUpdate.setNombreVoluntario(voluntario.getNombreVoluntario());
                voluntarioUpdate.setApellido1Voluntario(voluntario.getApellido1Voluntario());
                voluntarioUpdate.setApellido2Voluntario(voluntario.getApellido2Voluntario());
                voluntarioUpdate.setDireccionVoluntario(voluntario.getDireccionVoluntario());
                voluntarioUpdate.setLocalidadVoluntario(voluntario.getLocalidadVoluntario());
                voluntarioUpdate.setCodigoPostalVoluntario(voluntario.getCodigoPostalVoluntario());
                session.update(voluntarioUpdate);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteVoluntario(String dni) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Voluntarioscentro voluntarioDelete = session.get(Voluntarioscentro.class, dni);
            if (voluntarioDelete != null) {
                session.delete(voluntarioDelete);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
