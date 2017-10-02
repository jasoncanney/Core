/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

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
public class adImpManagerTest extends TestCase{
    
    public adImpManagerTest() {
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
     */
    @Test
    public void test2AdImpManagerCreateGetA() throws Exception {
        log.info ("adImpManagerTest - test2AdImpManagerCreateGetA");
        adImpManager instance = new adImpManager();
        adimpression c = instance.GetA(adimpression1.getConsumerID());
        assertEquals(c.getConsumerID(), adimpression1.getConsumerID());   
    }
    
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
