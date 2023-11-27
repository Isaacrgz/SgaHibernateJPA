package mx.com.iri.test.ciclovida;

import jakarta.persistence.*;
import mx.com.iri.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //1. Definimos la variable
        Contacto contacto = null;
        
        //2. Recuperamos el objeto
        contacto = em.find(Contacto.class, 3);
        
        //3. Detached (separados de la base de datos)
        System.out.println("Contacto: " + contacto);
    }
}
