package Models;

import Entity.Adopcione;
import Entity.Animale;
import Entity.Nuevosdueno;
import Hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;
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

    public static void addAdopcion(Adopcione adopcion) {
        Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Animale animales = session.get(Animale.class, adopcion.getIdAdopcionAnimal());
        adopcion.setIdAnimal(animales);
        adopcion.setFechaAdopcion(LocalDate.now());
        session.save(adopcion);
        tx.commit();
        session.close();
    }

    public static void updateAdopcion(Adopcione adopcion) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Adopcione adopcionUpdate = session.get(Adopcione.class, adopcion.getId());
            if (adopcionUpdate != null) {
                adopcionUpdate.setIdAnimal(adopcion.getIdAnimal());
                adopcionUpdate.setDni(adopcion.getDni());
                adopcionUpdate.setFechaAdopcion(adopcion.getFechaAdopcion());
                session.update(adopcionUpdate);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteAdopcion(int id) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Adopcione adopcionDelete = session.get(Adopcione.class, id);
            if (adopcionDelete != null) {
                session.delete(adopcionDelete);
            }
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean tieneAdopcion(String dni){
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Nuevosdueno dueno = session.get(Nuevosdueno.class, dni);
            return dueno != null && dueno.getAdopcionesList() != null && !dueno.getAdopcionesList().isEmpty();
        }
    }
    public static boolean existeAdopcionParaAnimal(int idAnimal) {
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            Long count = session.createQuery(
                            "SELECT COUNT(a) FROM Adopcione a WHERE a.idAnimal.id = :idAnimal", Long.class)
                    .setParameter("idAnimal", idAnimal)
                    .uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
