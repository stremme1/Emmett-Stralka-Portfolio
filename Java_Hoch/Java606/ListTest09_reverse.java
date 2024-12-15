package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest09_reverse {

	@Test
	public void test_reverse_length0() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_reverse_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.addFirst("a");

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_reverse_length4() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.addFirst("a");
		list2.addFirst("b");
		list2.addFirst("c");
		list2.addFirst("d");

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

}
