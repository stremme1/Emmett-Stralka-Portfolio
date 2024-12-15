package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest10_split {

	@Test
	public void test_split_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> correctOutput = new List<String>();

		List<String> correct = new List<String>();
		correct.addFirst("a");

		List<String> output = list1.split();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(correctOutput.length(), output.length());
		assertEquals(correctOutput, output); // list2 not modified
	}

	@Test
	public void test_split_length2() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correctOutput = new List<String>();
		correctOutput.addFirst("b");

		List<String> correct = new List<String>();
		correct.addFirst("a");

		List<String> output = list1.split();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(correctOutput.length(), output.length());
		assertEquals(correctOutput, output);
	}

	@Test
	public void test_split_length5() {
		List<String> list1 = new List<String>();
		list1.addFirst("e");
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correctOutput = new List<String>();
		correctOutput.addFirst("e");
		correctOutput.addFirst("d");

		List<String> correct = new List<String>();
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");
		List<String> output = list1.split();
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(correctOutput.length(), output.length());
		assertEquals(correctOutput, output); // list2 not modified
	}

	@Test
	public void test_split_length6() {
		List<String> list1 = new List<String>();
		list1.addFirst("f");
		list1.addFirst("e");
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correctOutput = new List<String>();
		correctOutput.addFirst("f");
		correctOutput.addFirst("e");
		correctOutput.addFirst("d");

		List<String> correct = new List<String>();
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");

		List<String> output = list1.split();
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(correctOutput.length(), output.length());
		assertEquals(correctOutput, output); // list2 not modified
	}

}
