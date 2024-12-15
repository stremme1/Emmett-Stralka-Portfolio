package com.gradescope.hw6;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;

import org.junit.Test;

public class ListTest04_moveFirstElementTo {

	@Test(expected = NoSuchElementException.class)
	public void test_moveFirstElementTo_length0() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		assertTrue(list1.isEmpty());
		assertTrue(list2.isEmpty());

		list1.moveFirstElementTo(list2);
	}

	@Test
	public void test_moveFirstElementTo_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		assertEquals("( b )", list1.toString());

		List<String> list2 = new List<String>();
		assertTrue(list2.isEmpty());

		list1.moveFirstElementTo(list2);
		assertTrue(list1.isEmpty());
		assertEquals(list2.length(), 1);
		assertEquals("( b )", list2.toString());
	}

	@Test
	public void test_moveFirstElementTo_length3() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		assertEquals("( a b c )", list1.toString());

		List<String> list2 = new List<String>();
		assertTrue(list2.isEmpty());

		list1.moveFirstElementTo(list2);
		assertEquals(list1.length(), 2);
		assertEquals("( b c )", list1.toString());
		assertEquals(list2.length(), 1);
		assertEquals("( a )", list2.toString());

	}

	@Test
	public void test_moveFirstElementTo_nonEmptyOther() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		assertEquals("( a b c )", list1.toString());

		List<String> list2 = new List<String>();
		list2.addFirst("z");
		list2.addFirst("y");
		list2.addFirst("x");
		assertEquals("( x y z )", list2.toString());

		list1.moveFirstElementTo(list2);
		assertEquals(list1.length(), 2);
		assertEquals(list2.length(), 4);
		assertEquals("( b c )", list1.toString());
		assertEquals("( a x y z )", list2.toString());
	}

}
