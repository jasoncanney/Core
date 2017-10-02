/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.couponservice;

import com.canopyaudience.model.domain.coupon;
import com.canopyaudience.model.services.exception.CouponException;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
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
public class CouponSvcHibernateImplTest extends TestCase{
    
    public CouponSvcHibernateImplTest() {
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
        static Logger log = Logger.getLogger(CouponSvcHibernateImplTest.class);
    
    /**
     * Test of storeCoupon method, of class CouponSvcHibernateImpl.
     */
    @Test
    public void test1StoreCoupon() {
        log.info ("CouponSvcHibernateImplTest - test1StoreCoupon");
        CouponSvcHibernateImpl instance = new CouponSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeCoupon(coupon1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getaCoupon method, of class CouponSvcHibernateImpl.
     */
    @Test
    public void test2GetACoupon() throws CouponException, ClassNotFoundException {
        log.info ("CouponSvcHibernateImplTest - test2GetACoupon");
        CouponSvcHibernateImpl instance = new CouponSvcHibernateImpl();
        coupon c = new coupon();
        c = instance.getACoupon(coupon1.getCouponID());
        assertEquals(c.getCouponID(), coupon1.getCouponID());   
    }
    
    /**
     * Test of updateCoupon method, of class CouponSvcHibernateImpl.
     */
    @Test
    public void test3UpdateCoupon() {
        log.info ("CouponSvcHibernateImplTest - test3UpdateCoupon");
        CouponSvcHibernateImpl instance = new CouponSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateCoupon(coupon2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
        
    }

    /**
     * Test of deleteCoupon method, of class CouponSvcHibernateImpl.
     */
    @Test
    public void test4DeleteCoupon() {
        log.info ("CouponSvcHibernateImplTest - test4DeleteCoupon");
        CouponSvcHibernateImpl instance = new CouponSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteCoupon(coupon1);
        assertEquals(expResult, result); 
        
    }
    
}
