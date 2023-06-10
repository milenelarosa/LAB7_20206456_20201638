package com.example.lab7_20206456_20201638.Servlets;


import com.example.lab7_20206456_20201638.Models.Beans.Jugador;
import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;
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
        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        String action = request.getParameter("a") == null ? "listarSelecciones" : request.getParameter("a");

        switch (action) {
            case "listarSelecciones":
                request.setAttribute("listaJugadores", jugadorDao.listarJugadores());
                request.getRequestDispatcher("listaSelecciones.jsp").forward(request,response);
                break;
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


    }

}


