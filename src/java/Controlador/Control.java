/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.VarPorcentual;
import Modelo.diferencia;
import Modelo.indicador;
import Modelo.mayor;
import Modelo.menor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simon
 */
public class Control {
    ArrayList listar = new ArrayList ();
    VarPorcentual porc = new VarPorcentual ();
    
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
   public ArrayList porcentaje (String nombre){
    
    listar = porc.Porcentaje(nombre);
       return listar;
       
    }
       public indicador mayor (String nombre) throws IOException{
           mayor major = new mayor();
           
       return major.diferencias(nombre);
       
    }
       
           public indicador menor (String nombre) throws IOException{
           menor major = new menor();
           
       return major.diferencias(nombre);
       
    }
       
}
