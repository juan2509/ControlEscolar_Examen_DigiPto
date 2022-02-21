package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dominio.MateriaADOImpl;
import java.util.List;
import model.Materia;

@WebServlet("/MateriaControllerServlet")
public class MateriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "getById":
                    this.getById(request, response);
                    break;
                case "delete":
                    this.delete(request, response);
                    break;
            }
        } else {
            this.getAll(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {          
            switch(accion) {
                case "add":
                    this.add(request, response);
                    break;
                case "update":
                    this.update(request, response);
                    break;
            }
        } else {
            this.getAll(request, response);
        }
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Materia> materias = new MateriaADOImpl().GetAll();

        request.setAttribute("materias", materias);

        request.getRequestDispatcher("materia/materias.jsp").forward(request, response);
    }

    private void getById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idMateria = Integer.parseInt(request.getParameter("id"));

        Materia materia = new MateriaADOImpl().GetById(idMateria);

        request.setAttribute("materia", materia);

        request.getRequestDispatcher("materia/actualizarMateria.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        double costo = Double.parseDouble(request.getParameter("costo"));

        Materia materia = new Materia(nombre, costo);

        int resultQuery = new MateriaADOImpl().Add(materia);

        //Nota: agregar modal de aviso, en caso verdadero o falso
        if (resultQuery > 0) {
            getAll(request, response);
        } else {
            getAll(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idMateria"));
        String nombre = request.getParameter("nombre");
        double costo = Double.parseDouble(request.getParameter("costo"));

        Materia materia = new Materia(id, nombre, costo);
        
        int resultQuery = new MateriaADOImpl().Update(materia);

        if (resultQuery > 0) {
            getAll(request, response);
        } else {
            getAll(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        int rowsAffected = new MateriaADOImpl().Delete(id);

        if (rowsAffected > 0) {
            getAll(request, response);
        } else {
            getAll(request, response);
        }
    }
}
