package com.example.lab7_20206456_20201638.Servlets;


import com.example.lab7_20206456_20201638.Models.Beans.Estadio;
import com.example.lab7_20206456_20201638.Models.Dtos.ListarSeleccionesDto;
import com.example.lab7_20206456_20201638.Models.Daos.EstadioDao;
import com.example.lab7_20206456_20201638.Models.Daos.SeleccionDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

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

            case "borrar":
                String idSeleccion = request.getParameter("id");
                if (seleccionDao.obtenerSeleccion(idSeleccion) != null) {
                    try {
                        seleccionDao.borrarSeleccion(idSeleccion);
                    } catch (SQLException | IllegalStateException e) {

                        response.sendRedirect(request.getContextPath() + "/SeleccionServlet?err=Error al borrar la seleccion");
                    }
                }
                response.sendRedirect(request.getContextPath() + "/SeleccionServlet#selecciones?msg=Seleccion borrada exitosamente");
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        SeleccionDao seleccionDao = new SeleccionDao();
        switch (action) {
            case "crear":
                ListarSeleccionesDto listarSeleccionesDto = new ListarSeleccionesDto();
                Estadio estadio = new Estadio();
                String nombreSeleccion = request.getParameter("nombre");
                String tecnico = request.getParameter("tecnico");
                String id_estadioStr = request.getParameter("estadio_id");
                int id_estadio = Integer.parseInt(id_estadioStr);

                if(nombreSeleccion.isEmpty() || tecnico.isEmpty() || id_estadioStr.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/SeleccionServlet?a=crearSeleccion");
                    return;
                }

                if(seleccionDao.verificarNombreExiste(nombreSeleccion)){
                    response.sendRedirect(request.getContextPath() + "/SeleccionServlet?a=crearSeleccion");
                    return;
                }

                listarSeleccionesDto.setNombre(nombreSeleccion);
                listarSeleccionesDto.setTecnico(tecnico);
                estadio.setId_estadio(id_estadio);
                listarSeleccionesDto.setEstadio(estadio);

                seleccionDao.guardarSeleccion(listarSeleccionesDto);

                response.sendRedirect(request.getContextPath() + "/SeleccionServlet#selecciones");
                break;
        }

    }

}


