/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.mongo;

import be.nille.oauth2.component.client.Client;
import be.nille.oauth2.component.client.mongo.MgClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Niels Holvoet
 */
public class MongoRepository<T> {

    private final MongoCollection collection;
    
    private final CollectionConfiguration<T> configuration;

    public MongoRepository(final CollectionConfiguration<T> configuration, final MongoCollection collection) {
        this.collection = collection;
        this.configuration = configuration;
    }

    public List<T> findAll() {
        return getEntries(collection.find());
    }

    public List<T> findAll(Bson filter) {
        return getEntries(collection.find(filter));
    }

    public Optional<T> findOne(final String uniqueId) {
        Bson filter = eq(configuration.getUniqueId(), uniqueId);
        List<T> entries = findAll(filter);
        if (entries != null && entries.size() > 0) {
            return Optional.of(entries.get(0));
        }
        return Optional.empty();
    }

    private List<T> getEntries(FindIterable iterable) {
        List<T> entries = new ArrayList<>();
        try (MongoCursor<Document> cursor = iterable.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                T entry = configuration.map(document);
                entries.add(entry);
            }
        }
        return entries;
    }
       

    public void add(final Client client) {
        Client mgClient = new MgClient(client);
        collection.insertOne(mgClient.toDocument());
    }

    public void update(final T entry) {
        Bson filter = configuration.getUniqueFilter(entry);
        Document document = configuration.toDocument(entry);
        collection.updateOne(filter, document);
    }

    public void remove(final T entry) {
        Bson filter = configuration.getUniqueFilter(entry);
        collection.deleteOne(filter);
    }
    
   
    
    

}
