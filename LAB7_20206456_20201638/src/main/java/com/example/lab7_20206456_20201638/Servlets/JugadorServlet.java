package com.example.lab7_20206456_20201638.Servlets;


import com.example.lab7_20206456_20201638.Models.Beans.Jugador;
import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;
import com.example.lab7_20206456_20201638.Models.Daos.JugadorDao;
import com.example.lab7_20206456_20201638.Models.Daos.SeleccionDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "JugadorServlet", value = "/JugadorServlet")
public class JugadorServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        JugadorDao jugadorDao = new JugadorDao();
        SeleccionDao seleccionDao = new SeleccionDao();

        String action = request.getParameter("a") == null ? "listarJugadores" : request.getParameter("a");

        switch (action){
            case "listarJugadores":
                request.setAttribute("listaJugadores", jugadorDao.listarJugadores());
                request.getRequestDispatcher("listaJugadores.jsp").forward(request,response);
                break;
            case "crearJugador":
                request.setAttribute("listaSelecciones", seleccionDao.listarSeleccionesComboBox());
                request.getRequestDispatcher("crearJugador.jsp").forward(request,response);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String action = request.getParameter("p") == null ? "crear" : request.getParameter("p");

        JugadorDao jugadorDao = new JugadorDao();

        switch (action) {
            case "crear":
                Jugador jugador = new Jugador();
                Seleccion seleccion = new Seleccion();
                String nombreJugador = request.getParameter("nombre");
                String edadJugadorStr = request.getParameter("edad");
                String posicion = request.getParameter("posicion");
                String club = request.getParameter("club");
                String seleccionIdStr = request.getParameter("seleccion_id");
                int seleccionId = Integer.parseInt(seleccionIdStr);

                if(nombreJugador.isEmpty() || edadJugadorStr.isEmpty() || !esNumero(edadJugadorStr) || posicion.isEmpty() || club.isEmpty() || seleccionIdStr.isEmpty()) {
                    response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearJugador");
                    return;
                }
                int edadJugador;
                try {
                    edadJugador = Integer.parseInt(edadJugadorStr);
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearJugador");
                    return;
                }
                if (jugadorDao.verificarNombreExiste(nombreJugador, seleccionId)) {
                    response.sendRedirect(request.getContextPath() + "/JugadorServlet?a=crearJugador");
                    return;
                }
                jugador.setNombreJugador(nombreJugador);
                jugador.setEdad(edadJugador);
                jugador.setPosicion(posicion);
                jugador.setClub(club);
                seleccion.setIdSeleccion(seleccionId);
                jugador.setSeleccion(seleccion);

                jugadorDao.guardarJugador(jugador);
                response.sendRedirect(request.getContextPath() + "/JugadorServlet#jugadores");
                break;
        }
    }

    private boolean esNumero(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}


