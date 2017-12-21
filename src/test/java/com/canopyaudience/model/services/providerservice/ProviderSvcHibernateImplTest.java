/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.providerservice;

import com.canopyaudience.model.domain.consumer;
import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.services.consumerservice.ConsumerSvcHibernateImpl;
import com.canopyaudience.model.services.consumerservice.ConsumerSvcHibernateImplTest;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Jason
 */
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
                provider2 = new provider (86730, "1");             
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
     * Test of getaConsumer method, of class ConsumerSvcHibernateImpl.
     *//*
    @Test
    public void test2GetAConsumer() throws ConsumerException, ClassNotFoundException {
        log.info ("ConsumerSvcHibernateImplTest - test2GetAConsumer");
        ConsumerSvcHibernateImpl instance = new ConsumerSvcHibernateImpl();
        boolean expResult = true;
        consumer c = new consumer();
        c = instance.getAConsumer(consumer1.getConsumerID());
        assertEquals(consumer1.getConsumerID(), c.getConsumerID());   
    } */
    /**
     * Test of updateConsumer method, of class ConsumerSvcHibernateImpl.
     */
    @Test
    public void test3UpdateProvider() {
          log.info ("ProviderSvcHibernateImplTest - test3UpdateProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateProvider(provider1);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }

    /**
     * Test of deleteConsumer method, of class ConsumerSvcHibernateImpl.
     */
    @Test
    public void test4DeleteProvider() {
        log.info ("ProviderSvcHibernateImplTest - test4DeleteProvider");
        ProviderSvcHibernateImpl instance = new ProviderSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteProvider(provider1);
        assertEquals(expResult, result); 
    }
    
}
