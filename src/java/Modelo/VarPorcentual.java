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
import java.util.Calendar;
import java.util.Date;
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
    public double rescate(String nombre) {
        Calendar fecha;
        try {
            URL url = new URL ("http://mindicador.cl/api/"+nombre+"/"+fecha);
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonObject object = reader.readObject();
            double valor=(object.getJsonObject(nombre).getJsonNumber("valor").doubleValue());
            return(valor);
        } catch (MalformedURLException ex) {
            Logger.getLogger(VarPorcentual.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(VarPorcentual.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
