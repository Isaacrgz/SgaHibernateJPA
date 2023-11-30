package mx.com.iri.dao;

import jakarta.persistence.Query;
import java.util.List;
import static mx.com.iri.dao.GenericDAO.em;
import mx.com.iri.domain.Curso;

public class CursoDAO extends GenericDAO {

    public List<Curso> listar() {
        String consulta = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(consulta);

        return query.getResultList();
    }

    public void insertar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void actualzilar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public void eliminar(Curso curso) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } 
//        finally {
//            if (em != null) {
//                em.close();
//            }
//        }
    }

    public Curso buscarPorId(Curso curso) {
        em = getEntityManager();

        return em.find(Curso.class, curso.getIdCurso());
    }
}
