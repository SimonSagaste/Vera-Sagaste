/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VarPorcentual;
import Modelo.diferencia;
import Modelo.indicador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Control {
    VarPorcentual consulta;
    
   public ArrayList diferenciar (String nombre){
    ArrayList listar = new ArrayList ();
    diferencia dif = new diferencia ();
       try {
           listar = dif.diferencias(nombre);
       } catch (IOException ex) {
           Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
       }
       return listar;
       
    }
   public ArrayList<indicador> Porcentaje(String nombre){
       consulta = new VarPorcentual();
       return consulta.Porcentaje(nombre);
   }
    
}
