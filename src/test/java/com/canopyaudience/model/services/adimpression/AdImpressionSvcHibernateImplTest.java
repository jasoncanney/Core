/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adimpression;

// import static org.junit.Assert.*;

import com.canopyaudience.model.domain.adimpression;

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
                // Factory factory = Factory.getInstance();
		adimpression1 = new adimpression (8675330,"Store", "OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","8","9","10","11","12","13","14","15","16","17");                
                adimpression2 = new adimpression (8675330,"Updated30", "OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","8","9","10","11","12","13","14","15","16","17");              
                adimpression3 = new adimpression (8675328,"Update", "OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender","8","9","10","11","12","13","14","15","16","17");              

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
     * Test of updateAdImpression method, of class AdImpressionSvcHibernateImpl.
     */
    @Test
    public void test2UpdateAdImpression() {
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
