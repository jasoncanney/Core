/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.interest;
import com.canopyaudience.model.services.interestservice.IntSvcHibernateImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
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

public class intManagerTest extends TestCase {
    
    public intManagerTest() {
    }

    private interest interest1, interest2;
     
    Random randomNumbers = new Random();  // object to create for a new random number for the appID
	
    /*
     * Category set in config/log4j.properties as
     * log4j.category.com.classexercise=DEBUG, A1
     */
    static Logger log = Logger.getLogger(intManagerTest.class);

    /**
     * @throws java.lang.Exception
     */
    @Before	
    @Override
    public void setUp() throws Exception {

        
    long date_1 = System.currentTimeMillis(); 
    long date_2 = System.currentTimeMillis();
    interest1 = new interest(date_1,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
    interest2 = new interest(date_2,12,12345,1,"Hulu.com","80126",12,12,"http://www.bmw.com","123a","BMW");
    
    List<interest> theInterests = null;

    }
    
    /**
     * Test of storePreference method, of class PreferenceSvcHibernateImpl.
     */
    @Test
    public void test1StoreInterest() {
        log.info ("intManagerTest - test1StoreInterest");
        intManager instance = new intManager();
        boolean expResult = true;
        boolean result = instance.Create(interest2);
        assertEquals(expResult, result);   
    }
    
   
     /**
     * Test of Get method, of class adImpManager.
     *//*
    
    @Test
    public void test2intManagerGetA() throws Exception {
        List<interest> theInterests = null;
        log.info ("intManagerTest - test2intManagerGetA");
        intManager instance = new intManager();
        theInterests = instance.GetA(interest1.getConsumerId());   
        assertEquals(interest1.getConsumerId(), 12345);   
    }*/
    
}
