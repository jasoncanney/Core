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
          adimpression appdb  = adimpression;
          Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storeAdImpression - AdImpressionSvcHibernateImpl.java");
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                tx.commit();                               // added this line to fix session closing
                log.info("adimpression saved. Check database for data!");
      
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
     * @return <list> of adimpression
     * @throws java.lang.ClassNotFoundException
     */
    @Override
    public List<adimpression> getAdImpression() throws AdImpressionException, ClassNotFoundException {
        
        {
            Transaction tx;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAdImpression - AdImpressionSvcHibernateImpl.java");
            List<adimpression> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                // query students
                theApplications = session.createQuery("from adimpression").getResultList();
                tx.commit();
                log.info ("session.createQuery passed");
                log.info("adimpressions queried and put into List.");
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
     * Pulls one ad impression from database through hibernate interface
     * @param id
     * @return c which is an adimpression object
     * @throws java.lang.ClassNotFoundException
     */
    public adimpression getAAdImpression(int id) throws AdImpressionException, ClassNotFoundException {
        
        {
            Transaction tx;
            int i = id;
            adimpression c = new adimpression();
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAdImpression - AdImpressionSvcHibernateImpl.java");
            Session session = fetchSession();
            log.info ("fetched session");
                        
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                c = session.get(adimpression.class, i);
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
  * Updates Application object received from GUI and put in database
  * @param adimpression
  * @return boolean
  */
  @Override
  public boolean updateAdImpression(adimpression adimpression)
        {
            Transaction tx;
            boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("updateAdImpression - AdImpressionSvcHibernateImpl.java");
            adimpression appdb  = adimpression;
            adimpression appnew = null;
            Session session = fetchSession();
            log.info ("fetched session");     
            
            try 
            {
                       
                tx = session.beginTransaction();
                log.info ("beginTransaction, Getting adimpression with impression id:" + appdb.getImpID());
                // retrieve the current adimpression object from the database
                // update all fields in the current adimpression object except the PK of consumerID   
                appnew.setConsumerID(appdb.getConsumerID());
                appnew.setSessionID(appdb.getSessionID());
                appnew.setServiceID(appdb.getServiceID()); // check domain object, think this is missing
                appnew.setContentID(appdb.getContentID());
                appnew.setTerminalID(appdb.getTerminalID());
                appnew.setOppType(appdb.getOppType());
                appnew.setOppNum(appdb.getOppNum());
                appnew.setOppDuration(appdb.getOppDuration());
                appnew.setAdPCC(appdb.getAdPCC());
                appnew.setAdCampID(appdb.getAdCampID());
                appnew.setAssetID(appdb.getAssetID());
                appnew.setAssetProviderID(appdb.getAssetProviderID());
                appnew.setViewStartTime(appdb.getViewStartTime());
                appnew.setViewEndTime(appdb.getViewEndTime());
                appnew.setLocationID(appdb.getLocationID());
                appnew.setLocationZip(appdb.getLocationZip());
		System.out.println("Updating adimpression...");
                session.saveOrUpdate(appnew);
                tx.commit();
                log.info("Application updated. Check database for data!");
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
     * Deletes data from database through hibernate interface
     * @return boolean of applications
     */
    @Override
    public boolean deleteAdImpression(adimpression adimpression)
        {
            Transaction tx;
            boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deleteAdImpression - AdImpressionSvcHibernateImpl.java");
            adimpression appdb  = adimpression;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(adimpression passed in)");
                tx.commit();
                log.info("adimpression deleted. Check database for data not there!");
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
