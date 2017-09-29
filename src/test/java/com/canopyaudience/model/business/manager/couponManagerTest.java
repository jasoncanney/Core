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
    coupon coupon3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		coupon1 = new coupon (86730, "1", "2", "3", "4", "5","6");                
                coupon2 = new coupon (86730, "1", "2", "3", "4", "5","6");             
                coupon3 = new coupon (86731, "1", "2", "3", "4", "5","6");           

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
     *//*
    @Test
    public void test2Get() throws Exception {
    }
*/
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
