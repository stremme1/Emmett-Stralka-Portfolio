package com.gradescope.hw6;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ListTest06_toStringArray {

	@Test
	public void test_toStringArray_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		String[] output = list1.toStringArray();
		String[] correct = { "a" };
		assertEquals(Arrays.toString(correct), Arrays.toString(output));
	}

	@Test
	public void test_toStringArray_length2() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");
		String[] output = list1.toStringArray();
		String[] correct = { "a", "b" };
		assertEquals(Arrays.toString(correct), Arrays.toString(output));
	}

	@Test
	public void test_toStringArray_length5() {
		List<String> list1 = new List<String>();
		list1.addFirst("e");
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		String[] output = list1.toStringArray();
		String[] correct = { "a", "b", "c", "d", "e" };
		assertEquals(Arrays.toString(correct), Arrays.toString(output));
	}

}
