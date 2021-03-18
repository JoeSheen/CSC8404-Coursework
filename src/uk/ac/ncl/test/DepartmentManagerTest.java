package uk.ac.ncl.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import uk.ac.ncl.manager.department.DepartmentManager;
import uk.ac.ncl.manager.department.Name;
import uk.ac.ncl.manager.department.PGRStudent;
import uk.ac.ncl.manager.department.PGTStudent;
import uk.ac.ncl.manager.department.Student;
import uk.ac.ncl.manager.department.StudentType;
import uk.ac.ncl.manager.department.UGStudent;

/**
 * 
 * @author Joe Sheen
 * @version 1.0 3/11/2020
 * 
 * DepartmentManagerTest - JUnit class for testing correct functionality 
 * of methods in the DepartmentManager class 
 *
 */

class DepartmentManagerTest {
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#noOfStudents(StudentType.UG)}
	 */
	@Test
	void testNoOfStudentsUG() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Sam", "Smith");
		final Calendar calendar = new GregorianCalendar(1999, 4, 14);
		final Date dateOfBirth = calendar.getTime();
		for(int i=0;i<5;i++) {
			final Student ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
			dm.registerStudent(ugStudent);
		}
		
		int expected = 5;
		assertEquals(expected,dm.noOfStudents(StudentType.UG));
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#noOfStudents(StudentType.PGT)}
	 */
	@Test
	void testNoOfStudentsPGT() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Bart", "Simpson");
		final Calendar calendar = new GregorianCalendar(2000, 8, 12);
		final Date dateOfBirth = calendar.getTime();
		for(int i=0;i<8;i++) {
			final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
			dm.registerStudent(pgtStudent);
		}
		
		int expected = 8;
		assertEquals(expected,dm.noOfStudents(StudentType.PGT));
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#noOfStudents(StudentType.PGR)}
	 */
	@Test
	void testNoOfStudentsPGR() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Lisa", "Simpson");
		final Calendar calendar = new GregorianCalendar(1997, 1, 2);
		final Date dateOfBirth = calendar.getTime();
		for(int i=0;i<3;i++) {
			final Student pgtStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
			dm.registerStudent(pgtStudent);
		}
		
		int expected = 3;
		assertEquals(expected,dm.noOfStudents(StudentType.PGR));
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if supervisor has been allocated, supervisor name is printed to the console
	 */
	@Test
	void testPGRAllocatedSupervisor() {
		System.out.println("-- testPGRAllocatedSupervisor --");
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Gary", "Simth");
		final Calendar calendar = new GregorianCalendar(1996, 1, 2);
		final Date dateOfBirth = calendar.getTime();
		final PGRStudent pgtStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		dm.registerStudent(pgtStudent);
		System.out.println("Dr. "+pgtStudent.getSupervisor()+"\n");
		assertNotNull(pgtStudent.getSupervisor());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if modules are issued to PGT student (printed to the console)
	 */
	@Test
	void testPGTModules() {
		System.out.println("-- testPGTModules --");
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Lary", "Simth");
		final Calendar calendar = new GregorianCalendar(1998, 2, 12);
		final Date dateOfBirth = calendar.getTime();
		final PGTStudent pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		dm.registerStudent(pgtStudent);
		System.out.println(pgtStudent.getListModules()+"\n");
		assertNotNull(pgtStudent.getListModules());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if modules are issued to UG student (printed to the console)
	 */
	@Test
	void testUGModules() {
		System.out.println("-- testUGModules --");
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Barry", "Simth");
		final Calendar calendar = new GregorianCalendar(1998, 2, 12);
		final Date dateOfBirth = calendar.getTime();
		final UGStudent ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		dm.registerStudent(ugStudent);
		System.out.println(ugStudent.getListModules()+"\n");
		assertNotNull(ugStudent.getListModules());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if StudentID is issued to student (printed to the console)
	 */
	@Test 
	void testStudentAllocatedID() {
		System.out.println("-- testStudentAllocatedID --");
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Glen", "Quagmire");
		final Calendar calendar = new GregorianCalendar(1978, 4, 28);
		final Date dateOfBirth = calendar.getTime();
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		dm.registerStudent(pgrStudent);
		System.out.println(pgrStudent.getStudentID()+"\n");
		assertNotNull(pgrStudent.getStudentID());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if SmartCard is issued to student (printed to the console)
	 */
	@Test
	void testStudentAllocatedSmartCard() {
		System.out.println("-- testStudentAllocatedSmartCard --");
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Ronnie", "Jenkins");
		final Calendar calendar = new GregorianCalendar(1990, 5, 3);
		final Date dateOfBirth = calendar.getTime();
		final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		dm.registerStudent(pgtStudent);
		System.out.println(pgtStudent.getSmartCard()+"\n");
		assertNotNull(pgtStudent.getSmartCard());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if Student is over 17
	 */
	@Test
	void testMinimumStudentAge() {
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Bobby", "Jones");
		final Calendar calendar = new GregorianCalendar(2005, 5, 3);
		final Date dateOfBirth = calendar.getTime();
		final Student ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        dm.registerStudent(ugStudent);});
		
		 assertEquals("Error: Student is to young", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if Student cannot be null
	 */
	@Test
	void testNullStudent() {
		DepartmentManager dm = new DepartmentManager();
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        dm.registerStudent(null);});
		
		 assertEquals("Error: Invalid student provided", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#registerStudent(Student)}
	 * Method passes if PG student cannot be younger than 20
	 */
	@Test
	void testMinimumPGAge() {
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Robbie", "Jones");
		final Calendar calendar = new GregorianCalendar(2001, 7, 12);
		final Date dateOfBirth = calendar.getTime();
		final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        dm.registerStudent(pgtStudent);});
		
		 assertEquals("Error: Student is to young to be a PG Student", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#amendStudentData(uk.ac.ncl.manager.department.StudentID, Student)}
	 * Method passes if exception is thrown to indicate that student is registered 
	 */
	@Test
	void testStudentNotFoundAmendData() {
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Tobbie", "Jones");
		final Calendar calendar = new GregorianCalendar(1991, 7, 12);
		final Date dateOfBirth = calendar.getTime();
		final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        dm.amendStudentData(pgtStudent.getStudentID(), pgtStudent);});
		
		 assertEquals("Error: Student not found", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#terminateStudent(uk.ac.ncl.manager.department.StudentID)}
	 * Passes if an error is thrown because the user tries to terminate a student that has not enrolled 
	 */
	@Test 
	void testStudentNotFoundTerminateStudent() {
		DepartmentManager dm = new DepartmentManager();
		
		final Name name = new Name("Winnie", "the Pooh");
		final Calendar calendar = new GregorianCalendar(1989, 10, 1);
		final Date dateOfBirth = calendar.getTime();
		final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		 Exception exception = assertThrows(IllegalArgumentException.class, () -> {
		        dm.terminateStudent(pgtStudent.getStudentID());});
		
		 assertEquals("Error: Student not found", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#noOfStudents(StudentType)}
	 * Passes by throwing an error is no students have registered and noOfStudents is call
	 */
	@Test
	void testNoOfStudentsEmptyMap() {
		DepartmentManager dm = new DepartmentManager();
		Exception exception = assertThrows(RuntimeException.class, () -> {
	        dm.noOfStudents(StudentType.PGT);});
		
		 assertEquals("Error: No students have registered.", exception.getMessage());
	}
	
	/**
	 * Test Method for {@link uk.ac.ncl.manager.department.DepartmentManager#terminateStudent(uk.ac.ncl.manager.department.StudentID)}
	 * Passes the test if an error is thrown to indicate that the student has already been terminated (in this test only)!
	 */
	@Test
	void testTerminateStudent() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Sam", "Smith");
		final Calendar calendar = new GregorianCalendar(1999, 4, 14);
		final Date dateOfBirth = calendar.getTime();
		final Student ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		dm.registerStudent(ugStudent);
		dm.terminateStudent(ugStudent.getStudentID());
		
		//Student has already been removed from map, should throw exception 
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			dm.terminateStudent(ugStudent.getStudentID());}); 
		
		assertEquals("Error: Student not found",exception.getMessage());
		
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGTStudent#enoughCredits()}
	 * Checks that a PGT student is taking 180 credits
	 */
	@Test
	void testPGTEnoughCredits() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Dave", "Mathson");
		final Calendar calendar = new GregorianCalendar(1989, 4, 14);
		final Date dateOfBirth = calendar.getTime();
		final Student pgtStudent = new PGTStudent(name, dateOfBirth, StudentType.PGT);
		
		dm.registerStudent(pgtStudent);
		
		assertTrue(pgtStudent.enoughCredits());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.UGStudent#enoughCredits()}
	 * Checks that a PGT student is taking 120 credits
	 */
	@Test
	void testUGEnoughCredits() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Sam", "Mathson");
		final Calendar calendar = new GregorianCalendar(2000, 4, 14);
		final Date dateOfBirth = calendar.getTime();
		final Student ugStudent = new UGStudent(name, dateOfBirth, StudentType.UG);
		
		dm.registerStudent(ugStudent);
		
		assertTrue(ugStudent.enoughCredits());
	}
	
	/**
	 * Test method for {@link uk.ac.ncl.manager.department.PGRStudent#enoughCredits()}
	 * Checks that a PGR student is taking 0 credits
	 */
	@Test
	void testPGREnoughCredits() {
		DepartmentManager dm = new DepartmentManager();
		
		Name name = new Name("Simon", "Mathson");
		final Calendar calendar = new GregorianCalendar(1992, 6, 4);
		final Date dateOfBirth = calendar.getTime();
		final Student pgrStudent = new PGRStudent(name, dateOfBirth, StudentType.PGR);
		
		dm.registerStudent(pgrStudent);
		
		assertTrue(pgrStudent.enoughCredits());
	}
}
