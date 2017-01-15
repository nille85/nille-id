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
public class BaseClient implements Client {
    
    
    private final Credentials credentials;
    private final String redirectURI;
    
    public BaseClient(final Credentials credentials, final String redirectURI){
        this.credentials = credentials;
        this.redirectURI = redirectURI;
    }
    

    @Override
    public Credentials getCredentials() {
        return credentials;
    }

    @Override
    public String getRedirectURI() {
        return redirectURI;
    }

    @Override
    public Document toDocument() {
        throw new UnsupportedOperationException("Document is not yet available because client was not saved yet"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Id is not yet available because entry was not saved yet"); //To change body of generated methods, choose Tools | Templates.
    }

}
