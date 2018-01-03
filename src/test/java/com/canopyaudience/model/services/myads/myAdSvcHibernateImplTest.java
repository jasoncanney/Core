/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.myads;

// import static org.junit.Assert.*;

import com.canopyaudience.model.domain.myads;

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
public class myAdSvcHibernateImplTest extends TestCase{
    
    public myAdSvcHibernateImplTest() {
    }
    
       myads myads1, myads2, myads3;
    
    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
                myads1 = new myads (12345, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");    
                myads2 = new myads (1, 12345, 12354, "99", "02", "03","04","05",1235, "01", "02", "03","04","05");       
                myads3 = new myads (3, 12346, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");       

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(myAdSvcHibernateImplTest.class);
  
    
     /**
     * Test of test1StoremyAds method, of class myAdSvcHibernateImplTest.
     */
    @Test
    public void test1StoremyAds() {
    log.info ("myAdSvcHibernateImplTest - test1StoremyAds");
        myAdSvcHibernateImpl instance = new myAdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storemyAds(myads1);
        assertEquals(expResult, result);
    
    }
    
    /**
     * Test of test2GetAmyAds method, of class myAdSvcHibernateImplTest.
     * @throws java.lang.ClassNotFoundException
     *//*
    
    @Test
    public void test2GetAmyAds() throws myAdsException, ClassNotFoundException {
        log.info ("myAdSvcHibernateImplTest - test2GetAmyAds");
        myAdSvcHibernateImpl instance = new myAdSvcHibernateImpl();
        List<myads> c = instance.getAmyAds(myads1.getIDentifier());
        log.info(c.toString());
        int expResult = 1;
        assertEquals(expResult, myads1.getIDentifier());   
    }*/
    
    /**
     * Test of test3UpdatemyAds method, of class myAdSvcHibernateImplTest.
     *//*
    //@Test
    public void test3UpdatemyAds() {
    log.info ("myAdSvcHibernateImplTest - test3UpdatemyAds");
        myAdSvcHibernateImpl instance = new myAdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updatemyAds(myads2); // myads2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }*/
  
    /**
     * Test of test4DeletemyAds method, of class myAdSvcHibernateImplTest.
     *//*
    @Test
    public void test4DeletemyAds() {
    log.info ("myAdSvcHibernateImplTest - test4DeletemyAds");
        myAdSvcHibernateImpl instance = new myAdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deletemyAds(myads1);
        assertEquals(expResult, result); 

    }*/
    
}
