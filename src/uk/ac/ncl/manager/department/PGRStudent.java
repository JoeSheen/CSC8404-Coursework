package uk.ac.ncl.manager.department;

import java.util.Date;
import java.util.Set;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 30/10/2020
 * 
 * PGRStudent - implementation for PGR students 
 * that have a supervisor and take no modules
 *
 */

public final class PGRStudent implements Student {
	private Name studentName;
	private Date dateOfBirth;
	private StudentType studentType;
	private StudentID studentID;
	private SmartCard smartCard;
	private Set<Modules> modules;
	private Name supervisor;
	
	/**
	 * Constructs a PGRStudent object when provided with the parameters specified
	 * @param studentName is the name of the PGRStudent
	 * @param dateOfBirth is the date of birth for the PGRStudent
	 * @param studentType is the type of the student (e.g. PGR). 
	 * 
	 * @throws IllegalArgumentException if <code>dateOfBirth</code> is null
	 * @throws IllegalArgumentException if <code>studentType</code> is not valid
	 */
	public PGRStudent(Name studentName, Date dateOfBirth, StudentType studentType) {
		if(studentType != StudentType.PGR)
			throw new IllegalArgumentException("Error: Student type is invalid");
		
		if(dateOfBirth == null)
			throw new IllegalArgumentException("Error: Invalid date of birth is invalid");
		
		this.studentName = new Name(studentName.getFirstName(), studentName.getLastName());
		this.dateOfBirth = new Date(dateOfBirth.getTime());
		this.studentType = studentType;
	}
	
	//-------- PACKAGE-PRIVATE METHODS --------\\
	/**
	 * Sets the <code>studentID</code> field.
	 * @param studentID is the ID that has been created for the student
	 */
	void setStudentID(StudentID studentID) {
		this.studentID = studentID;
	}

	/**
	 * Sets the <code>smartCard</code> field.
	 * @param smartCard that has been created for the student
	 */
	void setSmartCard(SmartCard smartCard) {
		this.smartCard = smartCard;
	}

	/**
	 * Sets the <code>supervisor</code>field.
	 * @param supervisor is the Name of the supervisor that has been allocated
	 * 
	 * @throws IllegalArgumentException if <code>supervisor</code> is not valid
	 */
	void setSupervisor(Name supervisor) {
		if((supervisor.getFirstName() == null) || (supervisor.getFirstName().length() == 0))
			throw new IllegalArgumentException("Error: Supervisor first name has not been provided");
		
		if((supervisor.getLastName() == null) || (supervisor.getLastName().length() == 0))
			throw new IllegalArgumentException("Error: Supervisor last name has not been provided");
		
		this.supervisor = supervisor;
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
	 * @return Returns the <code>studentType</code>field.
	 */
	@Override
	public StudentType getStudentType() {
		return studentType;
	}

	/**
	 * Gets the <code>null</code>.
	 * @returns Returns the <code>null</code>.
	 */
	@Override
	public Set<Modules> getListModules() {
			return null;
	}

	/**
	 * Check a student is taking enough modules
	 * @return a boolean to indicating if a PGRStudent is taking 0 modules 
	 */
	@Override
	public boolean enoughCredits() {
		if(modules == null)
			return true;
		else
			return false;
	}
	
	/**
	 * Gets the <code>studentName</code>field.
	 * @return Returns the <code>studentName</code> field.
	 */
	@Override
	public Name getName() {
		return new Name(studentName.getFirstName(), studentName.getLastName());
	}
	
	/**
	 * Gets the <code>dateOfBirth</code> field.
	 * @return Returns the <code>dateOfBirth</code>field.
	 */
	@Override
	public Date getDateOfBirth() {
		return (Date) dateOfBirth.clone();
	}
	
	/**
	 * Gets the <code> smartCard</code>field.
	 * @return Returns the <code>smartCard</code>field. 
	 */
	@Override
	public SmartCard getSmartCard() {
		return smartCard;
	}
	
	/**
	 * Gets the <code>supervisor</code> field.
	 * @return Returns the <code>supervisor</code>field.
	 */
	public Name getSupervisor() {
		return new Name(supervisor.getFirstName(), supervisor.getLastName());
	}
}
