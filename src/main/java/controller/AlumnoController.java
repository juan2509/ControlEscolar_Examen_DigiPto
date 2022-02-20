package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Alumno;
import dominio.AlumnoDAOImpl;

@WebServlet("/AlumnoControllerServlet")
public class AlumnoController extends HttpServlet {  
    
    //Peticion GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");  
        
        if (accion != null) {
            switch(accion) {
                case "add":
                    add(request, response);
                    break;
                case "getById":
                    getById(request, response);
                    break;
                case "delete":
                    delete(request, response);
                    break;
            }
        } else {
            getAll(request, response);
        }                       
    }
    
    
    //Peticion POST
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String accion = request.getParameter("accion");    
        
        if (accion != null) {
            switch(accion) {
                case "add":
                    add(request, response);
                    break;
                case "update":
                    update(request, response);
                    break;
            }
        } else {
            getAll(request, response);
        }
    }
    
    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Alumno> alumnos = new AlumnoDAOImpl().GetAll();
        
        request.setAttribute("alumnos", alumnos);
        
        request.getRequestDispatcher("alumno/alumnos.jsp").forward(request, response);
    }
    
    private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idAlumno = Integer.parseInt(request.getParameter("id"));
        
        Alumno alumno = new AlumnoDAOImpl().GetById(idAlumno);
        
        request.setAttribute("alumno", alumno);
        
        request.getRequestDispatcher("alumno/actualizarAlumno.jsp").forward(request, response);
    } 
    
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        
        Alumno alumno = new Alumno(nombre, apellidoPaterno, apellidoMaterno);
        
        int resultQuery = new AlumnoDAOImpl().Add(alumno);
        
        //Nota: agregar modal de aviso, en caso verdadero o falso
        if (resultQuery > 0) {
            getAll(request, response);
        } else {                        
            getAll(request,response);
        }        
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idAlumno"));
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
                      
        Alumno alumno = new Alumno(id, nombre, apellidoPaterno, apellidoMaterno);
        
        int resultQuery = new AlumnoDAOImpl().Update(alumno);
        
        if (resultQuery > 0) {
            getAll(request, response);
        } else {
            getAll(request, response);            
        }
    }
    
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        int rowsAffected = new AlumnoDAOImpl().Delete(id);
        
        if (rowsAffected > 0) {
            getAll(request, response);
        } else {
            getAll(request, response);
        }
    }
}
