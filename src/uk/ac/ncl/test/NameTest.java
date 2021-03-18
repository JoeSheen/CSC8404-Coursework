package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 28/10/2020
 *
 * NameTest - JUnit class for testing correct functionality 
 * of methods in Name.java 
 * 
 */

class NameTest {
	//Test class used to validate that the methods within Name.java work correctly
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#Name(String, String)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testEmptyLastName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Name("Superman", ""));
		
		assertEquals("Error: invalid last name entered", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#Name(String, String)}
	 * Passes tested by throwing IllegalArgumentException
	 */
	@Test
	void testNullLastName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Name("Joker", null));
		
		assertEquals("Error: invalid last name entered", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#Name(String, String)}
	 * Passes tested by throwing IllegalArgumentException
	 */
	@Test
	void testEmptyFirstName(){
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new Name("", "Skywalker"));
		
		assertEquals("Error: invalid first name entered", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#Name(String, String)}
	 * Passes tested by throwing IllegalArgumentException
	 */
	@Test
	void testNullFirstName() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> 
		 new Name(null, "Balboa"));
		
		assertEquals("Error: invalid first name entered", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#getFirstName()}
	 */
	@Test 
	void testGetFirstName() {
		final Name batman = new Name("Bruce", "Wayne");
		final String expected = "Bruce";
		
		assertEquals(expected,batman.getFirstName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#getLastName()}
	 */
	@Test
	void testGetLastName() {
		final Name mcfly = new Name("Marty","McFly");
		final String expected = "McFly";
		
		assertEquals(expected, mcfly.getLastName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#hashCode()}
	 * Testing to see if two names hashCodes are not the same
	 */
	@Test
	void testHashCodeFalse() {
		final Name woody = new Name("Sheriff", "Woody");
		final Name harry = new Name("Dirty", "Harry");
		
		assertFalse(harry == woody);
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#hashCode()}
	 * Testing to see if two name hashCodes are the same
	 */
	@Test
	void testHashCodeTrue() {
		final Name buzz = new Name("Buzz", "Lightyear");
		final Name lightyear = new Name("Buzz", "Lightyear");

		assertTrue(buzz.hashCode() == lightyear.hashCode());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#equals(Object)}
	 * Testing to see if two Names are not logically equivalent
	 */
	@Test
	void testEqualsFalse() {
		final Name han = new Name("Han", "Solo");
		final Name indie = new Name("Indiana", "Jones");
		
		assertFalse(han.equals(indie));
		assertFalse(indie.equals(han));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#equals(Object)}
	 * Testing to see if two Names are logically equivalent 
	 */
	@Test
	void testEqaulsTrue() {
		final Name darth1 = new Name("Darth", "Vader");
		final Name darth2 = new Name("Darth", "Vader");
		
		assertTrue(darth1.equals(darth2));
		assertTrue(darth2.equals(darth1));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#valueOf(String)}
	 */
	@Test
	void testValueOf() {
		final String s = "Gordon,Gekko";
		final Name expected = new Name("Gordon", "Gekko");
		
		assertEquals(expected, Name.valueOf(s));
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.Name#toString()}
	 */
	@Test
	void testToString() {
		final Name name = new Name("James", "Bond");
		final String expected = "James,Bond";
		
		assertEquals(expected, name.toString());
	}

}
