package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;

/** 
*/


/** 
 @author Jason L. Canney
 
*/


public class RecoException extends RuntimeException
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
	public RecoException(String string, RuntimeException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - PreferenceSvcxxxImpl");

	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public RecoException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - ConsumerSvcxxxImpl");

	}

	/** 
	 @param string 
	*/
	public RecoException(String string)
	{
		super(inMessage, inNestedException);
	}

}