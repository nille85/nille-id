/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.client;


import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public interface Client {
    
     String getId();
    
     Credentials getCredentials();

     String getRedirectURI();
     
     Document toDocument();

    

}
