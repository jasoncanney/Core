/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.provider;
import junit.framework.TestCase;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Jason
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class providerManagerTest extends TestCase{
    
    public providerManagerTest() {
    }

    provider provider1;
    provider provider2;
    provider provider3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		provider1 = new provider (86730, "1");                
                provider2 = new provider (86730, "1");             
                provider3 = new provider (86731, "1");           

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(providerManagerTest.class);
    
    /**
     * Test of Create method, of class consumerManager.
     */
    @Test
    public void test1Create() {
        log.info ("providerManagerTest - test1Create");
        providerManager instance = new providerManager();
        boolean expResult = true;
        boolean result = instance.Create(provider1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of Get method, of class consumerManager.
     */
    @Test
    public void test2GetA() throws Exception {
        log.info ("providerManagerTest - test2GetA");
        providerManager instance = new providerManager();
        provider c = instance.GetA(provider1.getProviderID());
        assertEquals(c.getProviderID(), provider1.getProviderID());   
    }
    
    /**
     * Test of Update method, of class consumerManager.
     */
    @Test
    public void test3Update() {
         log.info ("providerManagerTest - test3Update");
        providerManager instance = new providerManager();
        boolean expResult = true;
        boolean result = instance.Update(provider1);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class consumerManager.
     */
    @Test
    public void test4Delete() {
        log.info ("providerManagerTest - test4Delete");
        providerManager instance = new providerManager();
        boolean expResult = true;
        boolean result = instance.Delete(provider1);
        assertEquals(expResult, result);  
    }
    
}
