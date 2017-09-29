/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import static com.canopyaudience.model.business.manager.adManagerTest.log;
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
public class consumerHistoryManagerTest extends TestCase{
    
    public consumerHistoryManagerTest() {
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
        static Logger log = Logger.getLogger(consumerHistoryManagerTest.class);

    /**
     * Test of Create method, of class consumerHistoryManager.
     */
    @Test
    public void test1Create() {
        log.info ("consumerHistoryManagerTest - test1Create");
        consumerHistoryManager instance = new consumerHistoryManager();
        boolean expResult = true;
        boolean result = instance.Create(consumerHistory1);
        assertEquals(expResult, result);   
        
    }

    /**
     * Test of Get method, of class consumerHistoryManager.
     *//*
    @Test
    public void test2Get() throws Exception {
    }
*/
    /**
     * Test of Update method, of class consumerHistoryManager.
     */
    @Test
    public void test3Update() {
        log.info ("consumerHistoryManagerTest - test3Update");
        consumerHistoryManager instance = new consumerHistoryManager();
        boolean expResult = true;
        boolean result = instance.Update(consumerHistory2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class consumerHistoryManager.
     */
    @Test
    public void test4Delete() {
        log.info ("consumerHistoryManagerTest - test4Delete");
        consumerHistoryManager instance = new consumerHistoryManager();
        boolean expResult = true;
        boolean result = instance.Delete(consumerHistory1);
        assertEquals(expResult, result);  
    }
    
}
