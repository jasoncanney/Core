/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.preferenceservice;

import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.services.exception.PreferenceException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.AbstractJDBCDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
            Transaction tx;
            boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storePreference - PreferenceSvcHibernateImpl.java");
            preference appdb  = preference;
            Session session = fetchSession();
            log.info ("fetched session");
                  
            try 
            {    
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                log.info (appdb);
                log.info("preference saved. Check database for data!");
                tx.commit();
            }
            catch(Exception e)
            {
               if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
            }
            
            return status;
       }  

    /**
     * Pulls data from database through hibernate interface
     * @return <list> of preference for a single user
     * @throws java.lang.ClassNotFoundException
     */
  
    @Override
    public List<preference> getAPrefList(int id) throws PreferenceException, ClassNotFoundException {
        
        {
            int i = id;  
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getPreference - PreferenceSvcHibernateImpl.java");
            List<preference> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                String hql = "from preference where consumerID = :id";   
                // System.out.println(hql);
                Query query = session.createQuery(hql);
                query.setParameter("id", i);
                List result = query.list();
                // System.out.println("resultset:"+result);
                theApplications = result;
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
            }
            return theApplications;
       }  
    }
  
    /**
     * Pulls data from database through hibernate interface
     * @return <list> of preference
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<preference> getPreference() throws PreferenceException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getPreference - PreferenceSvcHibernateImpl.java");
            List<preference> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                // query students
                theApplications = session.createQuery("from preference").getResultList();
                log.info ("session.createQuery passed");
                log.info("preference queried and put into List.");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
            }
            return theApplications;
       }  
    }
   
    /**
     * Pulls data from database through hibernate interface
     * @return <list> of preference
     * @throws java.lang.ClassNotFoundException
     * @throws org.apache.mahout.cf.taste.common.TasteException
     */
    @Override
    public AbstractJDBCDataModel getMahoutPreference() throws PreferenceException, ClassNotFoundException, TasteException {
        {
            // boolean status = true;
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getMahoutPreference - PreferenceSvcHibernateImpl.java");
           //  List<preference> theApplications = null;
            AbstractJDBCDataModel theApplications = new MySQLJDBCDataModel();
            
            Session session = fetchSession();
            log.info ("fetched session");
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = (AbstractJDBCDataModel) session.createQuery("consumerID, preferenceChoice, advertisementID from preference").getResultList();
                log.info ("session.createQuery passed");
                log.info("preference queried and put into List.");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
            }
            return theApplications;
       }  
    }
   
    /**
     * Pulls single preference from database through hibernate interface
     * @return preference
     * @throws java.lang.ClassNotFoundException
     */
    public preference getAPreference(int id) throws PreferenceException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getPreference - PreferenceSvcHibernateImpl.java");
            int i = id;
            preference c = new preference();
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            { 
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                c = session.get(preference.class, i);
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
            }
            return c;
       }  
    }
    
    /**
    * Updates preference object received from GUI and put in database
    * @return boolean
    */
  @Override
  public boolean updatePreference(preference preference)
        {
            boolean status = false;
            Transaction tx;
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
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info(appdb.toString());
                log.info ("beginTransaction, Getting preference with preferenceID:" + appdb.getPreferenceId());
                // retrieve the current application object from the database
                appnew = session.get(preference.class, appdb.getPreferenceId());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setPreferenceChoice(appdb.getPreferenceChoice());
                appnew.setPreferenceDate(appdb.getPreferenceDate());
                appnew.setAdvertisementID(appdb.getAdvertisementID());
                appnew.setCouponID(appdb.getCouponID());
                appnew.setConsumerId(appdb.getConsumerId());
                log.info(appnew.toString());
		System.out.println("Updating preference...");
                // application object is updated in the db based on the Primary Key that was unchanged
                session.saveOrUpdate(appnew);
                log.info("preference updated. Check database for data!");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close();                                                 // added this line to fix session closing
                status = true;
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
            Transaction tx;
            boolean status = false;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deletePreference - PreferenceSvcHibernateImpl.java");
            preference appdb  = preference;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(preference passed in)");
                log.info("preference deleted. Check database for data not there!");
                tx.commit();
            }
            catch(Exception e)
            {
              if (session.getTransaction() != null) {
                session.getTransaction().rollback();
                log.error (e.getClass() + ": " + e.getMessage(), e);
                }
            }
            finally{
                session.close(); 
                status = true;
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
