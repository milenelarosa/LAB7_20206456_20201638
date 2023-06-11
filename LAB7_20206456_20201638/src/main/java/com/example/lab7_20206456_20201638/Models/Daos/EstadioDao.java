package com.example.lab7_20206456_20201638.Models.Daos;

import com.example.lab7_20206456_20201638.Models.Beans.ArraySeleccion;
import com.example.lab7_20206456_20201638.Models.Beans.Estadio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EstadioDao extends BaseDao{
    public ArrayList<Estadio> listaEstadioCombobox(){

        ArrayList<Estadio> estadio = new ArrayList<>();

        String sql = "SELECT  idEstadio, nombre from estadio\n";

        try (Connection connection = this.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){

            while (resultSet.next()) {
                Estadio estadio1 = new Estadio();
                estadio1.setId_estadio(resultSet.getInt(1));
                estadio1.setNombreEstadio(resultSet.getString(2));

                estadio.add(estadio1);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return estadio;
    }
}
