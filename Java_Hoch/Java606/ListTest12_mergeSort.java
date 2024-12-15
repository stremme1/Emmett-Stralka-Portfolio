package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest12_mergeSort {

	@Test
	public void test_mergeSort_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("a");

		list1.mergeSort();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1);
	}

	@Test
	public void test_mergeSort_length2_ab() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("b");
		correct.addFirst("a");

		list1.mergeSort();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1);
	}

	@Test
	public void test_mergeSort_length2_ba() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		list1.addFirst("b");

		List<String> correct = new List<String>();
		correct.addFirst("b");
		correct.addFirst("a");

		list1.mergeSort();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1);
	}

	@Test
	public void test_mergeSort_length5_abcde() {
		List<String> list1 = new List<String>();
		list1.addFirst("e");
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("e");
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");

		list1.mergeSort();

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1);
	}

	@Test
	public void test_mergeSort_length5_eadbc() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("d");
		list1.addFirst("a");
		list1.addFirst("e");

		List<String> correct = new List<String>();
		correct.addFirst("e");
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");

		list1.mergeSort();
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1);
	}

}
