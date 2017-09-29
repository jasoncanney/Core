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
public class myadsTest extends TestCase {
    
   private myads myads1, myads2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(myadsTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        myads1 = new myads (12345, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");    
        myads2 = new myads (12346, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");
	}
        
    /**
     * Test of validate method, of class myads.
     */
    @Test
    public void testValidatemyads1() {
        log.info("starting testValidatemyads1()");
	assertTrue ("myads validates", myads1.validate());
	log.info("testValidatemyads PASSED");
    }

    /**
     * Test of validate method, of class myads.
     */
    @Test
    public void testValidatemyads2() {
        log.info("starting testValidatemyads2()");
	assertTrue ("myads validates", myads2.validate());
	log.info("testValidatemyads PASSED");
    }
    
    /**
     * Test of equals method, of class myads.
     */
    @Test
    public void testEqualsmyads() {
        log.info("starting testEqualsmyads()");
	assertFalse ("myads1 NOT equal myads2", myads1.equals(myads2));
	log.info ("testNOTEqualsmyads PASSED");		
    }
     
}
