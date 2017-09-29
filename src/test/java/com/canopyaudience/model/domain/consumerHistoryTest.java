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
public class consumerHistoryTest extends TestCase{
    
   private consumerHistory consumerHistory1, consumerHistory2;
   
   Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(consumerHistoryTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        consumerHistory1 = new consumerHistory (123, 01, "BMW", 01, 02, 03);    
        consumerHistory2 = new consumerHistory (124, 04, "BMW", 01, 02, 04);
	}
        
    /**
     * Test of validate method, of class advertisement.
     */
    @Test
    public void testValidateconsumerHistory1() {
        log.info("starting testValidateconsumerHistory1()");
	assertTrue ("consumerHistory validates", consumerHistory1.validate());
	log.info("testValidateconsumerHistory PASSED");
    }

    /**
     * Test of validate method, of class advertisement.
     */
    @Test
    public void testValidateconsumerHistory2() {
        log.info("starting testValidateconsumerHistory2()");
	assertTrue ("consumerHistory validates", consumerHistory2.validate());
	log.info("testValidateconsumerHistory PASSED");
    }
    
    /**
     * Test of equals method, of class advertisement.
     */
    @Test
    public void testEqualsconsumerHistory() {
        log.info("starting testEqualsconsumerHistory()");
	assertFalse ("consumerHistory1 NOT equal consumerHistory2", consumerHistory1.equals(consumerHistory2));
	log.info ("testNOTEqualsconsumerHistory PASSED");		
    }
    
}
