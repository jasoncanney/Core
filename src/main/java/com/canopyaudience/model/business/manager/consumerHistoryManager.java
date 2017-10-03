package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.consumerhistoryservice.IConsumerHistorySvc;
import com.canopyaudience.model.services.exception.ConsumerHistoryException;
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
		return consSvc.getConsumerHistory();
       	}
	
        /** 
	 Business use case for "retrieve single consumer"
         * @param id
	 @return consumer
         * @throws java.lang.ClassNotFoundException
	*/
	public final consumerHistory GetA(int id) throws ConsumerHistoryException, ClassNotFoundException
	{
		return consSvc.getAConsumerHistory(id);
	}
        
	/** 
	 Business use case for "update consumerHistory"
	 
	 @param c
	*/
	public final boolean Update(consumerHistory c)
	{
		consSvc.updateConsumerHistory(c);
		return true;
	}

	/** 
	 Business use case for "delete consumerHistory"
	 
	 @param c
	*/
	public final boolean Delete(consumerHistory c)
	{
		consSvc.deleteConsumerHistory(c);
		return true;
	}
        
}