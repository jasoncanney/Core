/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import static com.canopyaudience.model.business.manager.adManagerTest.log;
import com.canopyaudience.model.domain.coupon;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Jason
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class couponManagerTest extends TestCase{
    
    public couponManagerTest() {
    }
    
    coupon coupon1;
    coupon coupon2;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		coupon1 = new coupon(1,"twitter","twitter","10%","1/1/18","12/31/18","all","http://www.bentonjohnbjr.com","x5324",1);
                coupon2 = new coupon(19,"Coach","Coach","2%","1/1/18","12/31/18","all","http://www.farmersinsurancegroup.com","x5324",19);
        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(couponManagerTest.class);
    

    /**
     * Test of Create method, of class couponManager.
     */
    @Test
    public void test1Create() {
        log.info ("couponManagerTest - test1Create");
        couponManager instance = new couponManager();
        boolean expResult = true;
        boolean result = instance.Create(coupon1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of Get method, of class couponManager.
     */
    @Test
    public void test2GetA() throws Exception {
        log.info ("couponManagerTest - test2GetA");
        couponManager instance = new couponManager();
        coupon c = instance.GetA(coupon1.getCouponID());
        assertEquals(c.getCouponID(), coupon1.getCouponID());   
    }
    /**
     * Test of Update method, of class couponManager.
     */
    @Test
    public void test3Update() {
        log.info ("couponManagerTest - test3Update");
        couponManager instance = new couponManager();
        boolean expResult = true;
        boolean result = instance.Update(coupon2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class couponManager.
     */
    @Test
    public void test4Delete() {
        log.info ("couponManagerTest - test4Delete");
        couponManager instance = new couponManager();
        boolean expResult = true;
        boolean result = instance.Delete(coupon1);
        assertEquals(expResult, result);  
    }
    
}
