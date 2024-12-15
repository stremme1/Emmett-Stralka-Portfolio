package com.gradescope.hw8;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest02_minKey {

	/********************
	 * getMinKey
	 ********************/

	@Test(expected = IllegalArgumentException.class)
	public void testGetMinKey_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		tree.getMinKey(); // should produce an error!
	}

	@Test
	public void testGetMinKey_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals(new Integer(42), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree1_swap() {
		// same test as getMinKey1 but the key and values swapped
		BinarySearchTree<String, Integer> tree = new BinarySearchTree<String, Integer>();
		tree.put("Dodds", new Integer(42));
		assertEquals("Dodds", tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals(new Integer(42), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals(new Integer(26), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals(new Integer(26), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals(new Integer(18), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals(new Integer(26), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals(new Integer(26), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertEquals(new Integer(26), tree.getMinKey());
	}

	@Test
	public void testGetMinKey_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals(new Integer(18), tree.getMinKey());
	}

}
