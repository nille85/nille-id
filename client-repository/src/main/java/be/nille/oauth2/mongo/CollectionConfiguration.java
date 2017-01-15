/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.mongo;

import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author Niels Holvoet
 */
public interface CollectionConfiguration<T> {

    T map(Document document); 

    Document toDocument(T entry) ;

    Bson getUniqueFilter(T entry);

    String getUniqueId();

}
