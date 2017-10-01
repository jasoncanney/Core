package com.canopyaudience.model.services.loginservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.LoginException;
import java.util.List;

/** 
 This interface defines methods for persisting of login.java
 to and from a file system
 @author Jason L. Canney
  
*/
public interface ILoginSvc extends IService
{

	/** 
	 Persists a login
	 The storeLogin takes in a login object as input and will pass it to the LoginSvcImpl 
	 @param login The login to be persisted 
	 @return  void  
	*/

	public boolean storeLogin(login login);

	/** 
	 Retrieves a login
	 The getLogin takes a Login as an argument and retrieves it through the LoginSvcImpl class 
	 @return  The collection 
	 @exception LoginException 
	 @exception ClassNotFoundException  
	*/

	public List<login> getLogin()throws LoginException, ClassNotFoundException;

	/** 
	 Updates a Login
	 The updateLogin takes in a login object as input and will pass it to the LoginSvcImpl 
	 @param login The login to be updated
	 @return  void  
	*/


	public boolean updateLogin(login login);

	/** 
	 delete a login
	 The deleteLogin takes in a login object as input and will pass it to the LoginSvcImpl 
	 @param login The login to be updated
	 @return  void  
	*/

	public boolean deleteLogin(login login);

}