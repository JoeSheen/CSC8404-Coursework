package uk.ac.ncl.manager.department;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 28/10/2020
 * 
 * Modules - class for creating instances of modules that
 * are allocated to taught students (UG, PGT). 
 * 
 */

public class Modules {
	private String moduleCode;
	private String moduleName;
	private int credits;
	
	/**
	 * Constructs a module when provided with a code, name and credits value
	 * 
	 * @param moduleCode is the code for the module
	 * @param moduleName is the mane of the module
	 * @param credits is the credits that the module its worth
	 * 
	 * @throws IllegalArgumentException if <code>moduleCode</code>
	 * or<code>moduleName</code>or<code>credits</code> has an invalid value (e.g. null)
	 */
	public Modules(String moduleCode, String moduleName, int credits) {
		if((moduleCode == null) || (moduleCode.length() == 0))
			throw new IllegalArgumentException("Error: invalid module code");
		
		if((moduleName == null) || (moduleName.length() == 0))
			throw new IllegalArgumentException("Error: invalid module name");
		
		if(credits < 0)
			throw new IllegalArgumentException("Error: invalid module credits");
		
		this.moduleCode = moduleCode;
		this.moduleName = moduleName;
		this.credits = credits;
	}
	
	/**
	 * Gets the <code>moduleCode</code> field.
	 * @return Returns the <code>moduleCode</code> 
	 * field as a string.
	 */
	public String getModuleCode() {
		return moduleCode;
	}
	
	/**
	 * Gets the <code>moduleName</code>field.
	 * @return Returns the <code>moduleName</code>
	 * field as a string.
	 */
	public String getModuleName() {
		return moduleName;
	}
	
	/**
	 * Gets the <code>credits</code>field.
	 * @return Returns the <code>credits</code>
	 * field as a integer.
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Computes an integer hash code for each module object
	 * @return Returns an integer hash value of a module object 
	 */
	@Override
	public int hashCode() {
		int hc = 17;
		
		hc = 37 * hc + ((moduleCode == null) ? 0 : moduleCode.hashCode());
		hc = 37 * hc + ((moduleName == null) ? 0 : moduleName.hashCode());
		
		return 37 * hc + credits;
	}

	/**
	 * Compares logical equivalence of module objects
	 * @return Returns boolean to indicate if module objects are logically equivalent
	 */
	@Override
	public boolean equals(Object rhs) {
		if(this == rhs) 
			return true;
		
		if(!(rhs instanceof Modules)) 
			return false;
		
		Modules module = (Modules) rhs;
		
		//Exception thrown by constructor guarantees modules cannot contain null
		return moduleCode.equals(module.moduleCode) &&
				moduleName.equals(module.moduleName) &&
				credits == module.credits;
	}
	
	/**
	 * Converts a string to a modules object
	 * 
	 * @param module is the string to be converted to a module
	 * @return Returns a module representation based off input string
	 * 
	 * @throws NullPointerException if any field is invalid (e.g. null)
	 */
	public static Modules valueOf(String module) {
		final String[] parts =
				module.split(",");
		
		final String code = 
				parts[0].equals("null") ? null : parts[0];
		
		final String name =
				parts[1].equals("null") ? null : parts[1];
		
		final int credits = Integer.parseInt(parts[2]);
		
		//can cause NullPointerException in any are invalid (e.g. null)
		return new Modules(code, name, credits);
	}
	
	/**
	 * Converts a Modules object to String object.
	 * 
	 * @return Returns a string representation of a module
	 * Has the format: <code>moduleCode</code>,
	 * <code>moduleName</code>,<code>credits</code> 
	 */
	public String toString() {
		return moduleCode + "," + moduleName + "," + credits;
	}

}
