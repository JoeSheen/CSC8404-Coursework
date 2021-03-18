package uk.ac.ncl.manager.department;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author Joe Sheen
 * @version 1.1 29/10/20202
 * 
 * SmartCard - class for creating and managing instances of
 * smart cards that are allocated the students.
 *
 */

public class SmartCard {
	private Name studentName;
	private Date dateOfBirth;
	private SmartCardNumber smartCardNumb;
	private Date dateOfIssue;
	private StudentID studentId;
	private Date expiryDate;

	/**
	 * Constructs a SmartCard for a student
	 * 
	 * @param studentName is the name of the student
	 * @param dateOfBirth is the students date of birth
	 * @param dateOfIssue is the date of issue for the smart card
	 * @param studentId is the studentID that has been allocated to the student
	 * @param studentType is the type of the student (e.g. UG, PGT, PGR)
	 * 
	 * @throws IllegalArgumentException if <code>dateOfBirth</code> is after <code>dateOfIssue</code>
	 * 
	 */
	public SmartCard(Name studentName, Date dateOfBirth, Date dateOfIssue, StudentID studentId, StudentType studentType) {
		if(dateOfBirth.after(dateOfIssue))
			throw new IllegalArgumentException("Error: Date of birth cannot be after date of issue");
		
		this.studentName = new Name(studentName.getFirstName(), studentName.getLastName());
		this.dateOfBirth = new Date(dateOfBirth.getTime());
		smartCardNumb = SmartCardNumber.getInstance(studentName, dateOfIssue);
		this.dateOfIssue = new Date(dateOfIssue.getTime());
		this.studentId = studentId;
		setExpiryDate(dateOfIssue, studentType);
	}
	
	/**
	 * Gets the <code>studentName</code>field.
	 * @return Returns a defensive copy of the <code>studentName</code>field.
	 */
	public Name getStudentName() {
		return new Name(studentName.getFirstName(),studentName.getLastName());
	}
	
	/**
	 * Gets the <code>dateOfBirth</code>field.
	 * @return Returns a defensive copy of the <code>dateOfBrith</code>field.
	 */
	public Date getDateOfBirth() {
		return (Date) dateOfBirth.clone();
	}
	
	/**
	 * Gets the <code>smartCardNumb</code> field.
	 * @return Returns the <code>smartCardNumb</code>field.  
	 */
	public SmartCardNumber getScn() {
		return smartCardNumb;
	}
	
	/**
	 *  Gets the <code>dateOfIssue</code>field.
	 * @return Returns a defensive copy of the <code>dateOfIssue</code>field.
	 */
	public Date getDateOfIssue() {
		return (Date) dateOfIssue.clone();
	}
	
	/**
	 * Gets the <code>studentId</code>field.
	 * @return Returns the <code>studentId</code>field.  
	 */
	public StudentID getStudentID() {
		return studentId;
	}
	
	/**
	 * Gets the <code>expiryDate</code>field.
	 * @return Returns a defensive copy of the <code>expiryDate</code>field.
	 */
	public Date getExpiryDate() {
		return (Date) expiryDate.clone();
	}
	
	/**
	 * Sets the <code>expiryDate</code>field.
	 * 
	 * @param dateOfIssue is the Date of the day the card was issued to the student
	 * @param studentType is the type of student (indicates the length of validity for the card)
	 * 
	 * @throws IllegalArgumentException if <code>student</code> has invalid type.
	 */
	private void setExpiryDate(Date dateOfIssue, StudentType studentType) {
		//Creates a calendar object from the dateOfIssue so that expiryDates can be generated 
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateOfIssue);
		
		//Add the correct number of years onto the date of issue for the expiry date
		if(studentType == StudentType.UG) {
			//adds on for years from date of issue 
			cal.set((cal.get(Calendar.YEAR)+4), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
			expiryDate = cal.getTime();
		}
		else if(studentType == StudentType.PGT) {
			///adds on for years from date of issue 
			cal.set((cal.get(Calendar.YEAR)+2), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
			expiryDate = cal.getTime();
		}
		else if(studentType == StudentType.PGR) {
			////adds on for years from date of issue 
			cal.set((cal.get(Calendar.YEAR)+5), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
			expiryDate = cal.getTime();
		} 
		else {
			//if student type isn't UG, PGT, PGR throw exception
			throw new IllegalArgumentException("Error: Student type not recognized");
		}
	}
	
	/**
	 * Converts a SmartCard object to a string
	 * @return Returns a string representation of a SmartCard object
	 */
	@Override
	public String toString() {
		return studentName + "," + dateOfBirth + "," + smartCardNumb
				+ "," + dateOfIssue + "," + studentId + "," + expiryDate;
	}	
	
}
