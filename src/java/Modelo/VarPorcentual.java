/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author simon
 */
public class VarPorcentual {
    ArrayList<indicador> listado;
    public ArrayList<indicador> Porcentaje(String nombre) {
        indicador indicador = new indicador();
        listado = new ArrayList();
        try {
//            Scanner teclado = new Scanner(System.in);
            System.out.println("Indicador:"+nombre);
//            String indicador = teclado.next();
            URL url = new URL("https://mindicador.cl/api/"+nombre);
            InputStream is = url.openStream();
            JsonReader rdr = Json.createReader(is);
            JsonObject object = rdr.readObject();
            for(int i = 0; i <object.getJsonArray("serie").size(); i++){
                
                indicador.setValor(Double.parseDouble("Valor"+(i+1)+":"+ object.getJsonArray("serie").getJsonObject(i).get("valor")));
                indicador.setFecha(object.getJsonArray("serie").getJsonObject(i).getString("fecha"));
                indicador.setNombre(nombre);
                listado.add(indicador);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(VarPorcentual.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(VarPorcentual.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
}
