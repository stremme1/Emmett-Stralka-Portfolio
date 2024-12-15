package com.gradescope.hw8;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTreeTest04_remove {

	/********************
	 * remove
	 ********************/

	@Test
	public void testRemove_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		String value = tree.remove(new Integer(7));
		assertNull(value); // did not contain the previous key!
	}

	@Test
	public void testRemove_tree1_root() {
		// remove root in tree with 1 node
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals(1, tree.size());

		assertEquals("Dodds", tree.remove(new Integer(42)));
		assertNull(tree.get(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsValue("Dodds"));
		assertEquals(0, tree.size());
	}

	@Test
	public void testRemove_tree2right_root() {
		// remove root with only right subtree
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals(2, tree.size());

		assertEquals("Dodds", tree.remove(new Integer(42)));
		assertNull(tree.get(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsValue("Dodds"));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals(1, tree.size());
	}

	@Test
	public void testRemove_tree2left_root() {
		// remove root with only left subtree
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals(2, tree.size());

		assertEquals("Dodds", tree.remove(new Integer(42)));
		assertNull(tree.get(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsValue("Dodds"));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals(1, tree.size());
	}

	@Test
	public void testRemove_tree3_root() {
		// remove root with left and right subtrees
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals(3, tree.size());

		assertEquals("Dodds", tree.remove(new Integer(42)));
		assertNull(tree.get(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsValue("Dodds"));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals(2, tree.size());
	}

	@Test
	public void testRemove_tree7_leftChild() {
		// remove left child node
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
		assertEquals(7, tree.size());

		assertEquals("Ben", tree.remove(new Integer(26)));
		assertNull(tree.get(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsValue("Ben"));
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
		assertEquals(6, tree.size());
	}

	@Test
	public void testRemove_tree7_rightChild() {
		// remove right child node
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
		assertEquals(7, tree.size());

		assertEquals("Colleen", tree.remove(new Integer(52)));
		assertNull(tree.get(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsValue("Colleen"));
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Ran", tree.get(new Integer(60)));
		assertEquals(6, tree.size());
	}

	@Test
	public void testRemove_tree7_none() {
		// remove keys not in tree
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
		assertEquals(7, tree.size());

		assertNull(tree.remove(new Integer(10)));
		assertNull(tree.remove(new Integer(22)));
		assertNull(tree.remove(new Integer(27)));
		assertNull(tree.remove(new Integer(34)));
		assertNull(tree.remove(new Integer(44)));
		assertNull(tree.remove(new Integer(47)));
		assertNull(tree.remove(new Integer(55)));
		assertNull(tree.remove(new Integer(65)));
		assertEquals(7, tree.size());
	}

	@Test
	public void testRemove_tree4leftUnbalancedLeft_root() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4leftUnbalanced();
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));

		assertEquals("Dodds", tree.remove(new Integer(4)));
		assertNull(tree.get(new Integer(4)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));
	}

	@Test
	public void testRemove_tree4leftUnbalanced_child() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(new Integer(4), "Dodds");
		tree.put(new Integer(3), "Colleen");
		tree.put(new Integer(2), "Beth");
		tree.put(new Integer(1), "A Prof");
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));

		assertEquals("Colleen", tree.remove(new Integer(3)));
		assertNull(tree.get(new Integer(3)));
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));
	}

	@Test
	public void testRemove_treeUnbalancedRight_root() {
		// Test tree:
		// ....1.........
		// ......2.......
		// ........3.....
		// ...........4..
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(new Integer(1), "A Prof");
		tree.put(new Integer(2), "Beth");
		tree.put(new Integer(3), "Colleen");
		tree.put(new Integer(4), "Dodds");
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));

		assertEquals("A Prof", tree.remove(new Integer(1)));
		assertNull(tree.get(new Integer(1)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Dodds", tree.get(new Integer(4)));
	}

	@Test
	public void testRemove_treeUnbalancedRight_child() {
		// Test tree:
		// ....1.........
		// ......2.......
		// ........3.....
		// ...........4..
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(new Integer(1), "A Prof");
		tree.put(new Integer(2), "Beth");
		tree.put(new Integer(3), "Colleen");
		tree.put(new Integer(4), "Dodds");
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Colleen", tree.get(new Integer(3)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));

		assertEquals("Colleen", tree.remove(new Integer(3)));
		assertNull(tree.get(new Integer(3)));
		assertEquals("Dodds", tree.get(new Integer(4)));
		assertEquals("Beth", tree.get(new Integer(2)));
		assertEquals("A Prof", tree.get(new Integer(1)));
	}

}
