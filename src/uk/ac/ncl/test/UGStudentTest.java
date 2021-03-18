package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.Student;
import uk.ac.ncl.manager.department.StudentType;
import uk.ac.ncl.manager.department.UGStudent;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 31/10/2020
 * 
 * UGStudentTest - JUnit class for testing correct functionality 
 * within UGStudent.java class in the student hierarchy 
 *
 */

class UGStudentTest {
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getName()}
	 */
	@Test
	void testGetName() {
		final Name name = new Name("Mick", "Fleetwood");
		final Calendar calendar = new GregorianCalendar(1947, 6, 24);
		final Date dateOfBirth = calendar.getTime();
		
		final Student ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		final Name expected = new Name("Mick", "Fleetwood");
		
		assertEquals(expected,ugStudent.getName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getPassMark()}
	 */
	@Test
	void testGetPassMark() {
		final Name name = new Name("Debbie", "Harry");
		final Calendar calendar = new GregorianCalendar(1945, 6, 1);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		final String expected = "40%";
		
		assertEquals(expected,ugStudent.getPassMark());
		
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getDateOfBirth()}
	 */
	@Test
	void testGetDateOfBirth() {
		final Name name = new Name("John", "Ling");
		final Calendar calendar = new GregorianCalendar(1995, 1, 21);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		final Date expected = calendar.getTime();
		
		assertEquals(expected, ugStudent.getDateOfBirth());
		
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#UGStudent(Name, Date, StudentType, int)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testNullDateOfBirth() {
		final Name name = new Name("Max", "Roberts");
		final Date dateOfBirth = null;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new UGStudent(name, dateOfBirth, StudentType.UG));
		
		assertEquals("Error: Invalid date of birth is invalid", exception.getMessage());
		
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#UGStudent(Name, Date, StudentType, int)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testIncorrectStudentType() {
		final Name name = new Name("David", "Smith");
		final Calendar calendar = new GregorianCalendar(2001, 1, 17);
		final Date dateOfBirth = calendar.getTime();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new UGStudent(name, dateOfBirth, StudentType.PGR));
		
		assertEquals("Error: Student type is invalid", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#UGStudent(Name, Date, StudentType, int)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testInvalidUGStudent() {
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new UGStudent(null, null, null));
		
		assertEquals("Error: Invalid date of birth is invalid", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getSmartCard()}
	 * SmartCard has not been created or allocated to student yet
	 */
	@Test
	void testStudentCardsNull() {
		final Name name = new Name("Kevin", "Splash");
		final Calendar calendar = new GregorianCalendar(2009, 5, 22);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		assertNull(ugStudent.getSmartCard());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getListModules()}
	 * SmartCard has not been created or allocated to student yet
	 */
	@Test
	void testEmptyModuleList() {
		final Name name = new Name("Jonny", "Salad");
		final Calendar calendar = new GregorianCalendar(2019, 7, 12);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		assertNull(ugStudent.getListModules());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getStudentID()}
	 * StudentID has not been created or allocated to student yet
	 */
	@Test
	void testGetStudentID() {
		final Name name = new Name("James", "Owen");
		final Calendar calendar = new GregorianCalendar(1989, 7, 12);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		assertNull(ugStudent.getStudentID());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getStudentType()}
	 */
	@Test
	void testGetStudentType() {
		final Name name = new Name("Luke", "Matterson");
		final Calendar calendar = new GregorianCalendar(1994, 9, 2);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		final StudentType expected = StudentType.UG;
		assertEquals(expected, ugStudent.getStudentType());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#getListModules()}
	 */
	@Test
	void testGetListModules() {
		final Name name = new Name("Adam", "Smith");
		final Calendar calendar = new GregorianCalendar(1984, 11, 3);
		final Date dateOfBirth = calendar.getTime();
		
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		assertNull(ugStudent.getListModules());
	}
}
