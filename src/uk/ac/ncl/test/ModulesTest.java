package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Modules;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 28/10/2020
 *
 * ModulesTest - JUnit class for testing correct functionality 
 * of methods in Modules.java 
 * 
 */

class ModulesTest {
	//Test class used to validate the correctness of the methods in Modules.java 
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 * Passes by throwing an exception for the module code being empty ("")
	 */
	@Test
	void testEmptyModuleCode() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Modules("", "Big Data Analytics", 10));
		
		assertEquals("Error: invalid module code", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 * Passes by throwing an exception for the module code being null
	 */
	@Test
	void TestNullModuleCode(){
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Modules(null, "Introduction to Smart Systems", 10));
		
		assertEquals("Error: invalid module code", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 * Passes by throwing an exception for the module name being empty ("")
	 */
	@Test
	void testEmptyModuleName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Modules("CSC8208", "", 10));
		
		assertEquals("Error: invalid module name", exception.getMessage());
		
	}

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 * Passes by throwing an exception for the module name being null
	 */
	@Test
	void testNullModuleName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Modules("CSC8207", null, 10));
		
		assertEquals("Error: invalid module name", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 * Passes by throwing an exception if the value for credits in negative
	 */
	@Test
	void testInvalidModuleCredits() {
		//CSC8501 Advanced Programming for Games
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Modules("CSC8501", "Advanced Programming for Games" , -20));
		
		assertEquals("Error: invalid module credits", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#Modules(String, String, int)}
	 */
	@Test
	void testGetModuleCode() {
		final Modules module = new Modules("CSC8204", "High Integrity Software Development", 10);
		final String expected = "CSC8204";
		
		assertEquals(expected, module.getModuleCode());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#getModuleName()}
	 */
	@Test
	void testGetModuleName() {
		final Modules module = new Modules("CSC8111", "Machine Learning", 10);
		final String expected = "Machine Learning";
		
		assertEquals(expected,module.getModuleName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#getCredits()}
	 */
	@Test
	void testGetCredits() {
		final Modules module = new Modules("CSC8110", "Cloud Computing", 10);
		final int expected = 10;
		
		assertEquals(expected, module.getCredits());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#hashCode()}
	 */
	@Test
	void testHashCodeFalse() {
		final Modules module1 = new Modules("CSC8210", "Security Fundamentals and Tools", 10);
		final Modules module2 = new Modules("CSC8414", "Security Tools and Analysis", 20);
		
		assertFalse(module1.hashCode() == module2.hashCode());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#hashCode()}
	 */
	@Test
	void testHashCodeTrue() {
		final Modules module1 = new Modules("CSC8112", "Internet of Things", 10);
		final Modules module2 = new Modules("CSC8112", "Internet of Things", 10);
		
		assertTrue(module1.hashCode() == module2.hashCode());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#equals(Object)}
	 */
	@Test
	void testEqualsFasle() {
		final Modules module1 = new Modules("CSC8105", "System Validation", 10);
		final Modules module2 = new Modules("CSC8106", "System Evaluation", 10);
		
		assertFalse(module1.equals(module2));
		assertFalse(module2.equals(module1));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#equals(Object)}
	 */
	@Test
	void testEqualsTrue() {
		final Modules module1 = new Modules("CSC8201", "Dependable Systems",10); 
		final Modules module2 = new Modules("CSC8201", "Dependable Systems",10);
		
		assertTrue(module1.equals(module2));
		assertTrue(module2.equals(module1));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#valueOf(String)}
	 */
	@Test
	void testValueOf() {
		final String s = "CSC8103,Distributed Algorithms,10";
		final Modules expected = new Modules("CSC8103","Distributed Algorithms",10);
		assertEquals(expected, Modules.valueOf(s));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Modules#toString()}
	 */
	@Test
	void testToString() {
		final Modules modules = new Modules("CSC8404", "Advanced Programming in Java", 10);
		final String expected = "CSC8404,Advanced Programming in Java,10";
		
		assertEquals(expected, modules.toString());
	}

}
