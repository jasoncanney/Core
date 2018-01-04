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
public class advertisementTest extends TestCase {
    

        private advertisement advertisement1, advertisement2;
        Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(advertisementTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
        @Override
	public void setUp() throws Exception {

        advertisement1 = new advertisement (12345, "BMW Fall Sales Event", 01, 02, 03, 04, "Fall Sales Event", "BMW","BMW","123","www.bmw.com","7234A");    
        advertisement2 = new advertisement (12346, "BMW Spring Sales Event", 01, 02, 03, 04, "Spring Sales Event", "BMW","BMW","123","www.bmw.com","7234A");
	
        }
        
        /**
         * Test of equals method, of class advertisement.
         */
        @Test
        public void testNOTEqualsadvertisement() {
            log.info("starting testEqualsadvertisement()");
            assertFalse ("advertisement1 NOT equal advertisement2", advertisement1.equals(advertisement2));
            log.info ("testNOTEqualsadvertisement PASSED");		
        }
   }

