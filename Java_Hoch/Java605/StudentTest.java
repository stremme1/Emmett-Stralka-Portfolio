/**
 * 
 */
package com.gradescope.hw5;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Student class.
 * 
 * <pre>
 * Fun facts:
 * - Wally the Wart is the unofficial mascot of HMC
 * - Sammy the Owl is the mascot of Rice (where Prof Wu got her Bachelors)
 * </pre>
 */
public class StudentTest {

	/********************
	 * constructors
	 ********************/

	@Test
	public void testStudent() {
		new Student("Wally", 42);
	}

	/********************
	 * getters
	 ********************/

	@Test
	public void testGetId() {
		Student wally = new Student("Wally", 42);
		assertEquals(42, wally.getId());
	}

	@Test
	public void testGetName() {
		Student wally = new Student("Wally", 42);
		assertEquals("Wally", wally.getName());
	}

	/********************
	 * setters
	 ********************/

	@Test
	public void testSetName() {
		Student mascot = new Student("Wally", 42);
		mascot.setName("Sammy");
		assertEquals("Sammy", mascot.getName());
	}

	/********************
	 * methods
	 ********************/
	
	@Test
	public void testToString() {
		Student wally = new Student("Wally", 42);
		assertEquals("Wally [42]", wally.toString());
	}	
	
	@Test
	public void testEquals() {
		Student wally = new Student("Wally", 42);
		Student wally2 = new Student("Wally", 1955);
		Student hmc = new Student("Unnamed Mascot", 42);
		Student sammy = new Student("Sammy", 1912);

		assertTrue(wally.equals(hmc));
		assertFalse(wally.equals(wally2));
		assertFalse(wally.equals(sammy));
	}
}
