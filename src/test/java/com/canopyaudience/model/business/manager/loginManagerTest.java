/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import static com.canopyaudience.model.business.manager.adManagerTest.log;
import com.canopyaudience.model.domain.login;
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
public class loginManagerTest extends TestCase{
    
    public loginManagerTest() {
    }
    
    login login1;
    login login2;
    login login3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		login1 = new login ("1", "2");                
                login2 = new login ("1", "2");             
                login3 = new login ("1", "2");           

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(loginManagerTest.class);

    /**
     * Test of Create method, of class loginManager.
     */
    @Test
    public void test1Create() {
        log.info ("loginManagerTest - test1Create");
        loginManager instance = new loginManager();
        boolean expResult = true;
        boolean result = instance.Create(login1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of Get method, of class loginManager.
     *//*
    @Test
    public void test2Get() throws Exception {
    }
*/
    /**
     * Test of Update method, of class loginManager.
     */
    @Test
    public void test3Update() {
        log.info ("loginManagerTest - test3Update");
        loginManager instance = new loginManager();
        boolean expResult = true;
        boolean result = instance.Update(login2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class loginManager.
     */
    @Test
    public void test4Delete() {
        log.info ("loginManagerTest - test4Delete");
        loginManager instance = new loginManager();
        boolean expResult = true;
        boolean result = instance.Delete(login1);
        assertEquals(expResult, result);  
    }
    
}
