/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.domain;

import junit.framework.TestCase;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;
import org.apache.log4j.Logger;

/**
 *
 * @author jason
 */
public class consumerTest extends TestCase {
    
     private consumer consumer1, consumer2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(consumerTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        consumer1 = new consumer (12345, "01", "02", "03","04","05","06","07","08","09","10");    
        consumer2 = new consumer (12346, "01", "02", "03","04","05","06","07","08","09","10");
	}
        
    /**
     * Test of validate method, of class consumer.
     */
    @Test
    public void testValidateconsumer1() {
        log.info("starting testValidateconsumer1()");
	assertTrue ("consumer validates", consumer1.validate());
	log.info("testValidateconsumer PASSED");
    }

    /**
     * Test of validate method, of class consumer.
     */
    @Test
    public void testValidateconsumer2() {
        log.info("starting testValidateconsumer2()");
	assertTrue ("consumer validates", consumer2.validate());
	log.info("testValidateconsumer PASSED");
    }
    
    /**
     * Test of equals method, of class advertisement.
     */
    @Test
    public void testEqualsconsumer() {
        log.info("starting testEqualsconsumer()");
	assertFalse ("consumer1 NOT equal consumer2", consumer1.equals(consumer2));
	log.info ("testNOTEqualsconsumer PASSED");		
    }
    
}
