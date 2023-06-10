package com.example.lab7_20206456_20201638.Models.Daos;

import com.example.lab7_20206456_20201638.Models.Beans.Seleccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SeleccionDao extends BaseDao{

    // Metodo para listar selecciones







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
}
