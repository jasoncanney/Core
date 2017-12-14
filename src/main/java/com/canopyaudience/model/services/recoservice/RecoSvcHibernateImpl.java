/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.services.recoservice;

import com.canopyaudience.model.domain.recommendation;
import com.canopyaudience.model.services.exception.RecoException;
import com.canopyaudience.model.services.factory.HibernateFactory;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Jason
 */
public class RecoSvcHibernateImpl implements IRecoSvc
{
	/*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("RecoSvcHibernateImpl.class");
	
 /**
  * Set preference data received from GUI and put in database
  * @return boolean
  */
 
  public boolean storeReco(recommendation recommendation)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("storeReco - RecoSvcHibernateImpl.java");
            recommendation appdb  = recommendation;
            Session session = fetchSession();
            log.info ("fetched session");
                  
            try 
            {    
                session.beginTransaction();
                log.info(appdb.toString());
                log.info ("beginTransaction");
                session.save(appdb);
                log.info ("session.saved");
                log.info("recommendation saved. Check database for data!");
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
     * @return <list> of preference
     * @throws java.lang.ClassNotFoundException
     */
    public List<recommendation> getReco() throws RecoException, ClassNotFoundException {
        
        {
            // boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getReco - RecoSvcHibernateImpl.java");
            List<recommendation> theApplications = null;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                session.beginTransaction();
                log.info ("beginTransaction");
                theApplications = session.createQuery("from recommendation").getResultList();
                log.info ("session.createQuery passed");
                log.info("recommendation queried and put into List.");
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
     * Pulls single recommendation from database through hibernate interface
     * @return recommendation
     * @throws java.lang.ClassNotFoundException
     */
    public List<recommendation> getAReco(int id) throws RecoException, ClassNotFoundException {
        
        {
            int i = id;
            List<recommendation> theApplications = null;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("getAReco - RecoSvcHibernateImpl.java");
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            { 
                session.beginTransaction();
                log.info ("beginTransaction");
                String hql = "from recommendation where consumerID = :id";   
                System.out.println(hql);
                Query query = session.createQuery(hql);
                query.setParameter("id", i);
                List result = query.list();
                System.out.println("resultset:"+result);
                theApplications = result;
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
    * Updates recommendation object received from GUI and put in database
    * @return boolean
    */
  public boolean updateReco(recommendation recommendation)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("updateReco - RecoSvcHibernateImpl.java");
            // updateApplication takes in an application object
            // this object includes the updates received and that need to be stored in the db
            recommendation appdb  = recommendation;
            // create a new recommendation object.  This is where the current recommendation object gets stored and 
            // will be used to make updates and store back in the db
            recommendation appnew = null;
            Session session = fetchSession();  
            log.info ("fetched session");
            
            try 
            {
                Transaction tx = session.beginTransaction();
                log.info(appdb.toString());
                log.info ("beginTransaction, Getting recommendation with recoID:" + appdb.getRecoID());
                // retrieve the current recommendation object from the database
                appnew = session.get(recommendation.class, appdb.getRecoID());
                // update all fields in the current recommendation object except the PK of RecoID  
                
                appnew.setRecoDate(appdb.getRecoDate());
                appnew.setRecoWeight(appdb.getRecoWeight());
                appnew.setConsumerId(appdb.getConsumerId());
                appnew.setProviderId(appdb.getProviderId());
                appnew.setProviderName(appdb.getProviderName());
                appnew.setLocationZip(appdb.getLocationZip());
                appnew.setDemographic(appdb.getDemographic());
                appnew.setAdID(appdb.getAdID());
                appnew.setAdURL(appdb.getAdURL());
                appnew.setAdPCC(appdb.getAdPCC());
                appnew.setAdOwner(appdb.getAdOwner());

                log.info(appnew.toString());
		System.out.println("Updating recommendation...");
                // recommendation object is updated in the db based on the Primary Key that was unchanged
                session.saveOrUpdate(appnew);
                tx.commit();
                //session.update(appnew);
                log.info("recommendation updated. Check database for data!");
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
     * @param recommendation
     * @return boolean of recommendation
     */
    public boolean deleteReco(recommendation recommendation)
        {
          boolean status = true;
            log.info("-------------------------------");
            log.info("Using Hibernate Implementation");
            log.info("-------------------------------");
            log.info ("deleteReco - RecoSvcHibernateImpl.java");
            recommendation appdb  = recommendation;
            Session session = fetchSession();
            log.info ("fetched session");
            
            try 
            {
                Transaction tx = session.beginTransaction();
                log.info ("beginTransaction");
                session.delete(appdb);
                log.info ("session.delete(recommendation passed in)");
                log.info("recommendation deleted. Check database for data not there!");
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
                // tx.commit;
                // added this line to fix session closing
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
