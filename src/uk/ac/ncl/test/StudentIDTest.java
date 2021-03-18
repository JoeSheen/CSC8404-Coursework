package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.StudentID;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 29/10/2020
 * 
 * StudentIDTest - JUnit class for testing correct functionality 
 * is delivered from methods in StudentID.java 
 *
 */

class StudentIDTest {
	//Test class used to validate the correctness of the methods in StudentID.java 

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#getInstance()}
	 * Test aims to see if two newly created StudentIDs are unique
	 */
	@Test
	void testGetInstance() {
		final StudentID id1 = StudentID.getInstance();
		final StudentID id2 = StudentID.getInstance();
		
		System.out.println("id1: "+id1);
		System.out.println("id2: "+id2);
		
		assertNotEquals(id1,id2);
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#getPrefix()}
	 */
	@Test
	void testGetPrefix() {
		final StudentID id3 = StudentID.getInstance(); 
		final char expected = 'a';
		
		System.out.println("id3: "+id3);
		
		assertEquals(expected, id3.getPrefix());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#getIdNumber()}
	 */
	@Test
	void testGetIdNumber() {
		final StudentID id4 = StudentID.getInstance();
		final int expected = 1;
		
		System.out.println("id4: "+id4);
		assertEquals(expected, id4.getIdNumber());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#valueOf(String)}
	 * Test that valueOf is able to read in a valid string and use it to create a new
	 * StudentID that has a value thats not already in the map
	 */
	@Test
	void valueOfValid() {
		String stringId = "b1099";
		StudentID id5 = StudentID.valueOf(stringId);
		String expected = "b1099";
		System.out.println("id5: "+id5);
		
		assertEquals(id5.toString(), expected);
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#valueOf(String)}
	 * Test is pass if an error is thrown to indicate that the string input does not
	 * match the format given for studentIDs 
	 */
	@Test
	void valueOfWrongInputFormat() {
		String s = "ca0k01";
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		StudentID.valueOf(s));
		
		assertEquals("Error: invalid StudentID format", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#valueOf(String)}
	 * Tests that an already allocated studentID can't be recreated and added to the map again
	 */
	@Test
	void valueOfAllocatedID() {
		StudentID.getInstance();
		String s = "a0001";
		StudentID.valueOf(s);
		
		Exception exception = assertThrows(IllegalArgumentException.class, () -> 
		StudentID.valueOf(s));
		
		
		assertEquals("Error: StudentID has already been allocated", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.StudentID#toString()}
	 * Test to see if the toString method correctly pads out the number to four digits
	 * or shows the number if it is four digits.
	 */
	@Test
	void testToString() {
		StudentID sid = StudentID.getInstance();
		String expected = "a0000";
		
		assertEquals(expected, sid.toString());
	}

}
