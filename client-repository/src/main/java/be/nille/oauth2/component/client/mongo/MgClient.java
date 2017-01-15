/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.client.mongo;

import be.nille.oauth2.component.client.Client;
import be.nille.oauth2.component.client.Credentials;
import org.bson.Document;

/**
 *
 * @author Niels Holvoet
 */
public class MgClient implements Client {

    private final Client origin;
    private final Document document;

    public MgClient(final Client origin) {
        this.origin = origin;
        this.document = new Document();
    }

    @Override
    public Credentials getCredentials() {
        return this.origin.getCredentials();
    }

    @Override
    public String getRedirectURI() {
        return this.origin.getRedirectURI();
    }

    @Override
    public Document toDocument() {
        return document.append("clientId", this.getCredentials().getId())
                .append("clientSecret", this.getCredentials().getSecret())
                .append("redirectURI", this.getRedirectURI());
    }

    @Override
    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
