/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import java.io.File;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service to communicate with the frontend
 * @author giesler
 */
@Path("instructions")
public class Instruction {
    
    
    @Context
    private UriInfo context;

    
    public Instruction() {
    }

    /**
     * PUT Method to handle incoming Messages from the Frontend
     * @param step
     * @throws org.eclipse.paho.client.mqttv3.MqttException
     */
    @PUT
    public void putHtml(@QueryParam("step") String step) throws MqttException{
        
        //Initial message um Error in der Referenz zu vermeiden
        String message = "Aloha";
        message = step;
        
        //Ausgabe um publishen zu testen, ---remove---
        Publisher.publish(message, "/smw/backend/40:A3:CC:98:91:17/pir/" );
        
        
        //Initialisieren der Montage der Zahnbuerste
        //Das Werkstück Zahnbuerste wird aktiv gesetzt
        if("Zahnbuerste".equals(message)){
                ZahnbuersteMontage zbm = new ZahnbuersteMontage();
                ActiveWorkpiece.zbactive = true;
                ActiveWorkpiece.szactive = false;
        }       
        
        //Initialisieren der Montage der Schraubzwinge
        //Das Werkstück Schraubzwinge wird aktiv gesetzt
        if("Schraubzwinge".equals(message)){
                SchraubzwingeMontage szm = new SchraubzwingeMontage();
                ActiveWorkpiece.zbactive = false;
                ActiveWorkpiece.szactive = true;

        }
        
        //Falls vom Frontend nextStep gesendet wird 
        //muss unterschieden werden für welches Werkstück der nächste Schritt ausgeführt wird
        //dazu wird geprüft welche Montage derzeit aktiv ist
        if("nextStep".equals(message)){
            if(ActiveWorkpiece.zbactive){
                ZahnbuersteMontage.nextStep();
            }
            if(ActiveWorkpiece.szactive){
                SchraubzwingeMontage.nextStep();
            }
        }
        
        //Hilfsausgaben ---remove---
        System.out.println(ActiveWorkpiece.zbactive);
        System.out.println(ActiveWorkpiece.szactive);

    }
    

            
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public String getJSON(){
       BuildJSON json_file = new BuildJSON();
       String json_string = json_file.initJSON();
       
       return json_string;
   }
}
