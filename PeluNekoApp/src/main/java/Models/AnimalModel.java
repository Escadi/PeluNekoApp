package Models;

import Entity.*;
import Hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AnimalModel {

    public static List<Animale> getAnimals() {
        List<Animale> animales = null;
        try (Session session = HibernateUntil.getSessionFactory().openSession()) {
            session.beginTransaction();
            animales = session.createQuery("from Animale", Animale.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return animales;
    }

    public static void addAnimal(Animale animal) {
        Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(animal);
        tx.commit();
        session.close();
    }

    public static void updateAnimal(int id , Animale animal) {
        Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Animale joinAnimal = session.get(Animale.class,id);
        if (joinAnimal != null) {
            joinAnimal.setNombre(animal.getNombre());
            joinAnimal.setTipoAnimal(animal.getTipoAnimal());
            joinAnimal.setPeso(animal.getPeso());
            joinAnimal.setEstado(animal.getEstado());
            joinAnimal.setImagen(animal.getImagen());
            joinAnimal.setIdRaza(animal.getIdRaza());
            joinAnimal.setDNIVoluntario(animal.getDNIVoluntario());
            session.update(joinAnimal);
        }
        tx.commit();
        session.close();
    }
}
