package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.SmartCardNumber;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 29/10/2020
 *
 * SmartCardNumberTest - JUnit class for testing correct functionality 
 * of methods in SmartCardNumber.java 
 * 
 */

class SmartCardNumberTest {
	//Test class used to validate the correctness of methods within SmartCardNumber.java 

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCardNumber#getInstance(Name, Date)}
	 */
	@Test
	void testGetInstance() {
		final Name mr = new Name("Marcus", "Rashford");
		
		final Calendar calendar = new GregorianCalendar(2016, 2, 25);
		final Date date = calendar.getTime();
		
		final SmartCardNumber scn1 = SmartCardNumber.getInstance(mr, date);
		final SmartCardNumber scn2 = SmartCardNumber.getInstance(mr, date);
		
		System.out.println("scn1: " + scn1);
		System.out.println("scn2: " + scn2);
		
		assertNotEquals(scn1,scn2);
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCardNumber#getInitials()}
	 */
	@Test
	void testGetInitials() {
		final Name cr = new Name("Cristiano", "Ronaldo");
		
		final Calendar calendar = new GregorianCalendar(2002, 9, 29);
		final Date date = calendar.getTime();
		
		final SmartCardNumber scn3 = SmartCardNumber.getInstance(cr, date);
		final String expected = "CR";
		
		System.out.println("scn3: " + scn3);
		
		assertEquals(expected,scn3.getInitials());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCardNumber#getYearOfIssue()}
	 */
	@Test
	void testGetYearOfIssue() {
		final Name lm = new Name("Lionel", "Messi");
		
		final Calendar calendar = new GregorianCalendar(2004, 10, 16);
		final Date date = calendar.getTime();
		
		final SmartCardNumber scn4 = SmartCardNumber.getInstance(lm, date);
		final int expected = 2004;
		
		System.out.println("scn4: " + scn4);
		
		assertEquals(expected,scn4.getYearOfIssue());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCardNumber#getSerialNumber()}
	 */
	@Test
	void testGetSerialNumber() {
		final Name km = new Name("Kylian", "Mbappe");
		
		final Calendar calendar = new GregorianCalendar(2015, 12, 2);
		final Date date = calendar.getTime();
		
		final SmartCardNumber scn5 = SmartCardNumber.getInstance(km, date);
		final int expected = 0;
		
		System.out.println("scn5: " + scn5);
		
		assertEquals(expected, scn5.getSerialNumber());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.SmartCardNumber#toString()}
	 */
	@Test
	void testToString() {
		final Name db = new Name("David", "Beckham ");
		
		final Calendar calendar = new GregorianCalendar(1992, 9, 23);
		final Date date = calendar.getTime();
		
		final SmartCardNumber scn6 = SmartCardNumber.getInstance(db, date);
		final String expected = "DB-1992-0";
		
		System.out.println("scn6: " + scn6);
		
		assertEquals(expected, scn6.toString());
		
	}
	
}
