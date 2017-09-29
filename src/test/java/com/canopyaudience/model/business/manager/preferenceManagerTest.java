/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import static com.canopyaudience.model.business.manager.adManagerTest.log;
import com.canopyaudience.model.domain.preference;
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
public class preferenceManagerTest extends TestCase{
    
    public preferenceManagerTest() {
    }

    preference preference1;
    preference preference2;
    preference preference3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		preference1 = new preference (50,2,3,4,5,"1", "2", "3", 1);                
                preference2 = new preference (50,1,3,4,5,"1", "2", "3", 1);            
                preference3 = new preference (51,2,3,4,5,"1", "2", "3", 1);            

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(preferenceManagerTest.class);
        
    /**
     * Test of Create method, of class preferenceManager.
     */
    @Test
    public void test1Create() {
        log.info ("preferenceManagerTest - test1Create");
        preferenceManager instance = new preferenceManager();
        boolean expResult = true;
        boolean result = instance.Create(preference1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of Get method, of class preferenceManager.
     *//*
    @Test
    public void test2Get() throws Exception {
    }
*/
    /**
     * Test of Update method, of class preferenceManager.
     */
    @Test
    public void test3Update() {
        log.info ("preferenceManagerTest - test3Update");
        preferenceManager instance = new preferenceManager();
        boolean expResult = true;
        boolean result = instance.Update(preference2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class preferenceManager.
     */
    @Test
    public void test4Delete() {
        log.info ("preferenceManagerTest - test4Delete");
        preferenceManager instance = new preferenceManager();
        boolean expResult = true;
        boolean result = instance.Delete(preference1);
        assertEquals(expResult, result);  
    }
    
}
