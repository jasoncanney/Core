/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.preferenceservice;

import com.canopyaudience.model.domain.preference;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
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
public class PreferenceSvcHibernateImplTest extends TestCase{
    
    public PreferenceSvcHibernateImplTest() {
    }

    preference preference1;
    preference preference2;
    preference preference3;

    @Before	
	protected void setUp() throws Exception {
		
		super.setUp();
        
                
    String date_1 = "2011-01-18 23:59:01.0"; 
    String date_2 = "2017-01-18 23:59:01.0";
    SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss"); 
    Date d1 = dt.parse(date_1);
    Date d2 = dt.parse(date_2);
            
        preference1 = new preference (27,1,d1,6,7,8675);
        preference2 = new preference (28,1,d1,12,69,8675);
        preference3 = new preference (88,0,d2,6,7,8675);      

        }
        /*
	 * Category set in config/log4j.properties as
	 * log4j.category.com.classexercise=DEBUG, A1
	 */
        static Logger log = Logger.getLogger(PreferenceSvcHibernateImplTest.class);
    
    
    
    /**
     * Test of storePreference method, of class PreferenceSvcHibernateImpl.
     */
    @Test
    public void test1StorePreference() {
        log.info ("PreferenceSvcHibernateImplTest - test1StorePreference");
        PreferenceSvcHibernateImpl instance = new PreferenceSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storePreference(preference1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getAPreference method, of class PreferenceSvcHibernateImpl.
     *//*
    @Test
    public void test2GetAPreference() throws Exception {
        log.info ("PreferenceSvcHibernateImplTest - test2GetAPreference");
        PreferenceSvcHibernateImpl instance = new PreferenceSvcHibernateImpl();
        preference c = instance.getAPreference(preference1.getPreferenceId());
        log.info(c.toString());
        int expResult = 8675;
        assertEquals(expResult, preference1.getConsumerId()); 
        preference2.setConsumerId(preference1.getConsumerId());
    }*/
 
    /**
     * Test of updatePreference method, of class PreferenceSvcHibernateImpl.
     *//*
    @Test
    public void test3UpdatePreference() {
        log.info ("PreferenceSvcHibernateImplTest - test3UpdatePreference");
        PreferenceSvcHibernateImpl instance = new PreferenceSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updatePreference(preference2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);    
    }*/
    /**
     * Test of deletePreference method, of class PreferenceSvcHibernateImpl.
     *//*
    @Test
    public void test4DeletePreference() {
        log.info ("PreferenceSvcHibernateImplTest - test4DeletePreference");
        PreferenceSvcHibernateImpl instance = new PreferenceSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deletePreference(preference2);
        assertEquals(expResult, result); 
    }
    */
}
