/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
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
public class NewClass {
    public double rescate(String nombre) {
        int uf, ivp,dolar,dolarIntercambio,euro,ipc,utm,imasec,tpm,libreCobre,tasaDesempleo,bitcoin;
        String  uf1, ivp1,dolar1,dolarIntercambio1,euro1,ipc1,utm1,imasec1,tpm1,libreCobre1,tasaDesempleo1,bitcoin1;
        //int valor=0;
        try {
            URL url = new URL ("http://mindicador.cl/api");
            InputStream entrada = url.openStream();
            JsonReader reader = Json.createReader(entrada);
            JsonObject object = reader.readObject();
            double valor=(object.getJsonObject(nombre).getJsonNumber("valor").doubleValue());
            return(valor);
        } catch (MalformedURLException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
}
