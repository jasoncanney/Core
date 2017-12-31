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
            
        long date_1 = System.currentTimeMillis(); 
        long date_2 = System.currentTimeMillis();
        // SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
        // Date d1 = dt.parse(date_1);
        // Date d2 = dt.parse(date_2);
            
        preference1 = new preference (67,1,date_1,6,7,8675);    
        preference2 = new preference (68,0,date_2,6,7,8675);
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
