package mx.com.iri.test;

import java.util.List;
import mx.com.iri.dao.AlumnoDAO;
import mx.com.iri.dao.AsignacionDAO;
import mx.com.iri.dao.ContactoDAO;
import mx.com.iri.dao.CursoDAO;
import mx.com.iri.dao.DomicilioDAO;

public class TestDAOs {

    public static void main(String[] args) {
        AlumnoDAO alumnoDAO = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDAO.listar());
        
        DomicilioDAO domicilioDAO = new DomicilioDAO();
        System.out.println("Domicilios: ");
        imprimir(domicilioDAO.listar());
        
        ContactoDAO contactoDAO = new ContactoDAO();
        System.out.println("Contactos: ");
        imprimir(contactoDAO.listar());
        
        CursoDAO cursoDAO = new CursoDAO();
        System.out.println("Cursos: ");
        imprimir(cursoDAO.listar());
        
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("Asignaciones: ");
        imprimir(asignacionDAO.listar());
    }

    private static void imprimir(List coleccion) {
        for (Object o : coleccion) {
            System.out.println("Valor: " + o);
        }
    }
}
