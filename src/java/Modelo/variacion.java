/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;
import java.util.Scanner;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author LEARNING CENTER
 */
public class variacion {
    public static void main(String[] args) throws  IOException{
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indicador:");
        String indicador = teclado.next();
    URL url = new URL("https://mindicador.cl/api/"+indicador);
    InputStream is = url.openStream();
    JsonReader rdr = Json.createReader(is);
    JsonObject object = rdr.readObject();
    for(int i = 0; i <object.getJsonArray("serie").size(); i++){
        
        System.out.println("Valor"+(i+1)+":"+ object.getJsonArray("serie").getJsonObject(i).get("valor"));
        System.out.println(object.getJsonArray("serie").getJsonObject(i).getString("fecha"));
            }
    
    }
    
}
