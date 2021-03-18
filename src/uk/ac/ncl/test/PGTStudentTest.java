package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.PGTStudent;
import uk.ac.ncl.manager.department.Student;
import uk.ac.ncl.manager.department.StudentType;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 02/11/2020
 *
 * PGTStudentTest - JUnit class for testing correct functionality 
 * within PGTStudent.java class in the student hierarchy 
 */
class PGTStudentTest {
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getStudentID()}
	 * Passes if null because PGTStudent hasn't been registered 
	 */
	@Test
	void testGetStudentID() {
		final Name name = new Name("Foo", "Bar");
		final Calendar cal = new GregorianCalendar(1988, 6, 12);
		final Date dateOfBirth = cal.getTime();
		
		final PGTStudent pgts = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		assertNull(pgts.getStudentID());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getStudentType()}
	 */
	@Test
	void testGetStudentType() {
		final Name name = new Name("Michael", "Balzary");
		final Calendar calendar = new GregorianCalendar(1962, 10, 16);
		final Date dateOfBirth = calendar.getTime();
		
		final PGTStudent pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		final StudentType expected = StudentType.PGT; 
		assertEquals(expected, pgtStudent.getStudentType());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getListModules()}
	 * Passes if null because student hasn't been registered 
	 */
	@Test
	void testGetListModules() {
		final Name name = new Name("Ben", "Smith");
		final Calendar calendar = new GregorianCalendar(1984, 11, 3);
		final Date dateOfBirth = calendar.getTime();
		
		final PGTStudent pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		assertNull(pgtStudent.getListModules());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getName()}
	 */
	@Test
	void testGetName() {
		final Name name = new Name("Childish", "Gambino");
		final Calendar calendar = new GregorianCalendar(1987, 6, 24);
		final Date dateOfBirth = calendar.getTime();
		
		final Name expected = new Name("Childish", "Gambino");
		Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		assertEquals(expected,pgtStudent.getName());
	}

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getDateOfBirth()}
	 */
	@Test
	void testGetDateOfBirth() {
		final Name ak = new Name("Anthony", "Kiedis");
		final Calendar cal = new GregorianCalendar(1962, 11, 1);
		final Date dateOfBirth = cal.getTime();
		
		final Date expected = cal.getTime();
		Student pgtStudent = new PGTStudent(ak, dateOfBirth, StudentType.PGT);
		
		assertEquals(expected, pgtStudent.getDateOfBirth());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getSmartCard()}
	 * Passes if null because PGTStudent hasn't been registered 
	 */
	@Test
	void testGetSmartCard() {
		final Name name = new Name("Bar", "Foo");
		final Calendar cal = new GregorianCalendar(1991, 6, 12);
		final Date dateOfBirth = cal.getTime();
		
		final PGTStudent pgts = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		assertNull(pgts.getSmartCard());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#getPassMark()}
	 */
	@Test
	void getPassMark(){
		final Name cs = new Name("Chad", "Smith");
		final Calendar cal = new GregorianCalendar(1961, 10, 25);
		final Date dateOfBirth = cal.getTime();
		
		final String expected = "50%";
		PGTStudent pgtStudent = new PGTStudent(cs, dateOfBirth, StudentType.PGT);
		
		assertEquals(expected, pgtStudent.getPassMark());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#PGTStudent(Name, Date, StudentType, int)}
	 * Passes by throwing an exception to indicate date of birth is wrong
	 * 
	 */
	@Test
	void testNullDateOfBirth() {
		final Name name = new Name("Max", "Roberts");
		final Date dateOfBirth = null;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGTStudent(name, dateOfBirth, StudentType.PGT));
		
		assertEquals("Error: Invalid date of birth is invalid", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#PGTStudent(Name, Date, StudentType, int)}
	 * Passes tested by throwing llegalArgumentException is all parameters are null
	 */
	@Test
	void testNullPGTStudent() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGTStudent(null, null, null));
		
		assertEquals("Error: Invalid date of birth is invalid", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#PGTStudent(Name, Date, StudentType)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testInvalidStudentType() {
		final Name name = new Name("Sam", "Roggers");
		final Calendar calendar = new GregorianCalendar(1840 , 1, 9);
		final Date dateOfBirth = calendar.getTime();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGTStudent(name, dateOfBirth, StudentType.UG));
		
		assertEquals("Error: Student type is invalid", exception.getMessage());
	}
}
