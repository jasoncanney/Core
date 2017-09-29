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
public class couponTest extends TestCase{
    
    private coupon coupon1, coupon2;
     
     Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(couponTest.class);
        
	/**
	 * @throws java.lang.Exception
	 */
	@Before	
	public void setUp() throws Exception {

        coupon1 = new coupon (12345, "01", "02", "03","04","05","06");    
        coupon2 = new coupon (12346, "01", "02", "03","04","05","06");
	}
        
    /**
     * Test of validate method, of class coupon.
     */
    @Test
    public void testValidatecoupon1() {
        log.info("starting testValidatecoupon1()");
	assertTrue ("coupon validates", coupon1.validate());
	log.info("testValidatecoupon PASSED");
    }

    /**
     * Test of validate method, of class coupon.
     */
    @Test
    public void testValidatecoupon2() {
        log.info("starting testValidatecoupon2()");
	assertTrue ("coupon validates", coupon2.validate());
	log.info("testValidatecoupon PASSED");
    }
    
    /**
     * Test of equals method, of class coupon.
     */
    @Test
    public void testEqualscoupon() {
        log.info("starting testEqualscoupon()");
	assertFalse ("coupon1 NOT equal coupon2", coupon1.equals(coupon2));
	log.info ("testNOTEqualscoupon PASSED");		
    }
    
}
