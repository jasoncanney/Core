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
public class preferenceTest extends TestCase {
    
    private preference preference1, preference2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(preferenceTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        preference1 = new preference (1, 2, 3, 4, 5, "01", "02", "03",1);    
        preference2 = new preference (1, 2, 3, 5, 6, "01", "02", "03",1);
	}
        
    /**
     * Test of validate method, of class preference.
     */
    @Test
    public void testValidatepreference1() {
        log.info("starting testValidatepreference1()");
	assertTrue ("preference validates", preference1.validate());
	log.info("testValidatepreference PASSED");
    }

    /**
     * Test of validate method, of class preference.
     */
    @Test
    public void testValidatepreference2() {
        log.info("starting testValidatepreference2()");
	assertTrue ("preference validates", preference2.validate());
	log.info("testValidatepreference PASSED");
    }
    
    /**
     * Test of equals method, of class preference.
     */
    @Test
    public void testEqualspreference() {
        log.info("starting testEqualspreference()");
	assertFalse ("preference1 NOT equal preference2", preference1.equals(preference2));
	log.info ("testNOTEqualspreference PASSED");		
    }
    
}
