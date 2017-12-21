/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.domain.consumer;
import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.domain.recommendation;
import com.canopyaudience.model.domain.provider;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Jason
 */
public class RecoBuilder {
    
        // create reference to the actual config file
        // ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});   
        
        //create an instance of the preference business manager object
        preferenceManager prefmgr = new preferenceManager();
        //create an instance of the adimpression business manager object
        adImpManager admgr = new adImpManager();
        //create an instance of the recommendation business manager object
        recoManager recmgr = new recoManager();
        //create an instance of the advertisement business manager object
        adManager advertmgr = new adManager();
        // create an instance of the consumer business manager object
        consumerManager conmgr = new consumerManager();
        // create an instance of the provider business manager object
        providerManager provmgr = new providerManager();
        
        /*
	* Category set in config/log4j.properties as
	* log4j.category.com.classexercise=DEBUG, A1
	*/
        static Logger log = Logger.getLogger("RecoBuilder.class");
        
        
        
        
        
        
        
        
        
        /** 
	 Business use case for "Build Recommendations"
        * @param id	 
        * @return 	 
        * @throws java.lang.ClassNotFoundException	 
	*/
	public final boolean BuildNewRecsForAUser(int id) throws PreferenceException, ClassNotFoundException
	{
                int i = id;
                int count = 0;                                                          // counter for main algorithm loop
                int weight = 0;                                                         // weight counter for updating recommendation weights in main algorithm
                String adPCC;
                preference p = new preference();                                        // create new preference object
                recommendation r = new recommendation();                                // create new recommendation object
                adimpression a = new adimpression();                                    // create new adimpression object
                advertisement advert = new advertisement();                             // create new advertisement object
                consumer con = new consumer();                                          // create new consumer object
                provider prov = new provider();                                         // create a new provider object
                
                List<preference> thePreferences = null;
                List<adimpression> theAdImpressions = null;
                List<recommendation> theRecommendations = null;
                List<advertisement> theAdvertisements = null;

		thePreferences = prefmgr.GetAList(id);
                log.info (thePreferences);
                theAdImpressions = admgr.GetAList(id);
                log.info (theAdImpressions);
                theRecommendations = recmgr.GetA(id);                                   // Retrieve all recommendations for this user from the database
                recmgr.DeleteAllRecos(theRecommendations);                              // Delete current recommendations for this user from the database Note: List still exists and will be restored to the DB at the end of this class
                log.info (theRecommendations);
                theAdvertisements = advertmgr.Get();
                con = conmgr.GetA(id);                                                  // Retrieve consumer object for this user from the database
                prov = provmgr.GetA(id);                                                // Retrieve provider object for this user from the database
                
                // Start of main patent algorithm to build weighted recommendations
                // Leverages preferences + machine learning to build intelligent recommendations
                // for individual consumers
                
                while (count < thePreferences.size()) {                                 // start of main canopy audience recommendation weighting loop - patent logic
                   
                   p = thePreferences.get(count);                                       // pull out current preference for using in algorithm 
                   advert = theAdvertisements.get(p.getAdvertisementID());              // pull advertisement object from list to get to PCC value
                   adPCC = advert.getAdPCC();                                           // store PCC value 
                                      
                   if (p.getPreferenceChoice()==1){                                     // If current preference is positive then
                       
                       
                       // start of function.  Pass in weight value of 1, 1.  For next function you'll pass in weight of -1 and -2 
                       
                       if (theRecommendations.contains(p.getAdvertisementID())){        // if current Recommendations list contains preference AdID then
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight++;                                                    // increment recommendation weight +1
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation
                    
                           // adimpression logic check section
                           if (theAdImpressions.contains(adPCC)){
                               r = theRecommendations.get(p.getAdvertisementID());      // pull that recommendation with the matching AdID into a recommendation domain object
                               weight =  r.getRecoWeight();                             // get current weight of recommendation
                               weight++;                                                // increment recommendation weight +1
                               r.setRecoWeight(weight);                                 // store the weight back in the recommendation object
                               theRecommendations.set(count, r);                        // replace the previous recommendation with the updated weighted recommendation
                            }  
                        }
                       else {
                           
                           // Build the Recommendation to Create
                           
                           // ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                           Date now = Date.from(Instant.MIN);
                           r.setRecoDate(now);                                                      // Current date stamp
                           r.setRecoWeight(1);
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(con.getProviderID());                                    // Retrieves Provider ID based on current consumer ID
                           r.setProviderName(prov.getProviderName());                               // Retrieves Provider name based on individual consumer ID
                           r.setLocationZip(con.getDeviceLocID());                                  // Retrieves Device Location ID stored in consumer object
                           r.setDemographic(con.getDemoID());                                       // Retrieves demographic identifier stored in consumer object
                           r.setAdID(advert.getAdID());
                           r.setAdPCC(advert.getAdPCC());
                           r.setAdURL(advert.getAdURL());
                           r.setAdOwner(advert.getAdowner());
                           // Add the Recommendation to the List
                           theRecommendations.add(r);
                        }
                    
                   
                   // end of function
                   
                   
                   
                   }
                   if(p.getPreferenceChoice()==0){                                      // If current preference is negative then
                       if (theRecommendations.contains(p.getAdvertisementID())){        // if current Recommendations list contains preference AdID then
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight--;                                                    // decrement recommendation weight -1
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation

                       // adimpression logic check section
                       if (theAdImpressions.contains(adPCC)){
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight = weight -2;                                          // decrementcrement recommendation weight -2 
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation 
                        } 
                        else {
                           // Build the Recommendation to Create

                           Date now = Date.from(Instant.MIN);
                           r.setRecoDate(now);                                                      // Current date stamp                           
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(con.getProviderID());                                    // Retrieves Provider ID based on current consumer ID
                           r.setProviderName(prov.getProviderName());                               // Retrieves Provider name based on individual consumer ID
                           r.setLocationZip(con.getDeviceLocID());                                  // Retrieves Device Location ID stored in consumer object
                           r.setDemographic(con.getDemoID());                                       // Retrieves demographic identifier stored in consumer object
                           r.setAdID(advert.getAdID());
                           r.setAdPCC(advert.getAdPCC());
                           r.setAdURL(advert.getAdURL());
                           r.setAdOwner(advert.getAdowner());
                           // Add the Recommendation to the List
                           theRecommendations.add(r);
                            }
                        } 
                    // Todo: put in logic here for error handling and logging to identify that a choice was not either 1 or 0
                    }
                count++;
            }
            
                // Store all recommendations back into the list
                recmgr.StoreAllRecos(theRecommendations);                               // Note: original recommendations for this user were deleted from the DB above.  there will be no update conflict
            
            return true;
                    // Is thePreference[count] positive or negative
                    // Does thePreferences[count] exist in theRecommendations list
                    // If yes and If preference positive, increment theRecommendations weight value +1
                    // If yes and if preference negative, decrement theRecommendation weight -2
                    // If no and If preference positive, add new recommendation with a negative weighting
                    
                    // (6) for thePreference[count].advertisementID, Look-up adPCC in advertisement table
                    // does consumerID + adPCC exist in theAdImpressions
                    // If yes and preference positive, increment theRecommendations weight value +1
                    // If yes and preference negative, decrement theRecommendation weight -2 
                    
                    // Store recommendations to database  
    }
}
