/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.configuration;

/**
 *
 * @author Niels Holvoet
 */
public class MongoDBConfigurationException extends RuntimeException{
    
    public MongoDBConfigurationException(final String message, final Throwable throwable){
        super(message, throwable);
    }
    
    public MongoDBConfigurationException(final String message){
        super(message);
    }
    
    
}
