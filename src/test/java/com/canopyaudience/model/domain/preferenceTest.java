/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.domain;

import java.util.Date;
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
            
        Date d1;
        d1 = new Date (2017, 00, 01, 23, 58,01);
        
        Date d2;
        d2 = new Date (2017, 00, 01, 23, 59,01);
            
        preference1 = new preference (67,1,d1,6,7,8675);    
        preference2 = new preference (68,0,d2,6,7,8675);
	}
        
    /**
     * Test of equals method, of class preference.
     */
    @Test
    public void testEqualspreference() {
        log.info("starting testEqualspreference()");
	assertFalse ("preference1 NOT equal preference2", preference1.equals(preference2));
        log.info(preference1.toString());
        log.info(preference2.toString());
	log.info ("testNOTEqualspreference PASSED");		
    }
    
}
