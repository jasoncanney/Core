/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.canopyaudience.model.business.manager;

import com.canopyaudience.model.domain.adimpression;
import com.canopyaudience.model.domain.advertisement;
import com.canopyaudience.model.domain.preference;
import com.canopyaudience.model.domain.recommendation;
import com.canopyaudience.model.services.exception.PreferenceException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
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
                
                int count = 0;                                                          // counter for main algorithm loop
                int weight = 0;                                                         // weight counter for updating recommendation weights in main algorithm
                String adPCC;
                preference p = new preference();                                        // create new preference object
                recommendation r = new recommendation();                                // create new recommendation object
                adimpression a = new adimpression();                                    // create new adimpression object
                advertisement advert = new advertisement();                             // create new advertisement object
                
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
                           // ZonedDateTime now = ZonedDateTime.now( ZoneOffset.UTC );
                           // Instant instant = Instant.now();
                           ZonedDateTime now = ZonedDateTime.now(ZoneOffset.UTC);
                           r.setRecoDate(now);
                           r.setRecoWeight(1);
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(/*need to put this in one of the above tables*/);        // create a provider table with id and name.  put provider ID in consumer domain layer
                           r.setProviderName(/*need to put this in one of the above tables*/);      // same as above
                           r.setLocationZip(/*need to put this in preference object*/);              // put this in preference database / domain layer
                           r.setDemographic(/*put this value in one of the above tables?*/);        // create a demographic table.  put demographic ID in consumer table
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
                           r.setRecoDate(/*set to current data and time*/);
                           r.setRecoWeight(-1);
                           r.setConsumerId(p.getConsumerId());
                           r.setProviderId(/*need to put this in one of the above tables*/);
                           r.setProviderName(/*need to put this in one of the above tables*/);
                           r.setLocationZip(/*need to put this in preference object*/);
                           r.setDemographic(/*put this value in one of the above tables?*/);
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
