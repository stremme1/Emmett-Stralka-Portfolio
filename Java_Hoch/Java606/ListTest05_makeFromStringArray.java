package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest05_makeFromStringArray {

	@Test
	public void test_makeFromStringArray_length1() {
		String[] input = { "a" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("a");
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_makeFromStringArray_length2() {
		String[] input = { "a", "b" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("b");
		list2.addFirst("a");
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_makeFromStringArray_length5() {
		String[] input = { "a", "b", "c", "d", "e" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("e");
		list2.addFirst("d");
		list2.addFirst("c");
		list2.addFirst("b");
		list2.addFirst("a");
		assertEquals(list2, list1);
	}

}
