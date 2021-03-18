package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.SmartCard;
import uk.ac.ncl.manager.department.StudentID;
import uk.ac.ncl.manager.department.StudentType;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 29/10/2020
 *
 * SmartCardTest - JUnit class for testing correct functionality 
 * from methods within SmartCard.java
 */

class SmartCardTest {
	//Test class used to validate the correctness of the methods in SmartCardTest.java 

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#SmartCard(Name, Date, Date, StudentID, StudentType)}
	 * Passes tested by throwing IllegalArgumentException if date of Issue comes before date of birth 
	 */
	@Test
	void testCreateStudentCardInvalidDate() {
		final Name name = new Name("Elvis", "Presley");
		
		final Calendar cal1 = new GregorianCalendar(1935, 1, 8);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1977, 8,16);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new SmartCard(name, dOfIssue, dOfB, sid, StudentType.UG));
		
		assertEquals("Error: Date of birth cannot be after date of issue", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getStudentName()}
	 */
	@Test
	void testGetStudentName() {
		final Name name = new Name("David", "Bowie");
		
		final Calendar cal1 = new GregorianCalendar(1947, 1, 8);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(2016, 1, 10);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGT);
		Name expected = new Name("David", "Bowie");
		
		assertEquals(expected, sc.getStudentName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getDateOfBirth()}
	 */
	@Test
	void testGetDateOfBirth() {
		final Name name = new Name("Jimi","Hendrix");
		
		final Calendar cal1 = new GregorianCalendar(1942, 11, 27);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1970, 9, 18);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGR);
		
		final Calendar expectedCal = new GregorianCalendar(1942, 11, 27);
		final Date expected = expectedCal.getTime();
		
		assertEquals(expected, sc.getDateOfBirth());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getScn()}
	 */
	@Test
	void testGetSmartCardNumber() {
		final Name name = new Name("Michael", "Jackson");
		
		final Calendar cal1 = new GregorianCalendar(1958, 8, 29);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(2009, 6, 25);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGR);
		
		final String expected = "MJ-2009-0";
		
		assertEquals(expected, sc.getScn().toString());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getDateOfIssue()}
	 */
	@Test
	void testGetDateOfIssue() {
		final Name name = new Name("John", "Lennon");
		
		final Calendar cal1 = new GregorianCalendar(1940, 10, 9);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1980, 12, 8); 
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGT);
		
		final Calendar expectedCal = new GregorianCalendar(1980, 12, 8);
		final Date expected = expectedCal.getTime();
		
		assertEquals(expected, sc.getDateOfIssue());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getStudentID()}
	 */
	@Test
	void testGetStudentID() {
		final Name name = new Name("Freddie", "Mercury");
		
		final Calendar cal1 = new GregorianCalendar(1946, 9, 5);
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1991, 11, 24); 
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.UG);
		
		final String expected = "a0002";
		assertEquals(expected, sc.getStudentID().toString());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getExpiryDate()}
	 */
	@Test 
	void testGetExpiryDateUG() {
		final Name name = new Name("Bob", "Marley");
		
		final Calendar cal1 = new GregorianCalendar(1945, 2, 6); 
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1981, 5, 11);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.UG);
		
		final Calendar expectedCal = new GregorianCalendar(1985, 5, 11);
		final Date expected = expectedCal.getTime();
		
		assertEquals(expected, sc.getExpiryDate());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getExpiryDate()}
	 */
	@Test 
	void testGetExpiryDatePGT() {
		final Name name = new Name("Bob", "Marley");
		
		final Calendar cal1 = new GregorianCalendar(1945, 2, 6); 
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1981, 5, 11);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGT);
		
		final Calendar expectedCal = new GregorianCalendar(1983, 5, 11);
		final Date expected = expectedCal.getTime();
		
		assertEquals(expected, sc.getExpiryDate());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#getExpiryDate()}
	 */
	@Test 
	void testGetExpiryDatePGR() {
		final Name name = new Name("Bob", "Marley");
		
		final Calendar cal1 = new GregorianCalendar(1945, 2, 6); 
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1981, 5, 11);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGR);
		
		final Calendar expectedCal = new GregorianCalendar(1986, 5, 11);
		final Date expected = expectedCal.getTime();
		
		assertEquals(expected, sc.getExpiryDate());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCard#toString()}
	 */
	@Test
	void testToString() {
		final Name name = new Name("Kurt", "Cobain");
		
		final Calendar cal1 = new GregorianCalendar(1967, 2, 20); 
		final Date dOfB = cal1.getTime();
		
		final Calendar cal2 = new GregorianCalendar(1994, 4, 5);
		final Date dOfIssue = cal2.getTime();
		
		StudentID sid = StudentID.getInstance();
		
		SmartCard sc = new SmartCard(name, dOfB, dOfIssue, sid, StudentType.PGR);
		
		String expected = "Kurt,Cobain,Mon Mar 20 00:00:00 BST 1967,KC-1994-0,"
				+ "Thu May 05 00:00:00 BST 1994,a0001,Wed May 05 00:00:00 BST 1999";
		
		assertEquals(expected, sc.toString());
	}

}
