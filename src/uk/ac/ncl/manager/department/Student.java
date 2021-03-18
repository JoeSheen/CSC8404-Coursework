package uk.ac.ncl.manager.department;

import java.util.Date;
import java.util.Set;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 30/10/2020
 * 
 * Student - interface to all student types
 * (methods all must implement)
 * 
 */

public interface Student {
	
	/**
	 * Gets the <code>studentID</code>field.
	 * @return Returns the <code>studentID</code> field.
	 */
	public StudentID getStudentID();
	
	/**
	 * Gets the <code>studentType</code>field.
	 * @return Returns the the <code>studentType</code>field.
	 */
	public StudentType getStudentType();
	
	/**
	 * Lists the modules that a student is taking. 
	 * @return Returns <code>modulesList</code> field.
	 */
	public Set<Modules> getListModules();
	
	/**
	 * Checks a student is taking enough modules.
	 * @return Returns a boolean to indicated that a 
	 * student is taking enough modules.
	 */
	public boolean enoughCredits();
	
	/**
	 * Gets the <code>studentName</code>field.
	 * @return Returns the <code>studentName</code> field.
	 */
	public Name getName();
	
	/**
	 * Gets the <code>dateOfBirth</code> field.
	 * @return Returns the <code>dateOfBirth</code>field.
	 */
	public Date getDateOfBirth();
	
	/**
	 * Gets the <code> smartCard</code>field.
	 * @return Returns the <code>smartCard</code>field. 
	 */
	public SmartCard getSmartCard();
	
}
