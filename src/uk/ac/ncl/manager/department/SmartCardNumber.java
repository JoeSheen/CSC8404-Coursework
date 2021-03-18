package uk.ac.ncl.manager.department;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 29/10/2020
 * 
 * SmartCardNumber - factory for generating unique 
 * smart card numbers for students. These number have the
 * following format: students initials - year of issue - serial number 
 * 
 */

public class SmartCardNumber {
	private final String initials;
	private final int yearOfIssue;
	private final int serialNumber;
	
	//NUMBERS: is a map used for holding instantiated smart card numbers (SmartCardNumber)
	private static final Map<String, SmartCardNumber> NUMBERS = new HashMap<String, SmartCardNumber>();

	/**
	 * Constructs a SmartCardNumber using the Students initials, 
	 * the year of issue and a serial number 
	 *  
	 * @param initials is the initials of the student
	 * @param yearOfIssue is the year of issue for the card
	 * @param serialNumber is a serial number that helps ensure uniqueness
	 * 
	 * Note: all three components together ensure uniqueness
	 */
	private SmartCardNumber(String initials, int yearOfIssue, int serialNumber) {
		this.initials = initials;
		this.yearOfIssue = yearOfIssue;
		this.serialNumber = serialNumber;
	}
	
	/**
	 * Generates a unique SmartCardNumber using the object factory design pattern
	 * 
	 * @param studentName is the Name of the student and allows the initials to be generated 
	 * @param dateOfIssue is the Date of issue for the smart card (year only)
	 * 
	 * @return Returns a new unique SmartCardNumber for a students smart card
	 */
	public static SmartCardNumber getInstance(Name studentName, Date dateOfIssue) {
		//creates the initials based on the Name of the student passed into the getInstance method
		final String initials = studentName.getFirstName().substring(0, 1) +
				studentName.getLastName().substring(0, 1);
		
		//Generates the year of issue based on the dateOfIssue passed into the method
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateOfIssue);
		final int yearOfIssue = calendar.get(Calendar.YEAR);
		
		/*serial number to ensure uniqueness for 
		multiple SmartCardNumber created on the same day for students with the same initials*/
		int serialNumber = 0;
		
		//increments the serial number if the key is already contained in the NUMBERS map
		while(NUMBERS.containsKey(initials + yearOfIssue + serialNumber))
			serialNumber++;
		
		//creates key for storing NUMBERS map 
		final String key = initials + yearOfIssue + serialNumber;
		
		//checks that the number hasn't been created already
		if(!NUMBERS.containsKey(key))
			NUMBERS.put(key, new SmartCardNumber(initials, yearOfIssue, serialNumber));
		
		//Returns SmartCardNumber
		return NUMBERS.get(key);
		
	}

	/**
	 * Gets the <code>initials</code>field.
	 * @return Returns the <code>initials</code>field.
	 */
	public String getInitials() {
		return initials;
	}

	/**
	 * Gets the <code>yearOfIssue</code>field.
	 * @return Returns the <code>yearOfIssue</code>field.
	 */
	public int getYearOfIssue() {
		return yearOfIssue;
	}

	/**
	 * Gets the <code>serialNumber</code>field.
	 * @return Returns the <code>serialNumber</code>field.
	 */
	public int getSerialNumber() {
		return serialNumber;
	}
	
	/**
	 * Computes an integer hash code for a SmartCardNumber object
	 * @return Returns an integer has value of a SmartCardNumber object
	 */
	@Override
	public int hashCode() {
		int hc = 17;
		
		hc = 37 * hc + ((initials == null) ? 0 : initials.hashCode());
		hc = 37 * hc + yearOfIssue;
		return 37 * hc + serialNumber;
	}

	/**
	 * Compares logical equivalence of SmartCardNumbers
	 * @return Returns boolean to indicate if SmartCardNumbers are logically equivalent
	 */
	@Override
	public boolean equals(Object rhs) {
		if(this == rhs)
			return true;
		
		if(!(rhs instanceof SmartCardNumber))
			return false;
		
		SmartCardNumber scn = (SmartCardNumber) rhs;
		
		return (initials == null ? scn.initials == null 
				: initials.equals(scn.initials)) && 
				yearOfIssue == scn.yearOfIssue && serialNumber == scn.serialNumber;
	}

	/**
	 * Returns the SmartCardNumber as a string with the fields 
	 * separated by dashes "-".  
	 * @return Returns a string representation of a SmartCardNumber 
	 */
	@Override
	public String toString() {
		return initials.toUpperCase() + "-" + yearOfIssue + "-" + serialNumber;
	}
	
}
