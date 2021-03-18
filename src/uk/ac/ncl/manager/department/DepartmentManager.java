package uk.ac.ncl.manager.department;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Random;

/**
 * 
 * @author Joe Sheen
 * @version 1.2 31/10/2020
 * 
 * DepartmentManager - class for creating instances of departments to be managed. 
 * Allows students to be totalled, added, removed, amended.
 *
 */

public class DepartmentManager {
	private Map<StudentID, Student> STUDENT_MAP = new HashMap<StudentID, Student>();
	private Set<Name> supervisorSet = new HashSet<Name>();
	private Set<Modules> moduleSet = new HashSet<Modules>();
	
	/**
	 * Constructor a departmentManager
	 */
	public DepartmentManager() {
		
	}
	
	
	/**
	 * Counts the number students of a type (UG, PGT, PGR) that have been registered. 
	 * 
	 * @param studentType is the type of the student to be totalled 
	 * @return an integer representing the number a type of student within <code>STUDENT_MAP</code>.
	 * 
	 * @throws IllegalArgumentException if <code>STUDENT_MAP</code>is empty (no students to total).
	 */
	public int noOfStudents(StudentType studentType) {
		int counter = 0;
		if(STUDENT_MAP.isEmpty())
			throw new RuntimeException("Error: No students have registered.");
		else {
			for(Student s : STUDENT_MAP.values()) {
				if(s.getStudentType().equals(studentType)) {
					counter++;
				}
			}
			return counter;
		}	
	}
	
	/**
	 * Method for registering a student to a department
	 * @param student to be registered to the department 
	 * 
	 * @throws an IllegalArgumentException if students age is less than 17
	 * @throws an IllegalArgumentException if student is to young to be PG (PGT or PGR)
	 */
	public void registerStudent(Student student) {
		//checks to make sure the student passed in is valid
		if(student == null)
			throw new IllegalArgumentException("Error: Invalid student provided");
		
		//calculates the age of the student
		int age = calcAge(student);
		
		//If the students age is less than 17 throw exception due to being to young
		if(age < 17) {
			throw new IllegalArgumentException("Error: Student is to young");	
		} 
		
		Date dateOfIssue = new Date(); //date of issue SmartCards
		StudentID sid = StudentID.getInstance(); //creates a studentID for student
		SmartCard sc = new SmartCard(student.getName(), student.getDateOfBirth(), 
				dateOfIssue, sid, student.getStudentType()); //creates a SmartCard
		
		//Student is old enough for university
		if(student instanceof UGStudent) {
			//converts the student to a UGStudent
			UGStudent ug = (UGStudent) student;
			
			//file of ug modules
			String fileString = "C:/Users/joe12/eclipse-workspace/CSC8404-Coursework/"
					+ "src/uk/ac/ncl/manager/department/ugModules.csv";
			
			//calls the read from file method to read file
			readFromFile(fileString, student.getStudentType());
			
			//sets modules and allocates studentID and SmartCard
			ug.setModules(moduleSet);
			ug.setStudentID(sid);
			ug.setSmartCard(sc);
			
			//adds the student to the map (completes registration)
			STUDENT_MAP.put(ug.getStudentID(), ug);	
			
		} else if((student instanceof PGTStudent) && (age >= 20)) {
			//converts the student to a PGTStudent
			PGTStudent pgt = (PGTStudent) student;
			
			//file of pgt modules
			String fileString = "C:/Users/joe12/eclipse-workspace/CSC8404-Coursework/"
					+ "src/uk/ac/ncl/manager/department/pgtModules.csv";
			
			//calls the read from file method to read file
			readFromFile(fileString, student.getStudentType());
			
			//sets modules and allocates studentID and SmartCard
			pgt.setStudentID(sid);
			pgt.setModules(moduleSet);
			pgt.setSmartCard(sc);
			
			//adds the student to the map (completes registration)
			STUDENT_MAP.put(pgt.getStudentID(), pgt);	
			
		} else if((student instanceof PGRStudent) && (age >= 20)) {
			//converts the student to a PGTStudent
			PGRStudent pgr = (PGRStudent) student;
			
			//file of pgr supervisors
			String fileString = "C:/Users/joe12/eclipse-workspace/CSC8404-Coursework/"
					+ "src/uk/ac/ncl/manager/department/supervisor.csv";
			
			//calls the read from file method to read file
			readFromFile(fileString, student.getStudentType());
			
			//randomly allocates a supervisor to a pgr student
			Name[] supervisorArray = supervisorSet.toArray(new Name[supervisorSet.size()]);
			Random random = new Random();
			int randomSupervisor = random.nextInt(supervisorSet.size());
			pgr.setSupervisor(supervisorArray[randomSupervisor]);
			
			//issues SmartCard and ID
			pgr.setStudentID(sid);
			pgr.setSmartCard(sc);
			
			//adds the student to the map (completes registration)
			STUDENT_MAP.put(pgr.getStudentID(), pgr);
			
		}else {
			throw new IllegalArgumentException("Error: Student is to young to be a PG Student");
		}
	}
	
	/**
	 * Private method used to read supervisor/module data from files
	 * @param file to be read into the program
	 * @param studentType type of the student for determining where file data is stored
	 * 
	 */
	private void readFromFile(String file, StudentType studentType) {
		String line = ""; //empty sting for holding lines from file
		BufferedReader br = null; //reader to read file
		try {
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				//checks to see if the data being read in is a supervisor for a PGR
				if(studentType == StudentType.PGR) {
					supervisorSet.add(Name.valueOf(line));
				}
				//else its a module for a taught student (PGT or UG)
				else {
					moduleSet.add(Modules.valueOf(line));
				}
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.getMessage();
				}
			}
		}
	}
	
	/**
	 * Private method used for calculating the age of a student
	 * @param student that is having its age checked
	 * @return an integer value representing how old a student is
	 */
	private int calcAge(Student student) {
		Date now = new Date();
		long timePassed = now.getTime() - student.getDateOfBirth().getTime();
		double yearsBetween = timePassed / 3.15576e+10;
		return (int) Math.floor(yearsBetween);
	}
	
	/**
	 * Amends the data belonging to a student if they have been registered.
	 * 
	 * @param sid is the StudentID of the student having data amended 
	 * @param studentData is the new student data that is going to be stored
	 * 
	 * @throws IllegalArgumentException is thrown if the student can't be 
	 * located in <code>STUDENT_MAP</code>.
	 */
	public void amendStudentData(StudentID sid, Student studentData) {
		if(!STUDENT_MAP.containsKey(sid))
			throw new IllegalArgumentException("Error: Student not found");
		else 
			STUDENT_MAP.replace(sid, studentData);
	}
	
	/**
	 * Terminates the student by removing them from
	 * <code>STUDENT_MAP</code> if they have been enrolled.
	 * 
	 * @param sid StudentID used for terminating the correct student.
	 * 
	 * @throws IllegalArgumentException if student hasn't been registered
	 * (not found in the <code>STUDENT_MAP</code>).
	 */
	public void terminateStudent(StudentID sid) {
		if(!STUDENT_MAP.containsKey(sid))
			throw new IllegalArgumentException("Error: Student not found");
		else
			STUDENT_MAP.remove(sid);
	}
}