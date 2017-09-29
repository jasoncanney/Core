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
public class loginTest extends TestCase {
    
    private login login1, login2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(loginTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        login1 = new login ("01", "02");    
        login2 = new login ("02", "02");
	}
        
    /**
     * Test of validate method, of class login.
     */
    @Test
    public void testValidatelogin1() {
        log.info("starting testValidatelogin1()");
	assertTrue ("login validates", login1.validate());
	log.info("testValidatelogin PASSED");
    }

    /**
     * Test of validate method, of class login.
     */
    @Test
    public void testValidatelogin2() {
        log.info("starting testValidatelogin2()");
	assertTrue ("login validates", login2.validate());
	log.info("testValidatelogin PASSED");
    }
    
    /**
     * Test of equals method, of class login.
     */
    @Test
    public void testEqualslogin() {
        log.info("starting testEqualslogin()");
	assertFalse ("login1 NOT equal login2", login1.equals(login2));
	log.info ("testNOTEqualslogin PASSED");		
    }
    
}
