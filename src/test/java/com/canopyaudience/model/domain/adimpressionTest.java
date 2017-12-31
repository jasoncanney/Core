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
import org.junit.Before;

/**
 *
 * @author Jason
 */
public class adimpressionTest extends TestCase {
    
    private adimpression adimpression1, adimpression2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(adimpressionTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
    @Override
	public void setUp() throws Exception {
            
        long date_1 = System.currentTimeMillis(); 
        long date_2 = System.currentTimeMillis();

        adimpression1 = new adimpression(8675309,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,date_1,date_2,1,"80126");
        adimpression2 = new adimpression(8675310,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,date_1,date_2,1,"80126");
	}
        
    /**
     * Test of equals method, of class preference.
     */
    @Test
    public void testEqualsadimpression() {
        log.info("starting testEqualsadimpression()");
	assertFalse ("adimpression1 NOT equal adimpression2", adimpression1.equals(adimpression2));
        log.info(adimpression1.toString());
        log.info(adimpression2.toString());
	log.info ("testNOTEqualsadimpression PASSED");		
    }
    
}
