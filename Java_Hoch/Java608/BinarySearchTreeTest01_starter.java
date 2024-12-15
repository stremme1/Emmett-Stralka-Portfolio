package com.gradescope.hw8;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BinarySearchTreeTest01_starter {

	/********************
	 * constructors
	 ********************/

	@Test
	@SuppressWarnings("unused")
	public void testConstructors() {
		// only checking for compile and runtime errors
		Map<String, String> mapStrStr = new BinarySearchTree<String, String>();
		Map<Integer, Object> mapIntOb = new BinarySearchTree<Integer, Object>();
		Map<Date, int[]> mapDateIntAr = new BinarySearchTree<Date, int[]>();
	}

	/********************
	 * isEmpty
	 ********************/

	@Test
	public void testIsEmpty_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertTrue(tree.isEmpty());
	}

	@Test
	public void testIsEmpty_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertFalse(tree.isEmpty());
	}

	/********************
	 * size
	 ********************/

	@Test
	public void testSize_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertEquals(0, tree.size());
	}

	@Test
	public void testSize_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals(1, tree.size());
	}

	@Test
	public void testSize_tree1_update() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		tree.put(new Integer(42), "Prof Dodds");
		assertEquals(1, tree.size());
	}

	@Test
	public void testSize_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals(2, tree.size());
	}

	@Test
	public void testSize_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals(2, tree.size());
	}

	@Test
	public void testSize_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals(3, tree.size());
	}

	@Test
	public void testSize_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals(4, tree.size());
	}

	@Test
	public void testSize_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals(4, tree.size());
	}

	@Test
	public void testSize_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals(4, tree.size());
	}

	@Test
	public void testSize_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertEquals(4, tree.size());
	}

	@Test
	public void testSize_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals(7, tree.size());
	}

	/********************
	 * height
	 ********************/

	@Test
	public void testHeight_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertEquals(-1, tree.height());
	}

	@Test
	public void testHeight_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals(0, tree.height());
	}

	@Test
	public void testHeight_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals(1, tree.height());
	}

	@Test
	public void testHeight_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals(1, tree.height());
	}

	@Test
	public void testHeight_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals(1, tree.height());
	}

	@Test
	public void testHeight_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals(2, tree.height());
	}

	@Test
	public void testHeight_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals(2, tree.height());
	}

	@Test
	public void testHeight_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals(2, tree.height());
	}

	@Test
	public void testHeight_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertEquals(2, tree.height());
	}

	@Test
	public void testHeight_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals(2, tree.height());
	}

	/********************
	 * containsKey
	 ********************/

	@Test
	public void testContainsKey_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertFalse(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertFalse(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertFalse(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertFalse(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertFalse(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertFalse(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertFalse(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertFalse(tree.containsKey(new Integer(10)));
		assertTrue(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertTrue(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertTrue(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertFalse(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertFalse(tree.containsKey(new Integer(10)));
		assertFalse(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertFalse(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertFalse(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertTrue(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	@Test
	public void testContainsKey_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertFalse(tree.containsKey(new Integer(10)));
		assertTrue(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertTrue(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertTrue(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertTrue(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

	/********************
	 * get
	 ********************/

	@Test
	public void testGet_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertEquals(null, tree.get(new Integer(42)));
	}

	@Test
	public void testGet_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals("Dodds", tree.get(new Integer(42)));
	}

	@Test
	public void testGet_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
	}

	@Test
	public void testGet_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
	}

	@Test
	public void testGet_tree3() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree3();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
	}

	@Test
	public void testGet_tree4a() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4a();
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
	}

	@Test
	public void testGet_tree4b() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4b();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
	}

	@Test
	public void testGet_tree4c() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4c();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
	}

	@Test
	public void testGet_tree4d() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree4d();
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
	}

	@Test
	public void testGet_tree7() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree7();
		assertEquals("Beth", tree.get(new Integer(18)));
		assertEquals("Ben", tree.get(new Integer(26)));
		assertEquals("Stone", tree.get(new Integer(30)));
		assertEquals("Dodds", tree.get(new Integer(42)));
		assertEquals("Julie", tree.get(new Integer(45)));
		assertEquals("Colleen", tree.get(new Integer(52)));
		assertEquals("Ran", tree.get(new Integer(60)));
	}

	/********************
	 * clear
	 ********************/

	@Test
	public void testClear_tree0() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree0();
		assertEquals(0, tree.size());
		tree.clear();
		assertEquals(0, tree.size());
	}

	@Test
	public void testClear_tree1() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree1();
		assertEquals(1, tree.size());
		tree.clear();
		assertEquals(0, tree.size());
	}

	@Test
	public void testClear_tree2right() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2right();
		assertEquals(2, tree.size());
		tree.clear();
		assertEquals(0, tree.size());
	}

	@Test
	public void testClear_tree2left() {
		BinarySearchTree<Integer, String> tree = BinarySearchTreeTest_helper.makeTree2left();
		assertEquals(2, tree.size());
		tree.clear();
		assertEquals(0, tree.size());
	}

	/********************
	 * put
	 ********************/

	@Test
	public void testPut_checkReturn() {
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		assertNull(tree.put(new Integer(42), "Dodds"));
		assertNull(tree.put(new Integer(26), "Ben"));
		assertNull(tree.put(new Integer(52), "Colleen"));
		assertNull(tree.put(new Integer(60), "Ran"));
		assertNull(tree.put(new Integer(18), "Beth"));
		assertNull(tree.put(new Integer(45), "Julie"));
		assertNull(tree.put(new Integer(30), "Stone"));
	}

	/********************
	 * putAll
	 ********************/

	@Test
	public void testPutAll_tree7() {
		// we do not have a guarantee of the structure when using putAll
		Map<Integer, String> otherMap = new HashMap<Integer, String>();
		otherMap.put(new Integer(42), "Dodds");
		otherMap.put(new Integer(26), "Ben");
		otherMap.put(new Integer(52), "Colleen");
		otherMap.put(new Integer(60), "Ran");
		otherMap.put(new Integer(18), "Beth");
		otherMap.put(new Integer(45), "Julie");
		otherMap.put(new Integer(30), "Stone");

		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.putAll(otherMap);
		assertFalse(tree.containsKey(new Integer(10)));
		assertTrue(tree.containsKey(new Integer(18)));
		assertTrue(tree.containsKey(new Integer(26)));
		assertTrue(tree.containsKey(new Integer(30)));
		assertTrue(tree.containsKey(new Integer(42)));
		assertTrue(tree.containsKey(new Integer(45)));
		assertTrue(tree.containsKey(new Integer(52)));
		assertTrue(tree.containsKey(new Integer(60)));
		assertFalse(tree.containsKey(new Integer(90)));
	}

}
