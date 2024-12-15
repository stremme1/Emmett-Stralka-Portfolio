package com.gradescope.hw6;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ListTest03_removeFirst {

	@Test(expected = NoSuchElementException.class)
	public void test_removeFirst_length0() {
		List<String> list1 = new List<String>();
		list1.removeFirst();
	}

	@Test
	public void test_removeFirst_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> correct = new List<String>();

		String removed = list1.removeFirst();
		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

	@Test
	public void test_removeFirst_length2() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("b");

		String removed = list1.removeFirst();

		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

	@Test
	public void test_removeFirst_length4() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");

		String removed = list1.removeFirst();

		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

}
