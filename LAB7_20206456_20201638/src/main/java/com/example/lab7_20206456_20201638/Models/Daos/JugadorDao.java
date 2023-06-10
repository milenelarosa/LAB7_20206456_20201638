package com.example.lab7_20206456_20201638.Models.Daos;

import com.example.lab7_20206456_20201638.Models.Beans.Jugador;
import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class JugadorDao extends BaseDao{

    public ArrayList<Jugador> listarJugadores(){

        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        String sql = "SELECT j.*, s.* FROM jugador j, seleccion s\n" +
                "WHERE j.sn_idSeleccion = s.idSeleccion;";

        try (Connection connection = this.getConnection();
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                Jugador jugador = new Jugador();
                Seleccion seleccion = new Seleccion();
                jugador.setIdJugador(resultSet.getInt(1));
                jugador.setNombreJugador(resultSet.getString(2));
                jugador.setEdad(resultSet.getInt(3));
                jugador.setPosicion(resultSet.getString(4));
                jugador.setClub(resultSet.getString(5));
                jugador.setIdSeleccion(resultSet.getInt(6));
                seleccion.setIdSeleccion(resultSet.getInt(7));
                seleccion.setNombreSeleccion(resultSet.getString(8));
                seleccion.setTecnico(resultSet.getString(9));
                seleccion.setIdEstadio(resultSet.getInt(10));
                jugador.setSeleccion(seleccion);
                listaJugadores.add(jugador);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    return listaJugadores;
    }

    public boolean verificarNombreExiste(String nombre, int seleccion) {
        boolean existe = false;

        String sql = "SELECT COUNT(*) FROM jugador WHERE nombre = ? AND sn_idseleccion = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setInt(2, seleccion);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                existe = count > 0;
            }
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return existe;
    }

    public void guardarJugador(Jugador jugador) {

        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, jugador.getNombreJugador());
            pstmt.setInt(2, jugador.getEdad());
            pstmt.setString(3, jugador.getPosicion());
            pstmt.setString(4, jugador.getClub());
            pstmt.setInt(5, jugador.getSeleccion().getIdSeleccion());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
