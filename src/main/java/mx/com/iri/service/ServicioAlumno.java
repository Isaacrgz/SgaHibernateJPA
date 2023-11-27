package mx.com.iri.service;

import java.util.List;
import mx.com.iri.dao.AlumnoDAO;
import mx.com.iri.domain.Alumno;

public class ServicioAlumno {
    AlumnoDAO alumnoDAO = new AlumnoDAO();
    
    public List<Alumno> listarAlumnos() {
        return alumnoDAO.listar();
    }
    
    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDAO.insertar(alumno);
        } else {
            alumnoDAO.actualzilar(alumno);
        }
    }
    
    public void eliminarAlumno(Alumno alumno) {
        alumnoDAO.eliminar(alumno);
    }
    
    public Alumno encontrarAlumno(Alumno alumno) {
        return alumnoDAO.buscarPorId(alumno);
    }
}
