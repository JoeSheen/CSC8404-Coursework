package uk.ac.ncl.manager.department;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 29/10/2020
 * 
 * StudentID - factory for generating unique 
 * IDs for all types of students. 
 * These IDs have the following format: lower case prefix followed four digits  
 * 
 * Note: uniqueness is ensured by using object factory design pattern
 * 
 */

public class StudentID {
	private char prefix;
	private int idNumber;
	
	//private static variables for used to generate unique StudentID values
	private static char generatePrefix = 'a';
	private static int generateIdNumber = -1;
	
	//STUDENT_ID_LIST: list used for storing instantiated StudentIDs 
	private static final Map<String, StudentID> STUDENT_ID_MAP = new HashMap<String, StudentID>();
	
	/**
	 * Constructs a StudentID when provided with a prefix
	 * and a four digit number.
	 *  
	 * @param prefix for the ID
	 * @param idNumber for digit value of the ID 
	 * 
	 * Note: constructor is private and accessed through getInstance()
	 */
	private StudentID(char prefix, int idNumber) {
		this.prefix = prefix;
		this.idNumber = idNumber;
	}
	
	/**
	 * Generates a unique StudentID using the object factory design pattern 
	 * @return Returns a newly created unique StudentID  
	 */
	public static StudentID getInstance() {
		if(generateIdNumber >= 9999) {
			if(generatePrefix >='z') {
				//error thrown due to reaching student card limit 
				throw new RuntimeException("Error: Student ID limit reached");
			} else {
				//resets the idNumber and increments prefix 
				generateIdNumber = -1;
				generatePrefix = ((char) (generatePrefix + 1));
			}
		}
		
		//generates a key for map ("" turns generatePrefix + (generateIdNumber++) into string)
		final String key = "" + generatePrefix + (generateIdNumber++);
		
		//check to see if key is not in map then creates a studentID base of the key
		if(!STUDENT_ID_MAP.containsKey(key))
			STUDENT_ID_MAP.put(key, new StudentID(generatePrefix, generateIdNumber));
		
		//Returns newly created StudentID
		return STUDENT_ID_MAP.get(key);
	}

	/**
	 * Gets the <code>prefix</code>field.
	 * @return Returns the <code>prefix</code>field of the StudentID
	 */
	public char getPrefix() {
		return prefix;
	}

	/**
	 * Gets the <code>idNumber</code>field.
	 * @return returns the <code>idNumber</code> field of the StudentID
	 */
	public int getIdNumber() {
		return idNumber;
	}
	
	/**
	 * Computes an integer hash code for a StudentID object
	 * @return Returns an integer hash value of a StudentID object
	 */
	@Override
	public int hashCode() {
		int hc = 17;
		
		hc = 37 * hc + prefix;
		return 37 * hc + idNumber;
	}
	
	/**
	 * Compares logical equivalence of StudentID object
	 * @return Returns boolean to indicate if StudentIDs are logically equivalent
	 */
	@Override
	public boolean equals(Object rhs) {
		if(this == rhs)
			return true;
		
		if(!(rhs instanceof StudentID))
			return false;
		
		StudentID studentId = (StudentID) rhs;
		
		return prefix == studentId.prefix &&
				idNumber == studentId.idNumber;
	}

	/**
	 * Converts a string object into a StudentID
	 * @param string object to be converted into StudentID
	 * @return returns a studentID
	 * @throws IllegalArgumentException if input doesn't match StudentID format or
	 * if the ID has already been created and allocated to a student
	 */
	public static StudentID valueOf(String s) {
		//determines if the string matches the pattern required for StudentIDs 
		boolean matches = Pattern.matches("[a-z][0-9]{4}", s);
		if(!matches)
			throw new IllegalArgumentException("Error: invalid StudentID format");
		
		//gets the prefix letter from the string
		final char prefix = s.charAt(0);
		
		//converts the remainder of the string to and int
		final int idNumber = Integer.parseInt(s.substring(1,5));
		
		//creates key for map
		final String key = "" + prefix + idNumber;
		
		//checks if the studentID has already been allocated (e.g. its in the map)
		if(STUDENT_ID_MAP.containsKey(key))
			throw new IllegalArgumentException("Error: StudentID has already been allocated");
		
		//creates and returns a new ID if not in map
		STUDENT_ID_MAP.put(key, new StudentID(prefix, idNumber));
		return STUDENT_ID_MAP.get(key);
	}
	
	/**
	 * Provides a string representation of a StudentID object
	 * @return Returns a string representation of a StudentID
	 * String.format has been used to ensure that the StudentID has the format:
	 * <code>prefix</code>followed by a passed four digit number <code>idNumer</code>
	 */
	@Override
	public String toString() {
		return String.format("%c%04d", prefix, idNumber);
	}

}
