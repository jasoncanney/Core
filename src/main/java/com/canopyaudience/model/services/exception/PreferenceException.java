package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;

/** 
*/


/** 
 @author Jason L. Canney
 
*/


public class PreferenceException extends RuntimeException
{

	/** 
	*/
	private static final long serialVersionUID = 1123523456523L;
	private static RuntimeException inNestedException;
	private static String inMessage;

	/** 
	 @param string 
	 @param ioeinMessage 
	*/
	public PreferenceException(String string, RuntimeException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - PreferenceSvcxxxImpl");

	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public PreferenceException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - ConsumerSvcxxxImpl");

	}

	/** 
	 @param string 
	*/
	public PreferenceException(String string)
	{
		super(inMessage, inNestedException);
	}

}