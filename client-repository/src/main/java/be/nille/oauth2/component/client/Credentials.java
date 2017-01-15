/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.client;

/**
 *
 * @author Niels Holvoet
 */
public class Credentials {

    private final String id;
    private final String secret;

    public Credentials(final String id, final String secret) {
        this.id = id;
        this.secret = secret;
    }

    public String getId() {
        return id;
    }

    public String getSecret() {
        return secret;
    }
}
