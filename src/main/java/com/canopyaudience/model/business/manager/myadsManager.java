package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.myAdsException;
import com.canopyaudience.model.services.myads.ImyAdSvc;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Service
public class myadsManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        ImyAdSvc consSvc = (ImyAdSvc)context.getBean("ImyAdSvc");
        
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("myadsManager.class");
        
	/** 
	 Business use case for "store myads"
	 
	 @param c
            * @return 
	*/
	public final boolean Create(myads c)
	{
		consSvc.storemyAds(c);
		return true;
	}

	/** 
	 Business use case for "retrieve myads list"
	 
	 @return Set<myads>
        * @throws java.lang.ClassNotFoundException
	*/
	public final List<myads> Get() throws myAdsException, ClassNotFoundException
	{
                log.info ("Next: return consSvc.getmyAds");
		return consSvc.getmyAds();
	}
        
	/** 
	 Business use case for "retrieve single myads"
         * @param id
	 @return myads
        * @throws java.lang.ClassNotFoundException
	*/ /*
	public final List<myads> GetA(int id) throws myAdsException, ClassNotFoundException
	{
		return consSvc.getAmyAds(id);
	}
        */
	/** 
	 Business use case for "update myads"
	 S
	 @param c
	*/
	public final boolean Update(myads c)
	{
		consSvc.updatemyAds(c);
		return true;
	}

	/** 
	 Business use case for "delete myads"
	 
	 @param c
	*/
	public final boolean Delete(myads c)
	{
		consSvc.deletemyAds(c);
		return true;
	}


}