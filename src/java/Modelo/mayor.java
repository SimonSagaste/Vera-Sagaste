/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author LEARNING CENTER
 */
public class mayor {
    public indicador diferencias(String indicador) throws  IOException{
        VarPorcentual var = new VarPorcentual ();
               indicador indica = new indicador();
     ArrayList <indicador> list1 = new ArrayList<>();
     list1 = var.Porcentaje(indicador);
    URL url = new URL("https://mindicador.cl/api/"+indicador);
    InputStream is = url.openStream();
    JsonReader rdr = Json.createReader(is);
    JsonObject object = rdr.readObject();
     int f = 0;
    for(int i = 0; i <30; i++){
       
            if (list1.get(i).getValor()>=f){
  
            Double a = Double.parseDouble(object.getJsonArray("serie").getJsonObject(30-i).get("valor").toString());
 
            String fecha = object.getJsonArray("serie").getJsonObject(29-i).get("fecha").toString();
            indica.setValor(a);
            indica.setFecha(fecha);
       
            
            }
    
    
      
    
    }
        return indica;
    } 
}
