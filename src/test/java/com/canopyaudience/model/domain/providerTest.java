/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.domain;

import java.util.Random;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertFalse;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jason
 */
public class providerTest extends TestCase {
    
    public providerTest() {
    }

    private provider provider1, provider2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(providerTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        provider1 = new provider (12345, "jason.com");    
        provider2 = new provider (12346, "jason.com");
	}
        
    /**
     * Test of equals method, of class advertisement.
     */
    @Test
    public void testEqualsconsumer() {
        log.info("starting testEqualsconsumer()");
	assertFalse ("provider1 NOT equal provider2", provider1.equals(provider2));
	log.info ("testNOTEqualsconsumer PASSED");		
    }
    
}
