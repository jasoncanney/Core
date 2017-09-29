package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.exception.LoginException;
import com.canopyaudience.model.services.loginservice.ILoginSvc;
import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class loginManager extends ManagerSuperType
{
        // create reference to the actual config file
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        // leverage spring to get the config information for the service
        ILoginSvc consSvc = (ILoginSvc)context.getBean("ILoginSvc");
        
	/** 
	 Business use case for "store login"
	 
	 @param c
	*/
	public final boolean Create(login c)
	{
		// Factory factory = Factory.getInstance();
		// ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		consSvc.storeLogin(c);
		return true;
	}

	/** 
	 Business use case for "retrieve login list"
	 
	 @return Set<login>
	*/
	public final Set<login> Get() throws LoginException, ClassNotFoundException
	{
		// Factory factory = Factory.getInstance();
		// ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		return consSvc.getLogin();
	}
	/** 
	 Business use case for "retrieve userName"
	 
	 @return 
	*//**
	public final String whatIsLoginID(String username)
	{
		Factory factory = Factory.getInstance();
		ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		return consSvc.whatIsLoginID(username);
	}
*/
	/** 
	 Business use case for "retrieve single login"
	 
	 @return login
	*//**
	public final login Get(int id)
	{
		Factory factory = Factory.getInstance();
		ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		return consSvc.getLogin(id);
	}
*/
	/** 
	 Business use case for "verify login"
	 S
	 @param c
	*//**
	public final boolean Verify(login c)
	{
		Factory factory = Factory.getInstance();
		ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		return consSvc.verifyLogin(c);
		// return true;
	}
*/

	/** 
	 Business use case for "update login"
	 S
	 @param c
	*/
	public final boolean Update(login c)
	{
		// Factory factory = Factory.getInstance();
		// ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		consSvc.updateLogin(c);
		return true;

	}

	/** 
	 Business use case for "delete login"
	 
	 @param c
	*/
	public final boolean Delete(login c)
	{
		// Factory factory = Factory.getInstance();
		// ILoginSvc consSvc = (ILoginSvc)factory.getService("ILoginSvc");
		consSvc.deleteLogin(c);
		return true;
	}


}