package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.PGRStudent;
import uk.ac.ncl.manager.department.Student;
import uk.ac.ncl.manager.department.StudentType;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 31/10/2020
 * 
 * PGRStudent - JUnit class for testing correct functionality 
 * within PGRStudent.java class in the student hierarchy 
 *
 */

class PGRStudentTest {
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getStudentID()}
	 * Should be null because the student card has not been generated for the student
	 */
	@Test
	void testGetStudentID() {
		final Name name = new Name("Danny", "DeVito");
		final Calendar calendar = new GregorianCalendar(1944 , 11, 17);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		
		assertNull(pgrStudent.getStudentID());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getStudentType()}
	 */
	@Test
	void testGetStudentType() {
		final Name name = new Name("Danny", "Jones");
		final Calendar calendar = new GregorianCalendar(1998 , 12, 10);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		final StudentType expected = StudentType.PGR; 
		assertEquals(expected, pgrStudent.getStudentType());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getListModules()}
	 */
	@Test
	void testGetListModules() {
		final Name name = new Name("Mike", "Ross");
		final Calendar calendar = new GregorianCalendar(1974, 12, 5);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		assertNull(pgrStudent.getListModules());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#enoughCredits()}
	 */
	@Test
	void testEnoughCredits() {
		final Name name = new Name("Kevin", "James");
		final Calendar calendar = new GregorianCalendar(1994, 2, 15);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		assertTrue(pgrStudent.enoughCredits());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getName()}
	 */
	@Test
	void testGetName() {
		final Name name = new Name("Danny", "DeVito");
		final Calendar calendar = new GregorianCalendar(1944 , 11, 17);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		final Name expected = new Name("Danny", "DeVito");
		
		assertEquals(expected,pgrStudent.getName());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getDateOfBirth()}
	 */
	@Test
	void testGetDateOfBirth() {
		final Name name = new Name("Vinny", "DeVito");
		final Calendar calendar = new GregorianCalendar(1940 , 2, 2);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		final Date expected = calendar.getTime();
		
		assertEquals(expected,pgrStudent.getDateOfBirth());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#getSmartCard()}
	 * Passes if smart card hasn't been allocated to student
	 */
	@Test
	void testGetSmartCard() {
		final Name name = new Name("Steven", "Smith");
		final Calendar calendar = new GregorianCalendar(1840 , 1, 9);
		final Date dateOfBirth = calendar.getTime();
		
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		
		assertNull(pgrStudent.getSmartCard());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#PGRStudent(Name, Date, StudentType)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testNullDateOfBirth() {
		final Name name = new Name("Sam", "Roggers");
		final Date dateOfBirth = null;
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGRStudent(name, dateOfBirth, StudentType.PGR));
		
		assertEquals("Error: Invalid date of birth is invalid", exception.getMessage());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#PGRStudent(Name, Date, StudentType)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testInvalidStudentType() {
		final Name name = new Name("Sam", "Roggers");
		final Calendar calendar = new GregorianCalendar(1840 , 1, 9);
		final Date dateOfBirth = calendar.getTime();
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGRStudent(name, dateOfBirth, StudentType.UG));
		
		assertEquals("Error: Student type is invalid", exception.getMessage());
	}

	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#PGRStudent(Name, Date, StudentType)}
	 * Passes tested by throwing llegalArgumentException
	 */
	@Test
	void testInvalidPGRStudent() {
		final Name name = null;
		final Date dateOfBirth = null;
		
		Exception exception = assertThrows(IllegalArgumentException.class, () ->
		new PGRStudent(name, dateOfBirth, StudentType.UG));
		
		assertEquals("Error: Student type is invalid", exception.getMessage());
		
	}
}
