/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.domain.recommendation;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import org.apache.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Jason
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RecoBuilderTest extends TestCase{
    
    public RecoBuilderTest() {
    }

    // recommendation recommendation1;
    
    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
		// provider1 = new provider (86730, "1");                
               
        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(RecoBuilderTest.class);
    
    /**
     * Test of BuildNewRecsForAUser method, of class RecoBuilder.
     */
    @Test
    public void test1BuildNewRecsForAUser() throws Exception {
        log.info ("RecoBuilderTest - test1BuildNewRecsForAUser");
        RecoBuilder instance = new RecoBuilder();
        // providerManager instance = new providerManager();
        boolean expResult = true;
        boolean result = instance.BuildNewRecsForAUser(1);
        assertEquals(expResult, result);   
    
    }
    
}
