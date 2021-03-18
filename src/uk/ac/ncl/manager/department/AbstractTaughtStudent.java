package uk.ac.ncl.manager.department;

import java.util.Date;
import java.util.Set;

/**
 * 
 * @author Joe Sheen
 * @version 30/10/2020
 * 
 * AbstractTaughtStudent - abstract (partial) implementation for taught students 
 * (all but PGR students).
 *
 */

public abstract class AbstractTaughtStudent implements Student {
	private Name studentName;
	private Date dateOfBrith;
	private StudentType studentType;
	private StudentID studentID;
	private SmartCard smartCard;
	private Set<Modules> modules;
	
	//-------- PACKAGE-PRIVATE METHODS --------\\
	/**
	 * Package-private Constructor
	 * 
	 * @param studentName is the name of the student
	 * @param dateOfBirth is the students date of birth
	 * @param studentType is the type of the student (e.g. UG, PGT)
	 * 
	 * @throws IllegalArgumentException if <code>dateOfBirth</code> has not been provided.
	 * @throws IllegalArgumentException if <code>studentType</code> is not valid
	 */
	AbstractTaughtStudent(Name studentName, Date dateOfBirth, StudentType studentType) {
		if(dateOfBirth == null)
			throw new IllegalArgumentException("Error: Invalid date of birth is invalid");
		
		this.studentName = new Name(studentName.getFirstName(), studentName.getLastName());
		this.dateOfBrith = new Date(dateOfBirth.getTime());
		this.studentType = studentType;
	}
	
	/**
	 * Sets the modules that a Taught Student takes
	 * @throws IllegalArgumentException if <code>modules</code> is an empty set
	 */
	void setModules(Set<Modules> modules){
		if(modules.isEmpty() == true)
			throw new IllegalArgumentException("Error: Invalid modules");
		
		this.modules = modules;
	}
	
	/**
	 * Sets the <code>studentID</code> field.
	 * @param studentID is the ID that has just been created
	 * for the student
	 */
	void setStudentID(StudentID studentID) {
		this.studentID = studentID;
	}
	
	/**
	 * Sets the <code>smartCard</code> field.
	 * @param smartCard is the smart card that has just been created
	 * for the student
	 */
	void setSmartCard(SmartCard smartCard) {
		this.smartCard = smartCard;
	}
	
	//-------- PUBLIC METHODS --------\\
	/**
	 * Gets the <code>studentID</code>field.
	 * @return Returns the <code>studentID</code>field.
	 */
	@Override
	public StudentID getStudentID() {
		return studentID;
	}

	/**
	 * Gets the <code>studentType</code>field.
	 * @return Returns <code>studentType</code> field.
	 */
	@Override
	public StudentType getStudentType() {
		return studentType;
	}

	/**
	 * Gets the <code>modules</code>field.
	 * @return Returns <code>modules</code> field.
	 */
	@Override
	public Set<Modules> getListModules() {
		return modules;
	}

	/**
	 * Gets the <code>studentName</code>field.
	 * @return Returns a copy <code>studentName</code> field.
	 */
	@Override
	public Name getName() {
		return new Name(studentName.getFirstName(), studentName.getLastName());
	}

	/**
	 *  Gets the <code>dateOfBirth</code>field.
	 *  @return Returns a copy <code>dateOfBirth</code> field.
	 */
	@Override
	public Date getDateOfBirth() {
		return (Date) dateOfBrith.clone();
	}

	/**
	 * Gets the <code>smartCard</code>field.
	 * @return Returns the <code>smartCard</code> field.
	 */
	@Override
	public SmartCard getSmartCard() {
		return smartCard;
	}
	
	//-------- ABSTRACT METHODS --------\\
	/**
	 * Abstract method that is implemented in UGStudent and PGTstudent
	 * @return Returns a boolean to indicate if a student is registered for enough credits 
	 */
	@Override
	public abstract boolean enoughCredits();
	
	/**
	 * Abstract method that is implemented in UGStudent and PGTstudent
	 * @return Returns the passMark value for UGStudents and PGTstudents
	 */
	public abstract String getPassMark();
	
}
