package Models;

import Entity.Logincentro;
import Hibernate.HibernateUntil;
import org.hibernate.Session;

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
}
