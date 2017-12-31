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
public class interestTest extends TestCase {
    
    public interestTest() {
    }

   private interest interest1, interest2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(interestTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
    @Override
	public void setUp() throws Exception {
            
        long date_1 = System.currentTimeMillis(); 
        long date_2 = System.currentTimeMillis();

        interest1 = new interest(date_1,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
        interest2 = new interest(date_1,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
	}
        
    /**
     * Test of equals method, of class preference.
     */
    @Test
    public void testEqualsinterest() {
        log.info("starting testEqualsinterest()");
	assertTrue ("interest1 equal interest2", interest1.equals(interest2));
        log.info(interest1.toString());
        log.info(interest2.toString());
	log.info ("testEqualsinterest PASSED");		
    }
    
    
}
