package com.canopyaudience.model.services.preferenceservice;

import com.canopyaudience.model.domain.*;
import com.canopyaudience.model.services.*;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.util.List;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;

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
	 Retrieves a Preference for a Single User
	 @return  The Preference object matching Preference 
        * @throws java.lang.ClassNotFoundException 
	 
	*/
        public List<preference> getAPrefList(int id) throws PreferenceException, ClassNotFoundException;
        
	/** 
	 Retrieves a Preference 
	 @return  The Preference object matching Preference 
        * @throws java.lang.ClassNotFoundException 
	 
	*/
	public List<preference> getPreference()throws PreferenceException, ClassNotFoundException;
       
        /** 
	 Retrieves Preference set in Mahout DataModel format 
	 @return  The Preference object matching Preference
        * @throws java.lang.ClassNotFoundException
        * @throws org.apache.mahout.cf.taste.common.TasteException
	*/
        public AbstractJDBCDataModel getMahoutPreference() throws PreferenceException, ClassNotFoundException, TasteException;

        /**
        * Pulls single preference from database through hibernate interface
        * @param id
        * @return preference
        * @throws java.lang.ClassNotFoundException
        */
        public preference getAPreference(int id) throws PreferenceException, ClassNotFoundException;
        
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