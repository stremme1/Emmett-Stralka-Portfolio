package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest07_add {

	@Test
	public void test_add_toEmptyList() {
		List<String> list1 = new List<String>();
		list1.add("z");
		assertEquals("( z )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(1, list1.length());
	}

	@Test
	public void test_add_to3elementList() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		list1.add("d");
		assertEquals("( a b c d )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(4, list1.length());
	}

	@Test
	public void test_add_to4elementList() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		assertEquals(list1.length(), list2.length());
		assertEquals(list1, list2);
	}

}
