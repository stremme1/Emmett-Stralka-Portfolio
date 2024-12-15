package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest01_equals {

	/**
	 * Tests the constructor by creating a new List and checking for consistency
	 * using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_String() {
		List<String> list1 = new List<String>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_String() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		List<String> list3 = new List<String>();
		assertEquals(list1, list2);

		list1.addFirst("a");
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst("a");
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst("b");
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst("b");
		assertEquals(list1, list2);

		list1.addFirst("c");
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst("a");
		list3.addFirst("a");
		assertFalse(list2.equals(list3)); // same length, different elements
	}

	/**
	 * Tests the List constructor by creating a new List and checking for
	 * consistency using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_int() {
		List<Integer> list1 = new List<Integer>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_int() {
		List<Integer> list1 = new List<Integer>();
		List<Integer> list2 = new List<Integer>();
		List<Integer> list3 = new List<Integer>();
		assertEquals(list1, list2);

		list1.addFirst(new Integer(3));
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst(new Integer(3));
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst(new Integer(5));
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst(new Integer(5));
		assertEquals(list1, list2);

		list1.addFirst(new Integer(7));
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst(new Integer(3));
		list3.addFirst(new Integer(3));
		assertFalse(list2.equals(list3)); // same length, different elements
	}

	/**
	 * Tests the List constructor by creating a new List and checking for
	 * consistency using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_Dog() {
		List<Dog> list1 = new List<Dog>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_Dog() {
		List<Dog> list1 = new List<Dog>();
		List<Dog> list2 = new List<Dog>();
		List<Dog> list3 = new List<Dog>();
		assertEquals(list1, list2);

		list1.addFirst(new Dog(2));
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst(new Dog(2));
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst(new Dog(4));
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst(new Dog(4));
		assertEquals(list1, list2);

		list1.addFirst(new Dog(6));
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst(new Dog(2));
		list3.addFirst(new Dog(2));
		assertFalse(list2.equals(list3)); // same length, different elements
	}

}
