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
                theRecommendations = recmgr.GetA(id);
                log.info (theRecommendations);
                theAdvertisements = advertmgr.Get();
                
                int count = 0;                                                          // counter for main algorithm loop
                int weight = 0;                                                         // weight counter for updating recommendation weights in main algorithm
                preference p = new preference();                                        // create new preference object
                recommendation r = new recommendation();                                // create new recommendation object
                adimpression a = new adimpression();                                    // create new adimpression object
                
                while (count < thePreferences.size()) {                                 // start of main canopy audience recommendation weighting loop - patent logic
                   
                   p = thePreferences.get(count);                                       // pull out current preference for using in algorithm 
                   
                   
                   // Need to put these two loops into separate functions and pass in the choice and +/- value to increment or decrement
                   
                   if (p.getPreferenceChoice()==1){                                     // If current preference is positive then
                       if (theRecommendations.contains(p.getAdvertisementID())){        // if current Recommendations list contains preference AdID then
                           r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                           weight =  r.getRecoWeight();                                 // get current weight of recommendation
                           weight++;                                                    // increment recommendation weight +1
                           r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                           theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation
                           if (theAdvertisements.contains(a.getAdPCC()) && {  // this logic is wrong.  
                               r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                               weight =  r.getRecoWeight();                                 // get current weight of recommendation
                               weight++;                                                    // increment recommendation weight +1
                               r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                               theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation
                           }
                       }
                       if(p.getPreferenceChoice()==0){                                  // If current preference is negative then
                           if (theRecommendations.contains(p.getAdvertisementID())){    // if current Recommendations list contains preference AdID then
                               r = theRecommendations.get(p.getAdvertisementID());      // pull that recommendation with the matching AdID into a recommendation domain object
                               weight =  r.getRecoWeight();                             // get current weight of recommendation
                               weight--;                                                // decrement recommendation weight -1
                               r.setRecoWeight(weight);                                 // store the weight back in the recommendation object
                               theRecommendations.set(count, r);                        // replace the previous recommendation with the updated weighted recommendation
                           }
                           if (!theAdvertisements.contains(p.getAdvertisementID())){        // Look up whether current preference AdID is in the 
                               r = theRecommendations.get(p.getAdvertisementID());          // pull that recommendation with the matching AdID into a recommendation domain object
                               weight =  r.getRecoWeight();                                 // get current weight of recommendation
                               weight = weight -2;                                          // decrementcrement recommendation weight -2 
                               r.setRecoWeight(weight);                                     // store the weight back in the recommendation object
                               theRecommendations.set(count, r);                            // replace the previous recommendation with the updated weighted recommendation 
                           
                       } else {
                          // put in logic here for error handling and logging to identify that a choice was not either 1 or 0
                       }
                   } 
                    
                
                    // Is thePreference[count] positive or negative
                    // Does thePreferences[count] exist in theRecommendations list
                    // If yes and If preference positive, increment theRecommendations weight value +1
                    // If yes and if preference negative, decrement theRecommendation weight -2
                    // If no and If preference positive, add new recommendation with a negative weighting
                    
                    // for thePreference[count].advertisementID, Look-up adPCC in advertisement table
                    // does consumerID + adPCC exist in theAdImpressions
                    // If yes and preference positive, increment theRecommendations weight value +1
                    // If yes and preference negative, decrement theRecommendation weight -2 
                    
                    // Store recommendations to database
                    
                    count++;
                }
                
                
                
                
                
                
                
		return true;
	}
        
        
        
    
    
}
