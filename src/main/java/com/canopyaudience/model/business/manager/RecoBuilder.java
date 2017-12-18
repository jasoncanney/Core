/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.services.exception.PreferenceException;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Jason
 */
public class RecoBuilder {
    
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        
        //create an instance of the preference business manager object
        preferenceManager prefmgr = new preferenceManager();
        //create an instance of the adimpression business manager object
        adImpManager admgr = new adImpManager();

        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("RecoBuilder.class");
        
        /** 
	 Business use case for "store preference"
	 
	 @param c
	*/
	public final boolean BuildNewRecsForAUser(int id) throws PreferenceException, ClassNotFoundException
	{
                int i = id;
		prefmgr.GetAList(id);
                admgr.GetAList(id);
                
                
                
                
                
                
                
                
                
		return true;
	}
        
        
        
    
    
}
