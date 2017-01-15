/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.nille.oauth2.component.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Niels Holvoet
 */
public class MongoDBConfigurationTest {

    private MongoDBConfiguration configuration;

    @Before
    public void setup() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("mongodb.properties");
        configuration = new MongoDBConfiguration(is);
    }

    @Test
    public void getUser() throws Exception {

        assertEquals("user", configuration.getUser());
    }

    @Test
    public void getHost() throws Exception {

        assertEquals("fake.com", configuration.getHost());
    }

    @Test
    public void getPort() throws Exception {

        assertEquals("11", configuration.getPort());
    }

    @Test
    public void getPassword() throws Exception {

        assertEquals("pwd", configuration.getPassword());
    }

    @Test
    public void getDatabase() throws Exception {

        assertEquals("dbname", configuration.getDatabase());
    }
    
    @Test(expected = MongoDBConfigurationException.class)
    public void inputstreamIsEmpty(){
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("notexisting.properties");
        configuration = new MongoDBConfiguration(is);
    }
    
    

}
