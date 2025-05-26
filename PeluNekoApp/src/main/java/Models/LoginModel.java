package Models;

import Entity.Logincentro;
import Entity.Voluntarioscentro;
import Hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LoginModel {

    public static List<Logincentro> getLogin() {
        List<Logincentro> logins = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            logins = session.createQuery("from Logincentro", Logincentro.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logins;
    }
    public static void addLogin(Logincentro logincentro) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(logincentro);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void actualizarLogin(int id, Logincentro logincentro) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Logincentro login = session.get(Logincentro.class, id);
            Transaction tx = session.beginTransaction();
            if (login != null) {
                login.setIdVoluntarioString(logincentro.getVoluntarioid());
                login.setPasswd(logincentro.getPasswd());
                login.setRol(logincentro.getRol());
                session.update(login);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void eliminarLogin(int id) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Logincentro login = session.get(Logincentro.class, id);
            Transaction tx = session.beginTransaction();
            session.delete(login);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String admin(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            System.err.println("DNI inválido: " + dni);
            return null;
        }

        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Voluntarioscentro voluntario = session.get(Voluntarioscentro.class, dni);

            if (voluntario == null) {
                System.err.println("No se encontró voluntario con DNI: " + dni);
                return null;
            }

            Logincentro logincentro = session.createQuery(
                            "FROM Logincentro WHERE idVoluntario = :voluntario", Logincentro.class)
                    .setParameter("voluntario", voluntario)
                    .uniqueResult();

            return (logincentro != null) ? logincentro.getRol() : null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
