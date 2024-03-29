package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.PreferenceException;
import com.canopyaudience.model.services.preferenceservice.IPreferenceSvc;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class preferenceManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IPreferenceSvc prefsSvc = (IPreferenceSvc)context.getBean("IPreferenceSvc");
        
	/** 
	 Business use case for "store preference"
	 
	 @param c
	*/
	public final boolean Create(preference c)
	{
		// Factory factory = Factory.getInstance();
		// IPreferenceSvc prefsSvc = (IPreferenceSvc)factory.getService("IPreferenceSvc");
		prefsSvc.storePreference(c);
		return true;
	}

	/** 
	 Business use case for "retrieve preference list"
	 
	 @param id
	 @return Set<preference> 
	*/
	public final AbstractJDBCDataModel getMahoutPref() throws PreferenceException, ClassNotFoundException, TasteException
	{
		// Factory factory = Factory.getInstance();
		// IPreferenceSvc prefsSvc = (IPreferenceSvc)factory.getService("IPreferenceSvc");
		return prefsSvc.getMahoutPreference();
	}
	
        /** 
	 Business use case for retrieving a single UID set of preferences 
	 @param id
	 @return Set<preference> 
	*/
	public final List<preference> GetAList(int id) throws PreferenceException, ClassNotFoundException
	{
		return prefsSvc.getAPrefList(id);
	}
        
        /** 
	 Business use case for retrieving Mahout preference list
	 
	 @param id
	 @return Set<preference> 
	*/
	public final List<preference> Get() throws PreferenceException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// IPreferenceSvc prefsSvc = (IPreferenceSvc)factory.getService("IPreferenceSvc");
		return prefsSvc.getPreference();
	}
        
        /** 
	 Business use case for "retrieve single preference"
         * @param id
	 @return preference
         * @throws java.lang.ClassNotFoundException
	*/
	public final preference GetA(int id) throws PreferenceException, ClassNotFoundException
	{
		return prefsSvc.getAPreference(id);
	}
        
        /** 
	 Business use case for "update preference"
	 
	 @param c
	*/
	public final boolean Update(preference c)
	{
		// Factory factory = Factory.getInstance();
		// IPreferenceSvc prefSvc = (IPreferenceSvc)factory.getService("IPreferenceSvc");
		prefsSvc.updatePreference(c);
		return true;

	}

	/** 
	 Business use case for "delete preference"
	 
	 @param c
	*/
	public final boolean Delete(preference c)
	{
		// Factory factory = Factory.getInstance();
		// IPreferenceSvc prefSvc = (IPreferenceSvc)factory.getService("IPreferenceSvc");
		prefsSvc.deletePreference(c);
		return true;
	}

}