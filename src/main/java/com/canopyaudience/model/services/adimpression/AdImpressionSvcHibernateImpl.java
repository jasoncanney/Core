/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.adimpression;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.services.exception.AdImpressionException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jason
 */
public class AdImpressionSvcHibernateImpl implements IAdImpressionSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("AdImpressionSvcHibernateImpl.class");
	
 /**
  * Set adimpression data received from GUI and put in database
  * @return boolean
  */
 
  @Override
  public boolean storeAdImpression(adimpression adimpression)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("storeAdImpression - AdImpressionSvcHibernateImpl.java");
 
            adimpression appdb  = adimpression;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                session.getTransaction().commit();                               // added this line to fix session closing
                log.info("adimpression saved. Check database for data!");
                session.close();                                                 // added this line to fix session closing
            }
            catch(Exception e)
            {
              if (tx==null) 
                            {
                                   //  tx.rollback();
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
    @Override
    public List<adimpression> getAdImpression() throws AdImpressionException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("getAdImpression - AdImpressionSvcHibernateImpl.java");
 
            Transaction tx = null;
            
            List<adimpression> theApplications = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                
                // query students
                theApplications = session.createQuery("from adimpression").getResultList();
                log.info ("session.createQuery passed");
                session.close();    
                log.info("adimpressions queried and put into List.");
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
            return theApplications;
       }  
    }
    /**
  * Updates Application object received from GUI and put in database
  * @param adimpression
  * @return boolean
  */
  @Override
  public boolean updateAdImpression(adimpression adimpression)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("updateAdImpression - AdImpressionSvcHibernateImpl.java");
 
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            adimpression appdb  = adimpression;
            
            // create a new application object.  This is where the current application object gets stored and 
            // will be used to make updates and store back in the db
            adimpression appnew = null;
            Transaction tx=null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");            
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting adimpression with consumerid:" + appdb.getConsumerID());
                // log.info (appdb.toString());
                // retrieve the current application object from the database
                appnew = session.get(adimpression.class, appdb.getConsumerID());
                // log.info (appnew.toString());
                // update all fields in the current adimpression object except the PK of consumerID   
                appnew.setSessionID(appdb.getSessionID());
                appnew.setServiceID(appdb.getServiceID()); // check domain object, think this is missing
                appnew.setContentID(appdb.getContentID());
                appnew.setDuration(appdb.getDuration());
                appnew.setCurrentDateTime(appdb.getCurrentDateTime());
                appnew.setTerminalID(appdb.getTerminalID());
                appnew.setOppType(appdb.getOppType());
                appnew.setOppNum(appdb.getOppNum());
                appnew.setOppDuration(appdb.getOppDuration());
                appnew.setPccCode(appdb.getPccCode());
                appnew.setAdCampID(appdb.getAdCampID());
                appnew.setAssetID(appdb.getAssetID());
                appnew.setAssetProviderID(appdb.getAssetProviderID());
                appnew.setViewStartTime(appdb.getViewStartTime());
                appnew.setViewEndTime(appdb.getViewEndTime());
                appnew.setLocationID(appdb.getLocationID());
                appnew.setLocationZip(appdb.getLocationZip());
                
                // log.info (appnew.toString());

	
		System.out.println("Updating adimpression...");

                // application object is updated in the db based on the Primary Key that was unchanged
                session.update(appnew);
                
		// commit the transaction
		session.getTransaction().commit();
                
                // tx.commit();
                log.info("Application updated. Check database for data!");
                
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
     * @return boolean of applications
     */
    @Override
    public boolean deleteAdImpression(adimpression adimpression)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");

            log.info ("deleteAdImpression - AdImpressionSvcHibernateImpl.java");
 
            adimpression appdb  = adimpression;
            Transaction tx = null;
            
            try 
            {
                Session session = fetchSession();
                log.info ("fetched session");
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(adimpression passed in)");
                session.getTransaction().commit();                               // added this line to fix session closing
                //tx.commit();
                log.info("adimpression deleted. Check database for data not there!");
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
