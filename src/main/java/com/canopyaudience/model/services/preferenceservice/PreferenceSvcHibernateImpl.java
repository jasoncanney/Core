/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.preferenceservice;

import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.services.exception.CouponException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class PreferenceSvcHibernateImpl implements IPreferenceSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("PreferenceSvcHibernateImpl.class");
	
 /**
  * Set preference data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storePreference(preference preference)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storePreference - PreferenceSvcHibernateImpl.java");
 
            preference appdb  = preference;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                session.getTransaction().commit();    
                log.info("preference saved. Check database for data!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  

    /**
     * Pulls data from database through hibernate interface
     * @return <list> of preference
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<preference> getPreference() throws CouponException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getPreference - PreferenceSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<preference> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from preference").getResultList();
                log.info ("session.createQuery passed");
                session.close();                  log.info("preference queried and put into List.");
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }     
            return theApplications;
       }  
    }
    /**
  * Updates preference object received from GUI and put in database
  * @return boolean
  */
  @Override
  public boolean updatePreference(preference preference)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updatePreference - PreferenceSvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            preference appdb  = preference;
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            preference appnew = null;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting preference with preferenceID:" + appdb.getPreferenceId());
                
                // retrieve the current application object from the database
                appnew = session.get(preference.class, appdb.getPreferenceId());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setPreferenceGsSegment(appdb.getPreferenceGsSegment());
                appnew.setPreferenceCaTypeCode(appdb.getPreferenceCaTypeCode());
                appnew.setPreferenceCaValueCode(appdb.getPreferenceCaValueCode());
                appnew.setPreferencePcc(appdb.getPreferencePcc());
                appnew.setPreferenceBrandOwner(appdb.getPreferenceBrandOwner());
                appnew.setPreferenceProductDesc(appdb.getPreferenceProductDesc());
                appnew.setPreferenceDate(appdb.getPreferenceDate());
                appnew.setConsumerId(appdb.getConsumerId());

		System.out.println("Updating preference...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                log.info("preference updated. Check database for data!");
                                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
     /**
     * Deletes data from database through hibernate interface
     * @param preference
     * @return boolean of applications
     */
    @Override
    public boolean deletePreference(preference preference)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deletePreference - PreferenceSvcHibernateImpl.java");
 
            preference appdb  = preference;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(preference passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                log.info("preference deleted. Check database for data not there!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     // tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  
    /**
	 * Gets a hibernate session from HibernateFactory
	 * 
	 * @return org.hibernate.Session
	 * 
	 */
	private Session fetchSession()
	{
			log.info ("******Fetching Hibernate Session");

			Session session = HibernateFactory.currentSession();

			return session;
	    
	} //end fetchConnection

}// end class AdImpressionSvcHibernateImpl
