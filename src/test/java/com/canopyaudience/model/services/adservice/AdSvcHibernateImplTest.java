/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adservice;

// import static org.junit.Assert.*;

import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.services.exception.AdvertisementException;

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
public class AdSvcHibernateImplTest extends TestCase{
    
    public AdSvcHibernateImplTest() {
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
        static Logger log = Logger.getLogger(AdSvcHibernateImplTest.class);
             
    /**
     * Test of storeAdvertisement method, of class AdSvcHibernateImpl.
     */
    @Test
    public void test1StoreAdvertisement() {
        log.info ("AdSvcHibernateImplTest - test1StoreAdvertisement");
        AdSvcHibernateImpl instance = new AdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeAdvertisement(advertisement1);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAdvertisement method, of class AdSvcHibernateImpl.
     *//*
    @Test
    public void test2GetAAdvertisement() throws AdvertisementException, ClassNotFoundException {
        log.info ("AdSvcHibernateImplTest - test2GetAAdvertisement");
        AdSvcHibernateImpl instance = new AdSvcHibernateImpl();
        advertisement c = new advertisement();
        c = instance.getAAdvertisement(advertisement1.getadId());
        assertEquals(c.getadId(), advertisement1.getadId());   
    }
    */
    /**
     * Test of updateAdvertisement method, of class AdSvcHibernateImpl.
     */
    @Test
    public void test3UpdateAdvertisement() {
        log.info ("AdSvcHibernateImplTest - test3UpdateAdvertisement");
        AdSvcHibernateImpl instance = new AdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateAdvertisement(advertisement2);  // advertisement2 is a pre-updated advertisement object for advertisement1
        assertEquals(expResult, result);    
    }

    /**
     * Test of deleteAdvertisement method, of class AdSvcHibernateImpl.
     */
    @Test
    public void test4DeleteAdvertisement() {
        log.info ("AdSvcHibernateImplTest - test4DeleteAdvertisement");
        AdSvcHibernateImpl instance = new AdSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteAdvertisement(advertisement1);
        assertEquals(expResult, result); 
}
    
}
