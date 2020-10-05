package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

/**
 * main class AnalyticsCounter
 * @author Caroline ,Raviz� Aymeric
 * @version V1.1
 *
 */
public class AnalyticsCounter {
	
	/**
	 * 
	 * @author Raviz� Aymeric
	 * @version V1.0
	 * @since V1.1
	 * 
	 * @see main call the function static WriteSymptoms(String,String) of the class ReadSymptomDataFromFile
	 *                  
	 */
	
	public static void main(String args[]) throws Exception {
		
		ReadSymptomDataFromFile.WriteSymptoms("Project02Eclipse/symptoms.txt","result.out");
				
	}
}
