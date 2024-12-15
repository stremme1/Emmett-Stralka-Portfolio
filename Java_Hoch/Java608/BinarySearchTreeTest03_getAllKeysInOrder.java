package com.gradescope.hw8;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest03_getAllKeysInOrder {

	/********************
	 * toString
	 ********************/

	@Test
	public void testToString_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertEquals("[]", tree.toString());
	}

	@Test
	public void testToString_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals("[42]", tree.toString());
	}

	@Test
	public void testToString_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals("[42, 52]", tree.toString());
	}

	@Test
	public void testToString_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals("[26, 42]", tree.toString());
	}

	@Test
	public void testToString_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals("[26, 42, 52]", tree.toString());
	}

	@Test
	public void testToString_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals("[18, 26, 42, 52]", tree.toString());
	}

	@Test
	public void testToString_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals("[26, 30, 42, 52]", tree.toString());
	}

	@Test
	public void testToString_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals("[26, 42, 45, 52]", tree.toString());
	}

	@Test
	public void testToString_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertEquals("[26, 42, 52, 60]", tree.toString());
	}

	@Test
	public void testToString_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals("[18, 26, 30, 42, 45, 52, 60]", tree.toString());
	}

	/********************
	 * containsValue
	 ********************/

	@Test
	public void testContainsValue_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertFalse(tree.containsValue("Dodds"));
		assertFalse(tree.containsValue("Ben"));
		assertFalse(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertTrue(tree.containsValue("Dodds"));
		assertFalse(tree.containsValue("Ben"));
		assertFalse(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertTrue(tree.containsValue("Dodds"));
		assertFalse(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertFalse(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertTrue(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertTrue(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertFalse(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertTrue(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertTrue(tree.containsValue("Ran"));
		assertFalse(tree.containsValue("Beth"));
		assertFalse(tree.containsValue("Julie"));
		assertFalse(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	@Test
	public void testContainsValue_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertTrue(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
		assertTrue(tree.containsValue("Ran"));
		assertTrue(tree.containsValue("Beth"));
		assertTrue(tree.containsValue("Julie"));
		assertTrue(tree.containsValue("Stone"));
		assertFalse(tree.containsValue("Breeden"));
		assertFalse(tree.containsValue("Wu"));
	}

	/********************
	 * put that updates value
	 ********************/

	@Test
	public void testPut_tree1_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals("Dodds", tree.get(new Integer(42)));

		// replace "Dodds" with "Beth" as the value for 42
		assertEquals("Dodds", tree.put(new Integer(42), "Beth"));
		assertEquals("Beth", tree.get(new Integer(42)));
		assertFalse(tree.containsValue("Dodds"));
		assertTrue(tree.containsValue("Beth"));
	}

	@Test
	public void testPut_tree2right_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals("Colleen", tree.get(new Integer(52)));

		// replace "Colleen" with "Julie" as the value for 52
		assertEquals("Colleen", tree.put(new Integer(52), "Julie"));
		assertEquals("Julie", tree.get(new Integer(52)));
		assertFalse(tree.containsValue("Colleen"));
		assertTrue(tree.containsValue("Julie"));
	}

	@Test
	public void testPut_tree2left_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals("Ben", tree.get(new Integer(26)));

		// replace "Ben" with "Colleen" as the value for 26
		assertEquals("Ben", tree.put(new Integer(26), "Colleen"));
		assertEquals("Colleen", tree.get(new Integer(26)));
		assertFalse(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
	}

	@Test
	public void testPut_tree3_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals("Ben", tree.get(new Integer(26)));

		// replace "Ben" with "Colleen" as the value for 26
		assertEquals("Ben", tree.put(new Integer(26), "Colleen"));
		assertEquals("Colleen", tree.get(new Integer(26)));
		assertFalse(tree.containsValue("Ben"));
		assertTrue(tree.containsValue("Colleen"));
	}

	@Test
	public void testPut_tree4a_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals("Beth", tree.get(new Integer(18)));

		// replace "Beth" with "Julie" as the value for 18
		assertEquals("Beth", tree.put(new Integer(18), "Julie"));
		assertEquals("Julie", tree.get(new Integer(18)));
		assertFalse(tree.containsValue("Beth"));
		assertTrue(tree.containsValue("Julie"));
	}

	@Test
	public void testPut_tree4b_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals("Stone", tree.get(new Integer(30)));

		// replace "Stone" with "Beth" as the value for 30
		assertEquals("Stone", tree.put(new Integer(30), "Beth"));
		assertEquals("Beth", tree.get(new Integer(30)));
		assertFalse(tree.containsValue("Stone"));
		assertTrue(tree.containsValue("Beth"));
	}

	@Test
	public void testPut_tree4c_replace() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals("Colleen", tree.get(new Integer(52)));

		// replace "Colleen" with "Julie" as the value for 52
		assertEquals("Colleen", tree.put(new Integer(52), "Julie"));
		assertEquals("Julie", tree.get(new Integer(52)));
		assertFalse(tree.containsValue("Colleen"));
		assertTrue(tree.containsValue("Julie"));
	}

}
