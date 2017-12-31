/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

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
public class adImpManagerTest extends TestCase{
    
    public adImpManagerTest() {
    }

    adimpression adimpression1;
    adimpression adimpression2;
    adimpression adimpression3;

    
    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
        long date_1 = System.currentTimeMillis(); 
        long date_2 = System.currentTimeMillis();

        adimpression1 = new adimpression(8675309,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,date_1,date_2,1,"80126");
        adimpression2 = new adimpression(8675310,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,date_1,date_2,1,"80126");
        adimpression3 = new adimpression(8675311,1234598,6006,78943,"1239878xx98",1,1,31,"2004","123xwe4",87685,123987,date_1,date_2,1,"80126");

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(adImpManagerTest.class);
    
    
    
    /**
     * Test of Create method, of class adImpManager.
     */
    @Test
    public void test1AdImpManagerCreate() {
        
        log.info ("test1AdImpManagerCreate - testStoreAdImpression");
        adImpManager instance = new adImpManager();
        boolean expResult = true;
        boolean result = instance.Create(adimpression1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of Get method, of class adImpManager.
     *//*
    @Test
    public void test2AdImpManagerCreateGetA() throws Exception {
        log.info ("adImpManagerTest - test2AdImpManagerCreateGetA");
        adImpManager instance = new adImpManager();
        adimpression c = instance.GetA(adimpression1.getConsumerID());
        assertEquals(c.getConsumerID(), adimpression1.getConsumerID());   
    }*/
    
    /**
     * Test of Update method, of class adImpManager.
     */
    @Test
    public void test3AdImpManagerUpdate() {
         log.info ("test3AdImpManagerUpdate - testUpdateAdImpression");
        adImpManager instance = new adImpManager();
        boolean expResult = true;
        boolean result = instance.Update(adimpression2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }

    /**
     * Test of Delete method, of class adImpManager.
     */
    @Test
    public void test4AdImpManagerDelete() {
        log.info ("test4AdImpManagerDelete - testDeleteAdImpression");
        adImpManager instance = new adImpManager();
        boolean expResult = true;
        boolean result = instance.Delete(adimpression1);
        assertEquals(expResult, result); 
    }
    
}
