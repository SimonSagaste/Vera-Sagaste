/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import accesoBD.acceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class insert {
    public Boolean agregar(String nombre, Double valor){
        try {
            String sql = "insert into indicador2 (nombre,valor) values (?,?)";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,valor.toString().replace('.', ','));
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public Boolean borrar(String nombre){
        try {
            String sql = "delete indicador2 where nombre=?";
            PreparedStatement preparedStatement = acceso.obtenerInstancia().prepareStatement(sql);
            preparedStatement.setString(1,nombre);
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public ArrayList<indicador> lista(){
        try {
            String sql="select valor,nombre from indicador2";
            PreparedStatement preparedStatement =acceso.obtenerInstancia().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 
            ArrayList<indicador> lista = new ArrayList();
            while (resultSet.next()){
                indicador indicador = new indicador();
                String valor = resultSet.getString("valor").replace(',','.');
                indicador.setValor(new Double(valor));
                indicador.setNombre(resultSet.getString("nombre"));
                lista.add(indicador);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
                return null;
        }
    }
}
