package uk.ac.ncl.manager.department;

import java.util.Date;

/**
 * @author Joe Sheen
 * @version 1.0 30/10/2020
 * 
 * UGStudent - undergraduate student that is expected to take 120 credits worth of modules
 * and obtain a mark of 40+% to pass. 
 */

public final class UGStudent extends AbstractTaughtStudent {
	private int CORRECT_CREDIT_VALUE = 120;
	private int PASSMARK = 40;
	
	/**
	 * Constructs a concert implementation of a taught UGStudent
	 *
	 * @see AbstractTaughtStudent#AbstractTaughtStudent(Name, Date, StudentType)
	 * 
	 * @throws IllegalArgumentException <code>passMark</code> is set to less than 0
	 */
	public UGStudent(Name studentName, Date dateOfBirth, StudentType studentType) {
		//Call to the constructor in AbstractTaughtStudent
		super(studentName, dateOfBirth, studentType);
		if((studentType != StudentType.UG))
			throw new IllegalArgumentException("Error: Student type is invalid");
	}

	/**
	 * Calculates the total number of credits a UGstudent is taking and  
	 * returns true or false if its the correct amount
	 * 
	 * @return Returns a boolean to indicate if a UGStudent 
	 * is taking the right number of modules.
	 */
	@Override
	public boolean enoughCredits() {
		int count = 0;
		for(Modules module : super.getListModules()) {
			count += module.getCredits();
		}
		if(count == CORRECT_CREDIT_VALUE)
			return true;
		else
			return false;
	}

	/**
	 * Gets the <code>passMark</code> field for UGStudents 
	 * @return Returns the <code>passMark</code>field for UGStudents
	 */
	@Override
	public String getPassMark() {
		return PASSMARK + "%";
	}

}
