package mx.com.iri.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import mx.com.iri.domain.Alumno;
import mx.com.iri.service.ServicioAlumno;

@WebServlet("/ServletModificar")
public class ServletModificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sIdAlumno = request.getParameter("idAlumno");
        Integer idAlumno = Integer.valueOf(sIdAlumno);

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

        //request.setAttribute("alumno", alumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        String modificar = request.getParameter("Modificar");

        if (modificar != null) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession session = request.getSession();
            Alumno alumno = (Alumno) session.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            session.removeAttribute("alumno");
        } else {
            String sIdAlumno = request.getParameter("idAlumno");
            Integer idAlumno = Integer.valueOf(sIdAlumno);
            Alumno alumno = new Alumno(idAlumno);

            servicioAlumno.eliminarAlumno(alumno);
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
