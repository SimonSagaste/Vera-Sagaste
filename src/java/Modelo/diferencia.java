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
public class diferencia {
    public ArrayList diferencias(String indicador) throws  IOException{
     ArrayList <indicador> list = new ArrayList<>();
    URL url = new URL("https://mindicador.cl/api/"+indicador);
    InputStream is = url.openStream();
    JsonReader rdr = Json.createReader(is);
    JsonObject object = rdr.readObject();
    for(int i = 0; i <30; i++){
            indicador indica = new indicador();
            Double a = Double.parseDouble(object.getJsonArray("serie").getJsonObject(31-i).get("valor").toString());
            Double b = Double.parseDouble(object.getJsonArray("serie").getJsonObject(30-i).get("valor").toString());
            String fecha = object.getJsonArray("serie").getJsonObject(i).getString("fecha");
            indica.setValor(b-a);
            indica.setFecha(fecha);
            list.add(indica);
            
            }
        return list;
    
    }
    
}
