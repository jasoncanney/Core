package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.consumerhistoryservice.IConsumerHistorySvc;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class consumerHistoryManager extends ManagerSuperType
{
    
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IConsumerHistorySvc consSvc = (IConsumerHistorySvc)context.getBean("IConsumerHistorySvc");
    
	/** 
	 Business use case for "store consumerHistory"
	 
	 @param c
	*/
	public final boolean Create(consumerHistory c)
	{
		// Factory factory = Factory.getInstance();
		// IConsumerHistorySvc consSvc = (IConsumerHistorySvc)factory.getService("IConsumerHistorySvc");
		consSvc.storeConsumerHistory(c);
		return true;

	}

	/** 
	 Business use case for "retrieve consumerHistory List"
	 
	 @param id
	 @return 
	*/
	public final List<consumerHistory> Get() throws ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// IConsumerHistorySvc consSvc = (IConsumerHistorySvc)factory.getService("IConsumerHistorySvc");
		return consSvc.getConsumerHistory();
       	}
	

	/** 
	 Business use case for "update consumerHistory"
	 
	 @param c
	*/
	public final boolean Update(consumerHistory c)
	{
		// Factory factory = Factory.getInstance();
		// IConsumerHistorySvc consSvc = (IConsumerHistorySvc)factory.getService("IConsumerHistorySvc");
		consSvc.updateConsumerHistory(c);
		return true;

	}

	/** 
	 Business use case for "delete consumerHistory"
	 
	 @param c
	*/
	public final boolean Delete(consumerHistory c)
	{
		// Factory factory = Factory.getInstance();
		// IConsumerHistorySvc consSvc = (IConsumerHistorySvc)factory.getService("IConsumerHistorySvc");
		consSvc.deleteConsumerHistory(c);
		return true;
	}
        
}