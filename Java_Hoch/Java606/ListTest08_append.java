package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest08_append {

	@Test
	public void test_append_length1_length0() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		List<String> list2 = new List<String>();

		List<String> list2copy = new List<String>();

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length0_length1() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		list2.addFirst("a");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("a");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length1_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		List<String> list2 = new List<String>();
		list2.addFirst("b");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("b");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("b");
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length3_length3() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		List<String> list2 = new List<String>();
		list2.addFirst("f");
		list2.addFirst("e");
		list2.addFirst("d");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("f");
		list2copy.addFirst("e");
		list2copy.addFirst("d");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("f");
		correct.addFirst("e");
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

}
