package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.ProviderException;
import com.canopyaudience.model.services.providerservice.IProviderSvc;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// @Service
public class providerManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IProviderSvc consSvc = (IProviderSvc)context.getBean("IProviderSvc");
        
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("providerManager.class");
        
	/** 
	 Business use case for "store provider"
	 
	 @param c
            * @return 
	*/
	public final boolean Create(provider c)
	{
		consSvc.storeProvider(c);
		return true;
	}

	/** 
	 Business use case for "retrieve provider list"
	 
	 @return Set<provider>
        * @throws java.lang.ClassNotFoundException
	*/
	public final List<provider> Get() throws ProviderException, ClassNotFoundException
	{
                log.info ("Next: return consSvc.getProvider");
		return consSvc.getProvider();
	}
        
	/** 
	 Business use case for "retrieve providerID"
	 
	 @return 
	*//**
	public final int whatIsConsumerID(String socemail)
	{
		Factory factory = Factory.GetInstance();
		IConsumerSvc consSvc = (IConsumerSvc)factory.getService("IConsumerSvc");
		return consSvc.whatIsConsumerID(socemail);
	}
*/
	/** 
	 Business use case for "retrieve single provider"
         * @param id
	 @return provider
        * @throws java.lang.ClassNotFoundException
	*/
	public final provider GetA(int id) throws ProviderException, ClassNotFoundException
	{
		return consSvc.getAProvider(id);
	}
        
	/** 
	 Business use case for "update provider"
	 S
	 @param c
	*/
	public final boolean Update(provider c)
	{
		consSvc.updateProvider(c);
		return true;

	}

	/** 
	 Business use case for "delete provider"
	 
	 @param c
	*/
	public final boolean Delete(provider c)
	{
		consSvc.deleteProvider(c);
		return true;
	}


}