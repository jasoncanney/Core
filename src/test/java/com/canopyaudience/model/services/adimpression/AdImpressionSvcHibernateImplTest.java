/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adimpression;

// import static org.junit.Assert.*;

import com.canopyaudience.model.domain.adimpression;
import java.util.Date;

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
public class AdImpressionSvcHibernateImplTest extends TestCase{
    
    public AdImpressionSvcHibernateImplTest() {
    }
    
    adimpression adimpression1;
    adimpression adimpression2;
    adimpression adimpression3;

    
    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                Date d1;
        d1 = new Date (2017, 00, 01, 23, 58,01);
        
        Date d2;
        d2 = new Date (2017, 00, 01, 23, 59,01);

        adimpression1 = new adimpression(8675309,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,d1,d2,1,"80126");
        adimpression2 = new adimpression(8675310,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,d1,d2,1,"80126");
        adimpression3 = new adimpression(8675311,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,d1,d2,1,"80126");


        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(AdImpressionSvcHibernateImplTest.class);
  
    /**
     * Test of getAdImpression method, of class AdImpressionSvcHibernateImpl.
     *//*
    @Test
    public void testGetAdImpression() throws Exception {
    }
*/ 
        /**
     * Test of storeAdImpression method, of class AdImpressionSvcHibernateImpl.
     */
    @Test
    public void test1StoreAdImpression() {
    log.info ("AdImpressionSvcHibernateImplTest - testStoreAdImpression");
        AdImpressionSvcHibernateImpl instance = new AdImpressionSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeAdImpression(adimpression1);
        assertEquals(expResult, result);
    
    }
    
    /**
     * Test of getaConsumer method, of class AdImpressionSvcHibernateImpl.
     */ /*
    @Test
    public void test2GetAAdImpression() throws AdImpressionException, ClassNotFoundException {
        log.info ("AdImpressionSvcHibernateImplTest - test2GetAAdImpression");
        AdImpressionSvcHibernateImpl instance = new AdImpressionSvcHibernateImpl();
        adimpression c = new adimpression();
        c = instance.getAAdImpression(adimpression1.getConsumerID());
        assertEquals(c.getConsumerID(), adimpression1.getConsumerID());   
    }
    */
    /**
     * Test of updateAdImpression method, of class AdImpressionSvcHibernateImpl.
     */
    @Test
    public void test3UpdateAdImpression() {
    log.info ("AdImpressionSvcHibernateImplTest - testUpdateAdImpression");
        AdImpressionSvcHibernateImpl instance = new AdImpressionSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateAdImpression(adimpression2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }
  
    /**
     * Test of deleteAdImpression method, of class AdImpressionSvcHibernateImpl.
     */
    @Test
    public void test3DeleteAdImpression() {
    log.info ("AdImpressionSvcHibernateImplTest - testDeleteAdImpression");
        AdImpressionSvcHibernateImpl instance = new AdImpressionSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteAdImpression(adimpression1);
        assertEquals(expResult, result); 

    }
    
}
