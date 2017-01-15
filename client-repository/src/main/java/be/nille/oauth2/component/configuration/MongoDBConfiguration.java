/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Niels Holvoet
 */
public class MongoDBConfiguration {

    private final Properties properties;

    public MongoDBConfiguration(final InputStream inputStream) {
        if (inputStream != null) {
            try {
                this.properties = new Properties();
                properties.load(inputStream);
            } catch (IOException ex) {
                throw new MongoDBConfigurationException("Could not load properties file from file system", ex);
            }
        } else {
            throw new MongoDBConfigurationException("The provided inputStream is null");
        }

    }

    public String getUser() {
        return properties.getProperty("mongodb.user");
    }

    public String getPassword() {
        return properties.getProperty("mongodb.password");
    }

    public String getHost() {
        return properties.getProperty("mongodb.host");
    }

    public String getPort() {
        return properties.getProperty("mongodb.port");
    }

    public String getDatabase() {
        return properties.getProperty("mongodb.database");
    }

}
