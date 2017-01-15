/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.client.mongo;

import be.nille.oauth2.mongo.CollectionConfiguration;
import be.nille.oauth2.component.client.BaseClient;
import be.nille.oauth2.component.client.Client;
import be.nille.oauth2.component.client.Credentials;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Niels Holvoet
 */
public class ClientCollectionConfiguration implements CollectionConfiguration<Client> {

    private final String uniqueId;
    
    public ClientCollectionConfiguration(final String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public Client map(Document document) {
        return new MgClient(new BaseClient(
                new Credentials(document.getString("clientId"), document.getString("clientSecret")),
                document.getString("redirectURI")
        ));
    }

    @Override
    public Document toDocument(Client client) {
        Client mgClient = new MgClient(client);
        return mgClient.toDocument();
    }

    @Override
    public Bson getUniqueFilter(Client client) {
        return eq("clientId", client.getCredentials().getId());
    }

    @Override
    public String getUniqueId() {
        return uniqueId;
    }
    

}
