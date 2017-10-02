/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.advertisement;
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
public class adManagerTest  extends TestCase {
    
    public adManagerTest() {
    }

    private advertisement advertisement1;
    private advertisement advertisement2;
    private advertisement advertisement3;


    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
                // Factory factory = Factory.getInstance();
		advertisement1 = new advertisement (8675330,"Store", 1, 2, 3, 4,"OCAP","1239876","A987654321","OCAP Stack","http://www.adobe.com/ocap","Hans Bender");                
                advertisement2 = new advertisement (8675330,"Update", 1, 2, 3, 4,"TVGuide","1239876","A987654321","RDK-B","http://www.adobe.com/ocap","Hans Bender");                
                advertisement3 = new advertisement (8675322,"Delete", 1, 2, 3, 4,"TVGuide","1239876","A987654321","RDK-B","http://www.adobe.com/ocap","Hans Bender");                

        }

        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(adManagerTest.class);
    
    
    
    /**
     * Test of Create method, of class adManager.
     */
    @Test
    public void test1Create() {
        log.info ("adManagerTest - test1Create");
        adManager instance = new adManager();
        boolean expResult = true;
        boolean result = instance.Create(advertisement1);
        assertEquals(expResult, result);   
        
    }

     /**
     * Test of Get method, of class adImpManager.
     */
    @Test
    public void test2AdManagerCreateGetA() throws Exception {
        log.info ("adManagerTest - test2AdManagerCreateGetA");
        adManager instance = new adManager();
        advertisement c = instance.GetA(advertisement1.getadId());
        assertEquals(c.getadId(), advertisement1.getadId());   
    }
    /**
     * Test of Update method, of class adManager.
     */
    @Test
    public void test3Update() {
         log.info ("adManagerTest - test3Update");
        adManager instance = new adManager();
        boolean expResult = true;
        boolean result = instance.Update(advertisement2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);        
    }

    /**
     * Test of Delete method, of class adManager.
     */
    @Test
    public void test4Delete() {
        log.info ("adManagerTest - test4Delete");
        adManager instance = new adManager();
        boolean expResult = true;
        boolean result = instance.Delete(advertisement1);
        assertEquals(expResult, result);  
    }
    
}
