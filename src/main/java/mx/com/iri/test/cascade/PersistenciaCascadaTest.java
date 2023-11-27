package mx.com.iri.test.cascade;

import jakarta.persistence.*;
import mx.com.iri.domain.Alumno;
import mx.com.iri.domain.Contacto;
import mx.com.iri.domain.Domicilio;

public class PersistenciaCascadaTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Lirio");
        domicilio.setNoCalle("141");
        domicilio.setPais("Portugal");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("clara@email.com");
        contacto.setTelefono("11223344");
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Carlos");
        alumno.setApellido("Lara");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("Alumno: " + alumno);
    }
}
