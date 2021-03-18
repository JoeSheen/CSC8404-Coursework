package uk.ac.ncl.manager.department;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 28/10/2020
 * 
 * Names - class for creating and managing instances of
 * names objects.
 * 
 */

public class Name {
	private String firstName;
	private String lastName;
	
	/**
	 * Constructs a name when provided with a first and last name
	 * 
	 * @param firstName represents the first name of the name object
	 * @param lastName represents the last name of the name object
	 * 
	 * @throws IllegalArgumentException if <code>firstName</code>
	 * or <code>lastName</code> have invalid values (e.g. null)
	 */
	public Name(String firstName, String lastName) {
		if((firstName == null) || (firstName.length() == 0))
			throw new IllegalArgumentException("Error: invalid first name entered");
		
		if((lastName == null) || (lastName.length() == 0))
			throw new IllegalArgumentException("Error: invalid last name entered");
		
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the <code>firstName</code> field.
	 * @return Returns the <code>firstName</code> field.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Gets the <code>lastName</code> field.
	 * @return Returns the <code>firstName</code> field.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Computes an integer hash code for a name object
	 * @return Returns an integer hash value of a name object
	 */
	@Override
	public int hashCode() {
		int hc = 17;
		
		hc = 37 * hc + ((firstName == null) ? 0 : firstName.hashCode());
		return 37 * hc + ((lastName == null) ? 0 : lastName.hashCode()); 
	}
	
	/**
	 * Compares logical equivalence of name object
	 * @return Returns boolean to indicate if name object are logically equivalent
	 */
	@Override
	public boolean equals(Object rhs) {
		if(this == rhs)
			return true;
		
		if(!(rhs instanceof Name))
			return false;
		
		Name name = (Name) rhs;
		
		//Exception thrown by constructor guarantees name cannot contain null
		return firstName.equals(name.firstName) &&
				lastName.equals(name.lastName);
	}
	
	/**
	 * Converts a String to Name object
	 * 
	 * @param name is the string to be turned into a name object
	 * @return Returns a new name object based on the input string
	 * 
	 * @throws IllegalArgumentException if <code>firstName</code> 
	 * or <code>lastName</code> are invalid  
	 */
	public static Name valueOf(String name) {
		final String[] parts = name.split(",");
		
		final String firstName = 
				parts[0].equals("null") ? null : parts[0];
		
		final String lastName =
				parts[1].equals("null") ? null : parts[1];
		
		/*Constructor call can cause NullPointerException
		if firstName or lastName are null*/
		return new Name(firstName, lastName);
	}
	
	/**
	 * Converts name object to string object
	 * @return Returns a string representation of a name
	 * Has the format: <code>firstName</code>,<code>lastNAme</code>
	 */
	@Override
	public String toString() {
		return firstName + "," + lastName;
	}
}
