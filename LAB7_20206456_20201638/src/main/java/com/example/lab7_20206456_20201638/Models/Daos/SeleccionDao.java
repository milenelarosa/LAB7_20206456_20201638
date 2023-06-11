package com.example.lab7_20206456_20201638.Models.Daos;

import com.example.lab7_20206456_20201638.Models.Beans.Estadio;
import com.example.lab7_20206456_20201638.Models.Dtos.ListarSeleccionesDto;
import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;

import java.sql.*;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{

    // Metodo para listar selecciones
    public ArrayList<ListarSeleccionesDto> listaSelecciones(){

        ArrayList<ListarSeleccionesDto> listaSelecciones = new ArrayList<>();

        String sql = "SELECT s.idSeleccion, s.nombre,s.tecnico, e.nombre as 'estadio', CONCAT(sl.nombre, ' vs ', sv.nombre) AS primerPartido\n" +
                "FROM seleccion s\n" +
                "LEFT JOIN estadio e ON s.estadio_idEstadio = e.idEstadio\n" +
                "LEFT JOIN ( SELECT p.seleccionLocal, p.seleccionVisitante, p.fecha FROM partido p, seleccion s\n" +
                "\t\t\tWHERE p.seleccionLocal = s.idSeleccion OR p.seleccionVisitante = s.idSeleccion\n" +
                "            ORDER BY p.fecha\n" +
                "            LIMIT 1) AS p ON 1=1\n" +
                "LEFT JOIN seleccion sl ON p.seleccionLocal = sl.idSeleccion\n" +
                "LEFT JOIN seleccion sv ON p.seleccionVisitante = sv.idSeleccion;";

        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                ListarSeleccionesDto listSeleccion = new ListarSeleccionesDto();
                Estadio estadio = new Estadio();
                listSeleccion.setIdSeleccion(resultSet.getInt(1));
                listSeleccion.setNombre(resultSet.getString(2));
                listSeleccion.setTecnico(resultSet.getString(3));
                estadio.setNombreEstadio(resultSet.getString(4));
                listSeleccion.setEstadio(estadio);
                listSeleccion.setPrimerPartido(resultSet.getString(5));
                listaSelecciones.add(listSeleccion);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return listaSelecciones;
    }

    public boolean verificarNombreExiste(String nombre) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM seleccion WHERE nombre = ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, nombre);

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

    public void guardarSeleccion(ListarSeleccionesDto seleccion) {

        String sql = "INSERT INTO seleccion (nombre, tecnico, estadio_idEstadio) "
                + "VALUES (?, ?, ?)";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, seleccion.getNombre());
            pstmt.setString(2, seleccion.getTecnico());
            pstmt.setInt(3, seleccion.getEstadio().getId_estadio());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // No tocar
    public ArrayList<Seleccion> listarSeleccionesComboBox(){
        ArrayList<Seleccion> listaSelecciones = new ArrayList<>();

        String sql = "SELECT * FROM seleccion;";
        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()){
                Seleccion seleccion = new Seleccion();
                seleccion.setIdSeleccion(resultSet.getInt(1));
                seleccion.setNombreSeleccion(resultSet.getString(2));
                seleccion.setTecnico(resultSet.getString(3));
                seleccion.setIdEstadio(resultSet.getInt(4));
                listaSelecciones.add(seleccion);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return listaSelecciones;
    }


    /* public void borrarSeleccion(String idSeleccion) throws SQLException {

        String sql = "DELETE FROM seleccion WHERE idSeleccion = ?";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, idSeleccion);
            pstmt.executeUpdate();
        }
    }
    */
}
