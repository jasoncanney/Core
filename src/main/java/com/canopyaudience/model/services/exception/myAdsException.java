package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/** 
*/


/** 
 @author Jason L. Canney
 
 
 
*/

public class myAdsException extends RuntimeException
{

	/** @param serialVersionUID = unique identifier 
	 @param Throwable exception 
	 @param inMessage is a string 
	*/
	private static final long serialVersionUID = 1L;
	private static RuntimeException inNestedException;
	private static String inMessage;

	/** 
	 @param string 
	 @param ioeinMessage 
	*/
	public myAdsException(String string, IOException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - myAdSvcxxxImpl");
	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public myAdsException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - myAdSvcxxxImpl");
	}

	/** 
	 @param string 
	*/
	public myAdsException(String string)
	{
		super(inMessage);
	}

}