/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class recommendationTest extends TestCase {
    
    private recommendation recommendation1, recommendation2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(recommendationTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
    @Override
	public void setUp() throws Exception {
            
        String date_1 = "2011-01-18 23:59:01.0"; 
        String date_2 = "2017-01-18 23:59:01.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
        Date d1 = dt.parse(date_1);
        Date d2 = dt.parse(date_2);

        recommendation1 = new recommendation(d1,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
        recommendation2 = new recommendation(d2,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
	}
        
    /**
     * Test of equals method, of class preference.
     */
    @Test
    public void testEqualsrecommendation() {
        log.info("starting testEqualsrecommendation()");
	assertFalse ("recommendation1 NOT equal recommendation2", recommendation1.equals(recommendation2));
        log.info(recommendation1.toString());
        log.info(recommendation2.toString());
	log.info ("testNOTEqualsrecommendation PASSED");		
    }
    
    
}
