package com.canopyaudience.model.services.preferenceservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.util.List;

/** 
 This interface defines methods for storing and retrieving Preferences
 to and from a file system
 @author Jason Canney
 
*/
public interface IPreferenceSvc extends IService
{

	/** 
	 Persists a Preference
	 The storePreference interface uses the storePreference method in the PreferenceSvcImpl class to store the object 
	 @param preference The Preference to be persisted 
	 @return  boolean true/false 
	 @exception PreferenceException  
	*/
	public boolean storePreference(preference preference);

	/** 
	 Retrieves a Preference 
	 @param Preference The unique Preference for the Preference to be retrieved 
	 @return  The Preference object matching Preference 
	 
	*/
	public List<preference> getPreference()throws PreferenceException, ClassNotFoundException;

	/** 
	 Updates a preference
	 The updatePreference takes in a preference object as input and will pass it to the preferenceSvcImpl 
	 @param preference The preference to be updated
	 @return  void 
	 @exception PreferenceException  
	*/

	public boolean updatePreference(preference preference);

	/** 
	 delete a preference
	 The deletePreference takes in a preference object as input and will pass it to the preferenceSvcImpl 
	 @param preference The preference to be updated
	 @return  void 
	 @exception PreferenceException  
	*/

	public boolean deletePreference(preference preference);

}