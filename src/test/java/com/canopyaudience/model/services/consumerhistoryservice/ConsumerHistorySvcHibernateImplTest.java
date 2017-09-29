/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.consumerhistoryservice;

import com.canopyaudience.model.domain.consumerHistory;
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
public class ConsumerHistorySvcHibernateImplTest extends TestCase{
   
    public ConsumerHistorySvcHibernateImplTest() {
    }
    
    consumerHistory consumerHistory1;
    consumerHistory consumerHistory2;
    consumerHistory consumerHistory3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		consumerHistory1 = new consumerHistory (86730, 12345, "Store", 1, 2, 3);                
                consumerHistory2 = new consumerHistory (86730, 34567, "Updated30", 1,2,3);              
                consumerHistory3 = new consumerHistory (86712, 4567, "Update", 1,2,3);              

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(ConsumerHistorySvcHibernateImplTest.class);
   
    /**
     * Test of storeConsumerHistory method, of class ConsumerHistorySvcHibernateImpl.
     */
    @Test
    public void test1StoreConsumerHistory() {
        log.info ("ConsumerHistorySvcHibernateImplTest - test1StoreConsumerHistory");
        ConsumerHistorySvcHibernateImpl instance = new ConsumerHistorySvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeConsumerHistory(consumerHistory1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getConsumerHistory method, of class ConsumerHistorySvcHibernateImpl.
     *//*
    @Test
    public void test2GetConsumerHistory() throws Exception {
    }
*/
    /**
     * Test of updateConsumerHistory method, of class ConsumerHistorySvcHibernateImpl.
     */
    @Test
    public void test3UpdateConsumerHistory() {
        log.info ("ConsumerHistorySvcHibernateImplTest - test3UpdateConsumerHistory");
        ConsumerHistorySvcHibernateImpl instance = new ConsumerHistorySvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateConsumerHistory(consumerHistory2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }

    /**
     * Test of deleteConsumerHistory method, of class ConsumerHistorySvcHibernateImpl.
     */
    @Test
    public void test4DeleteConsumerHistory() {
        log.info ("ConsumerHistorySvcHibernateImplTest - test4DeleteConsumerHistory");
        ConsumerHistorySvcHibernateImpl instance = new ConsumerHistorySvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteConsumerHistory(consumerHistory1);
        assertEquals(expResult, result); 
        
    }
    
}
