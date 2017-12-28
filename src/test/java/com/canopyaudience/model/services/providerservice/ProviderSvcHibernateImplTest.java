/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.providerservice;

import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.services.exception.ProviderException;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
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
public class ProviderSvcHibernateImplTest extends TestCase{
    
    public ProviderSvcHibernateImplTest() {
    }

    provider provider1;
    provider provider2;
    provider provider3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		provider1 = new provider (86730, "1");                
                provider2 = new provider (54,86730, "1");             
                provider3 = new provider (86731, "1");           

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(ProviderSvcHibernateImplTest.class);
    
    
    
    /**
     * Test of test1StoreProvider method, of class ProviderSvcHibernateImpl.
     */
    @Test
    public void test1StoreProvider() {
        log.info ("ProviderSvcHibernateImplTest - test1StoreProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeProvider(provider1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getaProvider method, of class ProviderSvcHibernateImpl.
     *//*
    @Test
    public void test2GetAProvider() throws ProviderException, ClassNotFoundException {
        log.info ("ProviderSvcHibernateImplTest - test2GetAProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        // boolean expResult = true;
        provider c = new provider();
        c = instance.getAProvider(provider1.getProviderID());
        provider3 = c;
        log.info (c.toString());
        assertEquals(provider1.getProviderID(), c.getProviderID());   
    }*/
    
    /**
     * Test of updateConsumer method, of class ConsumerSvcHibernateImpl.
     *//*
    @Test
    public void test3UpdateProvider() {
          log.info ("ProviderSvcHibernateImplTest - test3UpdateProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateProvider(provider1);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }*/

    /**
     * Test of deleteConsumer method, of class ConsumerSvcHibernateImpl.
     *//*
    @Test
    public void test4DeleteProvider() {
        log.info ("ProviderSvcHibernateImplTest - test4DeleteProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteProvider(provider2);
        assertEquals(expResult, result); 
    }*/
    
}
