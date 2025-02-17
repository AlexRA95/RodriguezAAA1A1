package es.albarregas.controllers;

import es.albarregas.DAO.IProfesorDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Direccion;
import es.albarregas.beans.Profesor;
import es.albarregas.models.Utils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(".").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String URL = ".";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IProfesorDAO pdao = daof.getProfesorDAO();
        HttpSession sesion = request.getSession();
        Map<String, String[]> parametros = request.getParameterMap();
        Boolean error = false;
        Profesor profesor = new Profesor();
        Direccion direccion = new Direccion();
        if (request.getParameter("opcion").equals("verUpdate")){
            //Significa que el usuario ha seleccionado un profesor para actualizar
            profesor = pdao.getOne(Integer.parseInt(request.getParameter("profUpdate")));
            sesion.setAttribute("profesor", profesor);
            URL = "JSP/Update/FormUpdate.jsp";
        }else if (request.getParameter("opcion").equals("doUpdate")){
            //Significa que el usuario ha enviado el formulario de actualización
            List<String> opcionales = new ArrayList<>();
            opcionales.add("ape2");
            error = Utils.validarParameters(parametros,opcionales);

            if (!error) {
                Profesor profesorSesion = (Profesor) sesion.getAttribute("profesor");
                try{
                    BeanUtils.populate(profesor, parametros);
                    BeanUtils.populate(direccion, parametros);
                    direccion.setIdDirec(profesorSesion.getDireccion().getIdDirec());
                    profesor.setDireccion(direccion);
                    profesor.setId(profesorSesion.getId());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                pdao.update(profesor);
                URL = ".";
                sesion.removeAttribute("profesor");
            }else {
                request.setAttribute("error", "Todos los campos con * son obligatorios");
                URL = "JSP/Update/FormUpdate.jsp";
            }
        } else if (request.getParameter("opcion").equals("cancelar")){
            //Significa que el usuario ha cancelado la actualización
            URL = ".";
            sesion.removeAttribute("profesor");
        }

        request.getRequestDispatcher(URL).forward(request, response);
    }
}