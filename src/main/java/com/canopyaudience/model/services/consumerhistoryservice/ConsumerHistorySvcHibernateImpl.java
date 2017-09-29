/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.consumerhistoryservice;

import com.canopyaudience.model.domain.consumerHistory;
import com.canopyaudience.model.services.exception.ConsumerHistoryException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class ConsumerHistorySvcHibernateImpl implements IConsumerHistorySvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("ConsumerHistorySvcHibernateImpl.class");
	
 /**
  * Set adimpression data received from GUI and put in database
  * @param consumerHistory
  * @return boolean
  */
 
  @Override
  public boolean storeConsumerHistory(consumerHistory consumerHistory)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeConsumerHistory - ConsumerHistorySvcHibernateImpl.java");
 
            consumerHistory appdb  = consumerHistory;
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
                //tx.commit();
                log.info("consumerHistory saved. Check database for data!");
                session.close();                                                 // added this line to fix session closing

            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                     //tx.rollback();
                                     e.printStackTrace();

                            }
              log.error (e.getClass() + ": " + e.getMessage(), e);
            }
            return status;
       }  

    /**
     * Pulls data from database through hibernate interface
     * @return <list> of adimpression
     * @throws java.lang.ClassNotFoundException
     */
    public Set<consumerHistory> getConsumerHistory() throws ConsumerHistoryException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getConsumerHistory - ConsumerHistorySvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<consumerHistory> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from consumerhistory").getResultList();
                log.info ("session.createQuery passed");
                session.close();    
                log.info("consumerHistory queried and put into List.");
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
            return (Set<consumerHistory>) theApplications;
       }  
    }
    /**
  * Updates consumerHistory object received from GUI and put in database
  * @param consumerHistory
  * @return boolean
  */
  public boolean updateConsumerHistory(consumerHistory consumerHistory)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updateConsumerHistory - ConsumerHistorySvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            consumerHistory appdb  = consumerHistory;
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            consumerHistory appnew = null;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting consumerHistory with consumerid:" + appdb.getConsumerID());
                
                // retrieve the current application object from the database
                appnew = session.get(consumerHistory.class, appdb.getConsumerID());
                // update all fields in the current advertisement object except the PK of consumerID  
                appnew.setPreferenceID(appdb.getPreferenceID());
                appnew.setPreferenceDate(appdb.getPreferenceDate());
                appnew.setPreferenceChoice(appdb.getPreferenceChoice());
                appnew.setAdvertisementID(appdb.getAdvertisementID());
                appnew.setCouponID(appdb.getCouponID());
	
		System.out.println("Updating consumerHistory...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                
                // tx.commit();
                log.info("consumerHistory updated. Check database for data!");
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
     * @param consumerHistory
     * @return boolean of applications
     */
    public boolean deleteConsumerHistory(consumerHistory consumerHistory)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deleteConsumerHistory - ConsumerHistorySvcHibernateImpl.java");
 
            consumerHistory appdb  = consumerHistory;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(consumerHistory passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                // tx.commit();
                log.info("consumerHistory deleted. Check database for data not there!");
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
