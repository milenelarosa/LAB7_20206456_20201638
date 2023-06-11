package com.example.lab7_20206456_20201638.Servlets;


import com.example.lab7_20206456_20201638.Models.Beans.ArraySeleccion;
import com.example.lab7_20206456_20201638.Models.Beans.Jugador;
import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;
import com.example.lab7_20206456_20201638.Models.Daos.EstadioDao;
import com.example.lab7_20206456_20201638.Models.Daos.JugadorDao;
import com.example.lab7_20206456_20201638.Models.Daos.SeleccionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "SeleccionServlet", value = "/SeleccionServlet")
public class SeleccionServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //Completa tu vista
        EstadioDao estadioDao = new EstadioDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        String action = request.getParameter("a") == null ? "listarSelecciones" : request.getParameter("a");

        switch (action) {
            case "listarSelecciones":
                request.setAttribute("listaSelecciones", seleccionDao.listaSelecciones());
                request.getRequestDispatcher("listaSelecciones.jsp").forward(request,response);
                break;
            case "crearSeleccion":
                request.setAttribute("estadio", estadioDao.listaEstadioCombobox());
                request.getRequestDispatcher("crearSeleccion.jsp").forward(request,response);
                break;
            /* case "borrar":
                String idSeleccion = request.getParameter("id");
                if (SeleccionDao.(idSeleccion) != null) {
                    try {
                        SeleccionDao.borra(jobId);
                    } catch (SQLException e) {
                        response.sendRedirect(request.getContextPath() + "/JobServlet?err=Error al borrar el trabajo");
                    }
                }
                response.sendRedirect(request.getContextPath() + "/JobServlet?msg=Trabajo borrado exitosamente");
                break;
                break;
               
             */
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        SeleccionDao seleccionDao = new SeleccionDao();
        switch (action) {
            case "crear":
                ArraySeleccion a = new ArraySeleccion();
                String nombre = request.getParameter("nombre");
                String tecnico = request.getParameter("tecnico");
                String id_estadioSTR = request.getParameter("estadio_id");
                int id_estadio = Integer.parseInt(id_estadioSTR);

                if(nombre == null || nombre.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearSeleccion");
                    return;
                }
                a.setNombre(nombre);
                a.setTecnico(tecnico);
                a.setIdSeleccion(id_estadio);

                seleccionDao.guardarSeleccion(a);
                response.sendRedirect(request.getContextPath() + "/SeleccionServlet#selecciones");
                break;
        }

    }

}


