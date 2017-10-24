/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.domain.myads;
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
public class myadsManagerTest  extends TestCase {
    
    public myadsManagerTest() {
    }

    private myads myads1, myads2, myads3;


    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		myads1 = new myads (1, 12345, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");    
                myads2 = new myads (1, 12345, 12354, "99", "02", "03","04","05",1235, "01", "02", "03","04","05");       
                myads3 = new myads (3, 12346, 12354, "01", "02", "03","04","05",1235, "01", "02", "03","04","05");                
        }

        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(myadsManagerTest.class);
    
    
    
    /**
     * Test of Create method, of class adManager.
     */
    @Test
    public void test1CreatemyAds() {
        log.info ("myadsManagerTest - test1CreatemyAds");
        myadsManager instance = new myadsManager();
        boolean expResult = true;
        boolean result = instance.Create(myads1);
        assertEquals(expResult, result);   
        
    }

     /**
     * Test of Get method, of class adImpManager.
     */
    /*
    @Test
    public void test2myadsManagerCreateGetA() throws Exception {
        log.info ("myadsManagerTest - test2myadsManagerCreateGetA");
        myadsManager instance = new myadsManager();
        myads c = instance.GetA(myads1.getIDentifier());
        assertEquals(c.getIDentifier(), myads1.getIDentifier());   
    }
    */
    /**
     * Test of Update method, of class adManager.
     */
    @Test
    public void test3Updatemyads() {
         log.info ("myadsManagerTest - test3Updatemyads");
        myadsManager instance = new myadsManager();
        boolean expResult = true;
        boolean result = instance.Update(myads2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class adManager.
     */
    @Test
    public void test4Deletemyads() {
        log.info ("myadsManagerTest - test4Deletemyads");
        myadsManager instance = new myadsManager();
        boolean expResult = true;
        boolean result = instance.Delete(myads1);
        assertEquals(expResult, result);  
    }
    
}
