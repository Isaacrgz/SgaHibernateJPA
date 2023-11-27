package mx.com.iri.test.ciclovida;

import jakarta.persistence.*;
import mx.com.iri.domain.Contacto;

public class Estado3ModificarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //1. Definimos la variable
        Contacto contacto = null;

        //Si recuperamos el objeto fuera de la transicion, esta en detached
        contacto = em.find(Contacto.class, 3);

        //2. Modificamos el objeto
        contacto.setEmail("clara@mail.com");

        //3. Persistimos el objeto modificado
        em.getTransaction().begin();
        em.merge(contacto);
        em.getTransaction().commit();

        //4. Detached (separados de la base de datos)
        System.out.println("Contacto: " + contacto);
    }
}
