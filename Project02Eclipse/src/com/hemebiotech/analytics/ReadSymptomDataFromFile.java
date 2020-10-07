package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * ReadSymptomDataFromFile is an utilitarian class that generate a file
 * containing the symptoms and their iteration's number
 * 
 * @author Caroline ,Raviz� Aymeric
 * @version V1.1
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 * 
	 * @author Raviz� Aymeric
	 * @version V1.0
	 * @since V1.1
	 * 
	 * @param filepath is the destination of the file that we want to read.
	 * @return a HashMap containing the list of the symptoms and their occurence
	 *         number.
	 * 
	 */
	public static HashMap<String, Integer> GetSymptoms(String filepath) {

		HashMap<String, Integer> symptoms = new HashMap<String, Integer>();

		if (filepath != null) {
			// in 1.7 java and after the declared resources are implicitly closed.
			try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
				// read first line of document
				String line = reader.readLine();

				while (line != null) {

					if (symptoms.containsKey(line)) {
						// if symptom exists in HashMap increment counter
						symptoms.replace(line, (int) symptoms.get(line) + 1);
					} else {
						// if symptom not exists in HashMap set counter to 1
						symptoms.put(line, 1);
					}
					// read next line
					line = reader.readLine();
				}
				reader.close();
			} catch (FileNotFoundException e) {
				System.out.println("Error : file not found");
			} catch (IOException e) {
				System.out.println("Error : file not compliant");
			}

		}
		return symptoms;
	}

	/**
	 * 
	 * @author Raviz� Aymeric
	 * @version V1.0
	 * @since V1.1
	 * 
	 * @param symptoms    is a HashMap of the symptoms to read
	 * @param newFilePath is the name of the new file that we want to create and
	 *                    complete
	 * 
	 */
	public static void WriteSymptoms(HashMap<String, Integer> symptoms, String newFilePath) {
		// sort of Hashmap when creating the iterator
		Iterator it = symptoms.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey()).iterator();
		// in 1.7 java and after the declared resources are implicitly closed.
		// create the output file
		try (FileWriter writer = new FileWriter(newFilePath)) {

			writer.write("");
			while (it.hasNext()) {
				// getting the next item
				Map.Entry m = (Map.Entry) it.next();
				writer.append(m.getKey() + ":" + m.getValue() + "\n");

			}
			writer.close();
		} catch (ReadOnlyFileSystemException e) {
			System.out.println("Error : file read-only");
		} catch (IOException e) {

			System.out.println("Error : file not compliant");
		}

	}

	/**
	 * 
	 * @author Raviz� Aymeric
	 * @version V1.0
	 * @since V1.1
	 * 
	 * @param oldFilePath is the file to read destination.
	 * @param newFilePath is the name of the new file that we want to create and
	 *                    complete.
	 * @see WriteSymptoms calls GetSymptoms with the parameter oldFilePath and
	 *      executes WriteSymptoms(HashMap,String) with the value that it send back
	 *      and the parameter newFilePath.
	 * 
	 */
	public static void WriteSymptoms(String oldFilePath, String newFilePath) {
		WriteSymptoms(GetSymptoms(oldFilePath), newFilePath);
	}

}
