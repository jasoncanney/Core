package com.canopyaudience.model.services.exception;

import java.io.FileNotFoundException;

/** 
*/


/** 
 @author Jason L. Canney
 
*/


public class IntException extends RuntimeException
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
	public IntException(String string, RuntimeException ioeinMessage)
	{
		super(inMessage, inNestedException);
		System.out.println("IO Exception - IntSvcxxxImpl");

	}

	/** 
	 @param string 
	 @param fnfe 
	*/
	public IntException(String string, FileNotFoundException fnfe)
	{
		super(inMessage, inNestedException);
		System.out.println("File Not Found - IntSvcxxxImpl");

	}

	/** 
	 @param string 
	*/
	public IntException(String string)
	{
		super(inMessage, inNestedException);
	}

}