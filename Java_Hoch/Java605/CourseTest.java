package com.gradescope.hw5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Course class.
 * 
 * <pre>
 * Fun facts:
 * - Wally the Wart is the unofficial mascot of HMC
 * - Sammy the Owl is the mascot of Rice (where Prof Wu got her Bachelors)
 * </pre>
 */
public class CourseTest {

	/********************
	 * constructors
	 ********************/

	@Test
	public void testCourse() {
		new Course("CSCI060", 80);
	}

	/********************
	 * getters
	 ********************/

	@Test
	public void testGetCode() {
		Course cs60 = new Course("CSCI060", 80);
		assertEquals("CSCI060", cs60.getCode());
	}

	@Test
	public void testGetCap() {
		Course cs60 = new Course("CSCI060", 80);
		assertEquals(80, cs60.getCap());
	}

	/********************
	 * methods
	 ********************/

	@Test
	public void testGetNumEnrolled0() {
		Course cs60 = new Course("CSCI060", 80);
		assertEquals(0, cs60.getNumEnrolled());
	}

	@Test
	public void testEnrollStudentCap0() {
		Student wally = new Student("Wally", 1955);
		Course cs60 = new Course("CSCI060", 0);
		assertEquals(-1, cs60.enrollStudent(wally));
		assertEquals(0, cs60.getNumEnrolled());
	}

	@Test
	public void testEnrollStudentCap3() {
		Student wally = new Student("Wally", 1955);
		Student sammy = new Student("Sammy", 1912);
		Student tim = new Student("Tim", 1861);

		Course cs60 = new Course("CSCI060", 3);
		assertEquals(1, cs60.enrollStudent(wally));
		assertEquals(1, cs60.getNumEnrolled());
		assertEquals(2, cs60.enrollStudent(sammy));
		assertEquals(2, cs60.getNumEnrolled());
		assertEquals(3, cs60.enrollStudent(tim));
		assertEquals(3, cs60.getNumEnrolled());
	}

	@Test
	public void testEnrollStudentAlreadyEnrolled() {
		Student wally = new Student("Wally", 1955);
		Course cs60 = new Course("CSCI060", 3);
		assertEquals(1, cs60.enrollStudent(wally));
		assertEquals(1, cs60.getNumEnrolled());
		assertEquals(-1, cs60.enrollStudent(wally));
		assertEquals(1, cs60.getNumEnrolled());
	}

	@Test
	public void testGetStudents0() {
		Course cs60 = new Course("CSCI060", 80);
		String students = cs60.getStudents();
		assertEquals("[]", students);
	}

	@Test
	public void testGetStudents3() {
		Student wally = new Student("Wally", 1955);
		Student sammy = new Student("Sammy", 1912);
		Student tim = new Student("Tim", 1861);

		Course cs60 = new Course("CSCI060", 80);
		cs60.enrollStudent(wally);
		cs60.enrollStudent(sammy);
		cs60.enrollStudent(tim);
		String students = cs60.getStudents();
		assertEquals("[Wally [1955], Sammy [1912], Tim [1861]]", students);
	}

}
