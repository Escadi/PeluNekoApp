package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.time.LocalDate;


public class App {

    public static void main(String[] args) {
        insertarPersona();

        // Actualización
        actualizarPersona(2); // Asumiendo ID 1

        // Eliminación
        eliminarPersona(1); // Asumiendo ID 1

        HibernateUtil.shutdown();
    }

    public static void insertarPersona() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        LocalDate fecha = LocalDate.now();

        Persona p = new Persona();
        p.setNombre("María");
        p.setApellido1("Jiménez");
        p.setApellido2("Súarez");
        p.setNif("12345678W");
        p.setTelefono("1234567");
        p.setSexo("M");
        p.setTipo("profesor");
        p.setDireccion("C/ Avenida José Sánchez Peñate");
        p.setCiudad("Las Palmas");
        p.setFechaNacimiento(fecha);

        session.save(p);
        tx.commit();
        session.close();

        System.out.println("Persona insertada con ID: " + p.getId());
    }

    public static void actualizarPersona(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Persona p = session.get(Persona.class, id);
        if (p != null) {
            p.setNombre("Carlos Modificado");
            session.update(p);
        }

        tx.commit();
        session.close();

        System.out.println("Persona actualizada con ID: " + id);
    }

    public static void eliminarPersona(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Persona p = session.get(Persona.class, id);
        if (p != null) {
            session.delete(p);
        }

        tx.commit();
        session.close();

        System.out.println("Persona eliminada con ID: " + id);

    }
}
