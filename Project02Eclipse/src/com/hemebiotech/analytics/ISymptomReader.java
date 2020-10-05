package com.hemebiotech.analytics;

import java.util.HashMap;




/**
 * 
 * The implemented classes should contain a sorting method and a document generating method 
 * 
 * @author Caroline ,Ravizé Aymeric
 * @version V1.1
 * 
 */
public interface ISymptomReader {
	/**
	 * 
	 * @author Ravizé Aymeric
	 * @version V1.0
	 * 
	 * If no data is available, return null
	 * @param FilePath is the path to the file that we want to read
	 * @return a HashMap with the symptoms and their occurrence
	 * 
	 */
	
	static HashMap<String ,Integer> GetSymptoms(String FilePath) {
		return null;
	}
	/**
	 * 
	 * This function must edit/create a file to put the symptoms and their occurence in alphabetical order.
	 *  
	 * @author Ravizé Aymeric
	 * @version V1.0
	 * 
	 * @param symptoms is a HashMap with the symptoms and their occurence
	 * @param newFilePath is the file to edit/create name
	 * 
	 */
	static void WriteSymptoms(HashMap<String, Integer> symptoms, String newFilePath) {
	}
	
	
	

	
	
}
