package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.RecoException;
import com.canopyaudience.model.services.recoservice.IRecoSvc;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class recoManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        IRecoSvc recoSvc = (IRecoSvc)context.getBean("IRecoSvc");
        
	/** 
	 Business use case for "store recommendation"
	 
	 @param c
        * @return 
	*/
	public final boolean Create(recommendation c)
	{
		recoSvc.storeReco(c);
		return true;
	}
	
        /** 
	 Business use case for retrieving Mahout preference list
	 
	 @return Set<recommendation> 
        * @throws java.lang.ClassNotFoundException 
	*/
	public final List<recommendation>  Get() throws RecoException, ClassNotFoundException
	{
		return recoSvc.getReco();
	}
        
        /** 
	 Business use case for "retrieve list of recommendations for a single consumerID"
         * @param id
	 @return recommendation
         * @throws java.lang.ClassNotFoundException
	*/
	public final List<recommendation> GetA(int id) throws RecoException, ClassNotFoundException
	{
		return recoSvc.getAReco(id);
	}
        
        /** 
	 Business use case for "update preference"
	 
	 @param c
        * @return 
	*/
	public final boolean Update(recommendation c)
	{
		recoSvc.updateReco(c);
		return true;

	}

	/** 
	 Business use case for "delete recommendation"
	 
	 @param c
        * @return 
	*/
	public final boolean Delete(recommendation c)
	{
		recoSvc.deleteReco(c);
		return true;
	}

}