/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.loginservice;

import com.canopyaudience.model.domain.login;
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
public class LoginSvcHibernateImplTest extends TestCase{
    
    public LoginSvcHibernateImplTest() {
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
        static Logger log = Logger.getLogger(LoginSvcHibernateImplTest.class);
    
    /**
     * Test of storeLogin method, of class LoginSvcHibernateImpl.
     */
    @Test
    public void test1StoreLogin() {
        log.info ("LoginSvcHibernateImplTest - test1StoreLogin");
        LoginSvcHibernateImpl instance = new LoginSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.storeLogin(login1);
        assertEquals(expResult, result);   
    }

    /**
     * Test of getLogin method, of class LoginSvcHibernateImpl.
     *//*
    @Test
    public void test2GetLogin() throws Exception {
    }
*/
    /**
     * Test of updateLogin method, of class LoginSvcHibernateImpl.
     */
    @Test
    public void test3UpdateLogin() {
        log.info ("LoginSvcHibernateImplTest - test3UpdateLogin");
        LoginSvcHibernateImpl instance = new LoginSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.updateLogin(login2);  // adimpression2 is a pre-updated adimpression object for adimpression1
        assertEquals(expResult, result);   
    }

    /**
     * Test of deleteLogin method, of class LoginSvcHibernateImpl.
     */
    @Test
    public void test4DeleteLogin() {
        log.info ("LoginSvcHibernateImplTest - test4DeleteLogin");
        LoginSvcHibernateImpl instance = new LoginSvcHibernateImpl();
        boolean expResult = true;
        boolean result = instance.deleteLogin(login1);
        assertEquals(expResult, result); 
    }
    
}
