package com.gradescope.hw6;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest02_addFirst {

	@Test
	public void test_addFirst_callOnce() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		assertEquals("( b )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(1, list1.length());
	}

	@Test
	public void test_addFirst_callTwice() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");
		assertEquals("( a b )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(2, list1.length());
	}

}
