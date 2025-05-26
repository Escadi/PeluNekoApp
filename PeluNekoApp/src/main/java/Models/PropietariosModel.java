package Models;

import Entity.Nuevosdueno;
import Hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public static void addPropietario(Nuevosdueno nuevoDueno) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(nuevoDueno);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePropietario(Nuevosdueno nuevoDueno) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Nuevosdueno propietario = session.get(Nuevosdueno.class, nuevoDueno.getDni());
            if (propietario != null) {
                propietario.setNombre(nuevoDueno.getNombre());
                propietario.setApellido1(nuevoDueno.getApellido1());
                propietario.setApellido2(nuevoDueno.getApellido2());
                propietario.setDireccion(nuevoDueno.getDireccion());
                propietario.setLocalidad(nuevoDueno.getLocalidad());
                session.update(propietario);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePropietario(String dni) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Nuevosdueno propietario = session.get(Nuevosdueno.class, dni);
            if (propietario != null) {
                session.delete(propietario);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
