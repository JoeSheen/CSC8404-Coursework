package uk.ac.ncl.manager.department;

import java.util.Date;

/**
 * @author Joe Sheen
 * @version 1.0 30/10/2020
 * 
 * PGTStudent - implementation for postgrad taught student that are 
 * expected to take 180 credits worth of modules and obtain a mark of 50+% to pass. 
 */

public final class PGTStudent extends AbstractTaughtStudent {
	private int CORRECT_CREDIT_VALUE = 180;
	private int PASSMARK = 50;
	
	/**
	 * Constructs a concert implementation of a taught UGStudent
	 *
	 * @see AbstractTaughtStudent#AbstractTaughtStudent(Name, Date, StudentType)
	 * 
	 * @throws IllegalArgumentException <code>passMark</code> is set to less than 0
	 */
	public PGTStudent(Name studentName, Date dateOfBirth, StudentType studentType) {
		//Call to the constructor in AbstractTaughtStudent
		super(studentName, dateOfBirth, studentType);
		if(studentType != StudentType.PGT)
			throw new IllegalArgumentException("Error: Student type is invalid");
	}

	/**
	 * Gets the <code>ugModuleList</code> field.
	 * @returns Returns the <code>ugModuleList</code>field. 
	 * True if count == 180, else false.
	 */
	@Override
	public boolean enoughCredits() {
		int count = 0;
		for(Modules modules : super.getListModules()) {
			count += modules.getCredits();
		}
		if(count == CORRECT_CREDIT_VALUE)
			return true;
		else
			return false;
	}

	/**
	 * Gets the <code>passMark</code> field for PGTStudents 
	 * @return Returns the <code>passMark</code>field for PGTStudents
	 */
	@Override
	public String getPassMark() {
		return PASSMARK + "%";
	}

}
