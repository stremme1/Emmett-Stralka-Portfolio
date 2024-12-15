package com.gradescope.hw6;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ListTest00_all {

	/********************
	 * equals
	 ********************/
	
	/**
	 * Tests the constructor by creating a new List and checking for consistency
	 * using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_String() {
		List<String> list1 = new List<String>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_String() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		List<String> list3 = new List<String>();
		assertEquals(list1, list2);

		list1.addFirst("a");
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst("a");
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst("b");
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst("b");
		assertEquals(list1, list2);

		list1.addFirst("c");
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst("a");
		list3.addFirst("a");
		assertFalse(list2.equals(list3)); // same length, different elements
	}

	/**
	 * Tests the List constructor by creating a new List and checking for
	 * consistency using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_int() {
		List<Integer> list1 = new List<Integer>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_int() {
		List<Integer> list1 = new List<Integer>();
		List<Integer> list2 = new List<Integer>();
		List<Integer> list3 = new List<Integer>();
		assertEquals(list1, list2);

		list1.addFirst(new Integer(3));
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst(new Integer(3));
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst(new Integer(5));
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst(new Integer(5));
		assertEquals(list1, list2);

		list1.addFirst(new Integer(7));
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst(new Integer(3));
		list3.addFirst(new Integer(3));
		assertFalse(list2.equals(list3)); // same length, different elements
	}

	/**
	 * Tests the List constructor by creating a new List and checking for
	 * consistency using toString(), isEmpty(), and size().
	 */
	@Test
	public void test_constructor_Dog() {
		List<Dog> list1 = new List<Dog>();
		assertEquals("( )", list1.toString());
		assertTrue(list1.isEmpty());
		assertEquals(list1.length(), 0);
		assertEquals(list1.length(), 0);
	}

	/**
	 * Tests the equals method. Assumes that addFirst works as intended.
	 */
	@Test
	public void test_equals_Dog() {
		List<Dog> list1 = new List<Dog>();
		List<Dog> list2 = new List<Dog>();
		List<Dog> list3 = new List<Dog>();
		assertEquals(list1, list2);

		list1.addFirst(new Dog(2));
		assertFalse(list1.equals(list2)); // arg empty, this not

		list2.addFirst(new Dog(2));
		assertEquals(list1, list2);
		assertFalse(list3.equals(list1)); // this empty, arg not

		list2.addFirst(new Dog(4));
		assertFalse(list1.equals(list2)); // this shorter than arg

		list1.addFirst(new Dog(4));
		assertEquals(list1, list2);

		list1.addFirst(new Dog(6));
		assertFalse(list1.equals(list2)); // this longer than arg

		list3.addFirst(new Dog(2));
		list3.addFirst(new Dog(2));
		assertFalse(list2.equals(list3)); // same length, different elements
	}

	/********************
	 * addFirst
	 ********************/

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

	/********************
	 * removeFirst
	 ********************/

	@Test(expected = NoSuchElementException.class)
	public void test_removeFirst_length0() {
		List<String> list1 = new List<String>();
		list1.removeFirst();
	}

	@Test
	public void test_removeFirst_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> correct = new List<String>();

		String removed = list1.removeFirst();
		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

	@Test
	public void test_removeFirst_length2() {
		List<String> list1 = new List<String>();
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("b");

		String removed = list1.removeFirst();

		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

	@Test
	public void test_removeFirst_length4() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> correct = new List<String>();
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");

		String removed = list1.removeFirst();

		assertTrue(removed.equals("a"));
		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
	}

	/********************
	 * moveFirstElementTo
	 ********************/

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

	/********************
	 * makeFromStringArray
	 ********************/

	@Test
	public void test_makeFromStringArray_length1() {
		String[] input = { "a" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("a");
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_makeFromStringArray_length2() {
		String[] input = { "a", "b" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("b");
		list2.addFirst("a");
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_makeFromStringArray_length5() {
		String[] input = { "a", "b", "c", "d", "e" };
		List<String> list1 = List.makeFromStringArray(input);

		List<String> list2 = new List<String>();
		list2.addFirst("e");
		list2.addFirst("d");
		list2.addFirst("c");
		list2.addFirst("b");
		list2.addFirst("a");
		assertEquals(list2, list1);
	}

	/********************
	 * toStringArray
	 ********************/

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

	/********************
	 * add
	 ********************/

	@Test
	public void test_add_toEmptyList() {
		List<String> list1 = new List<String>();
		list1.add("z");
		assertEquals("( z )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(1, list1.length());
	}

	@Test
	public void test_add_to3elementList() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		list1.add("d");
		assertEquals("( a b c d )", list1.toString());
		assertFalse(list1.isEmpty());
		assertEquals(4, list1.length());
	}

	@Test
	public void test_add_to4elementList() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("d");
		assertEquals(list1.length(), list2.length());
		assertEquals(list1, list2);
	}

	/********************
	 * append
	 ********************/

	@Test
	public void test_append_length1_length0() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		List<String> list2 = new List<String>();

		List<String> list2copy = new List<String>();

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length0_length1() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();
		list2.addFirst("a");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("a");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length1_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");
		List<String> list2 = new List<String>();
		list2.addFirst("b");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("b");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("b");
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	@Test
	public void test_append_length3_length3() {
		List<String> list1 = new List<String>();
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");
		List<String> list2 = new List<String>();
		list2.addFirst("f");
		list2.addFirst("e");
		list2.addFirst("d");

		List<String> list2copy = new List<String>();
		list2copy.addFirst("f");
		list2copy.addFirst("e");
		list2copy.addFirst("d");

		list1.append(list2);

		List<String> correct = new List<String>();
		correct.addFirst("f");
		correct.addFirst("e");
		correct.addFirst("d");
		correct.addFirst("c");
		correct.addFirst("b");
		correct.addFirst("a");

		assertEquals(correct.length(), list1.length());
		assertEquals(correct, list1); // correct output
		assertEquals(list2copy.length(), list2.length());
		assertEquals(list2copy, list2); // list2 not modified
	}

	/********************
	 * reverse
	 ********************/

	@Test
	public void test_reverse_length0() {
		List<String> list1 = new List<String>();
		List<String> list2 = new List<String>();

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_reverse_length1() {
		List<String> list1 = new List<String>();
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.addFirst("a");

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	@Test
	public void test_reverse_length4() {
		List<String> list1 = new List<String>();
		list1.addFirst("d");
		list1.addFirst("c");
		list1.addFirst("b");
		list1.addFirst("a");

		List<String> list2 = new List<String>();
		list2.addFirst("a");
		list2.addFirst("b");
		list2.addFirst("c");
		list2.addFirst("d");

		list1.reverse();
		assertEquals(list1.length(), list2.length());
		assertEquals(list2, list1);
	}

	/********************
	 * split
	 ********************/

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

	/********************
	 * merge
	 ********************/

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

	/********************
	 * mergeSort
	 ********************/

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
