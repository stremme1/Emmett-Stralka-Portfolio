package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest11_merge {

	@Test
	public void test_merge_list1_firstAndLast() {
		String[] input1 = { "a", "d" };
		String[] input2 = { "b", "c" };
		String[] correct = { "a", "b", "c", "d" };
		List<String> list1 = List.makeFromStringArray(input1);
		List<String> list2 = List.makeFromStringArray(input2);
		List<String> list3Correct = List.makeFromStringArray(correct);
		list1.merge(list2);
		assertEquals(list3Correct.length(), list1.length());
		assertEquals(list3Correct, list1);
		assertEquals(list2.length(), 0);
		assertEquals(new List<String>(), list2);
	}

	@Test
	public void test_merge_list2_firstAndLast() {
		String[] input1 = { "b", "c" };
		String[] input2 = { "a", "d" };
		String[] correct = { "a", "b", "c", "d" };
		List<String> list1 = List.makeFromStringArray(input1);
		List<String> list2 = List.makeFromStringArray(input2);
		List<String> list3Correct = List.makeFromStringArray(correct);
		list1.merge(list2);
		assertEquals(list3Correct.length(), list1.length());
		assertEquals(list3Correct, list1);
		assertEquals(list2.length(), 0);
		assertEquals(new List<String>(), list2);
	}

	@Test
	public void test_merge_interleave() {
		String[] input1 = { "a", "c", "e", "g", "h", "j" };
		String[] input2 = { "b", "d", "f", "i" };
		String[] correct = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		List<String> list1 = List.makeFromStringArray(input1);
		List<String> list2 = List.makeFromStringArray(input2);
		List<String> list3Correct = List.makeFromStringArray(correct);

		list1.merge(list2);
		assertEquals(list3Correct.length(), list1.length());
		assertEquals(list3Correct, list1);
		assertEquals(list2.length(), 0);
		assertEquals(new List<String>(), list2);
	}

}
