package com.gradescope.hw4;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Hw4Pr2ArraysTest {

	/**
	 * Testing arrayCount9
	 * 
	 * Source: http://codingbat.com/prob/p184031
	 */
	@Test
	public void testArrayCount9_1() {
		int[] arr = { 1, 2, 9 };
		assertEquals(1, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_2() {
		int[] arr = { 1, 9, 9 };
		assertEquals(2, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_3() {
		int[] arr = { 1, 9, 9, 3, 9 };
		assertEquals(3, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_4() {
		int[] arr = { 1, 2, 3 };
		assertEquals(0, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_5() {
		int[] arr = {};
		assertEquals(0, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_6() {
		int[] arr = { 4, 2, 4, 3, 1 };
		assertEquals(0, Hw4Pr2Arrays.arrayCount9(arr));
	}

	@Test
	public void testArrayCount9_7() {
		int[] arr = { 9, 2, 4, 3, 1 };
		assertEquals(1, Hw4Pr2Arrays.arrayCount9(arr));
	}

	/**
	 * Testing arrayFront9
	 * 
	 * Source: http://codingbat.com/prob/p186031
	 */
	@Test
	public void testArrayFront9_1() {
		int[] arr = { 1, 2, 9, 3, 4 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_2() {
		int[] arr = { 9, 2, 3 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_3() {
		int[] arr = { 1, 9, 9 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_4() {
		int[] arr = { 1, 9 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_5() {
		int[] arr = { 9 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_6() {
		int[] arr = { 3, 9, 2, 3, 3 };
		assertTrue(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_7() {
		int[] arr = { 5, 5 };
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_8() {
		int[] arr = { 2 };
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_9() {
		int[] arr = { 1, 2, 3, 4, 9 };
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_10() {
		int[] arr = { 1, 2, 3, 4, 5 };
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_11() {
		int[] arr = { 1, 2, 3 };
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	@Test
	public void testArrayFront9_12() {
		int[] arr = {};
		assertFalse(Hw4Pr2Arrays.arrayFront9(arr));
	}

	/**
	 * Testing array123
	 * 
	 * Source: http://codingbat.com/prob/p136041
	 */
	@Test
	public void testArray123_1() {
		int[] arr = { 1, 1, 2, 3, 1 };
		assertTrue(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_2() {
		int[] arr = { 1, 1, 2, 1, 2, 3 };
		assertTrue(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_3() {
		int[] arr = { 1, 2, 3, 1, 2, 3 };
		assertTrue(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_4() {
		int[] arr = { 1, 2, 3 };
		assertTrue(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_5() {
		int[] arr = { 1, 1, 2, 4, 1 };
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_6() {
		int[] arr = { 1, 1, 2, 1, 2, 1 };
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_7() {
		int[] arr = { 1, 1, 1 };
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_8() {
		int[] arr = { 1, 2 };
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_9() {
		int[] arr = { 1 };
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	@Test
	public void testArray123_10() {
		int[] arr = {};
		assertFalse(Hw4Pr2Arrays.array123(arr));
	}

	/**
	 * Testing array667
	 * 
	 * Source: http://codingbat.com/prob/p110019
	 */
	@Test
	public void testArray667_1() {
		int[] arr = { 1, 6, 3 };
		assertEquals(0, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_2() {
		int[] arr = { 6, 1 };
		assertEquals(0, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_3() {
		int[] arr = {};
		assertEquals(0, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_4() {
		int[] arr = { 1, 2, 3, 5, 6 };
		assertEquals(0, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_5() {
		int[] arr = { 6, 6, 2 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_6() {
		int[] arr = { 6, 6, 2, 6 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_7() {
		int[] arr = { 6, 7, 2, 6 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_8() {
		int[] arr = { 3, 6, 7, 6 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_9() {
		int[] arr = { 6, 3, 6, 6 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_10() {
		int[] arr = { 1, 2, 3, 6, 6 };
		assertEquals(1, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_11() {
		int[] arr = { 6, 6, 2, 6, 7 };
		assertEquals(2, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_12() {
		int[] arr = { 3, 6, 6, 7 };
		assertEquals(2, Hw4Pr2Arrays.array667(arr));
	}

	@Test
	public void testArray667_13() {
		int[] arr = { 6, 7, 6, 6 };
		assertEquals(2, Hw4Pr2Arrays.array667(arr));
	}

	/**
	 * Testing noTriples
	 * 
	 * Source: http://codingbat.com/prob/p170221
	 */
	@Test
	public void testNoTriples_1() {
		int[] arr = { 1, 1, 2, 2, 1 };
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_2() {
		int[] arr = { 1, 1, 2, 2, 1, 2, 1 };
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_3() {
		int[] arr = { 1, 2, 1 };
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_4() {
		int[] arr = { 1, 1 };
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_5() {
		int[] arr = { 1 };
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_6() {
		int[] arr = {};
		assertTrue(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_7() {
		int[] arr = { 1, 1, 2, 2, 2, 1 };
		assertFalse(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_8() {
		int[] arr = { 1, 1, 1, 2, 2, 2, 1 };
		assertFalse(Hw4Pr2Arrays.noTriples(arr));
	}

	@Test
	public void testNoTriples_9() {
		int[] arr = { 1, 1, 1 };
		assertFalse(Hw4Pr2Arrays.noTriples(arr));
	}

	/**
	 * Testing firstLast6
	 * 
	 * Source: http://codingbat.com/prob/p185685
	 */
	@Test
	public void testFirstLast6_0() {
		int x[] = { 1, 2, 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_1() {
		int x[] = { 6, 1, 2, 3 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_2() {
		int x[] = { 13, 6, 1, 2, 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_3() {
		int x[] = { 3, 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_4() {
		int x[] = { 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_5() {
		int x[] = { 5, 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_6() {
		int x[] = { 1, 2, 3, 4, 6 };
		assertTrue(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_7() {
		int x[] = { 13, 6, 1, 2, 3 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_8() {
		int x[] = { 3, 2, 1 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_9() {
		int x[] = { 3, 6, 1 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_10() {
		int x[] = { 3 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_11() {
		int x[] = { 5, 5 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	@Test
	public void testFirstLast6_12() {
		int x[] = { 1, 2, 3, 4 };
		assertFalse(Hw4Pr2Arrays.firstLast6(x));
	}

	/**
	 * Testing sameFirstLast
	 * 
	 * Source: http://codingbat.com/prob/p118976
	 */
	@Test
	public void testSameFirstLast_0() {
		int[] x = { 1, 2, 3 };
		assertFalse(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_1() {
		int[] x = {};
		assertFalse(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_2() {
		int[] x = { 1, 2, 3, 4, 5, 13 };
		assertFalse(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_3() {
		int[] x = { 1, 2, 3, 1 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_4() {
		int[] x = { 1, 2, 1 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_5() {
		int[] x = { 7 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_6() {
		int[] x = { 1, 2, 3, 4, 5, 1 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_7() {
		int[] x = { 13, 2, 3, 4, 5, 13 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	@Test
	public void testSameFirstLast_8() {
		int[] x = { 7, 7 };
		assertTrue(Hw4Pr2Arrays.sameFirstLast(x));
	}

	/**
	 * Testing makePi
	 * 
	 * Source: http://codingbat.com/prob/p167011
	 */
	@Test
	public void testMakePi() {
		int x[] = { 3, 1, 4 };
		assertEquals(Arrays.toString(x), Arrays.toString(Hw4Pr2Arrays.makePi()));
	}

	/**
	 * Testing commonEnd
	 * 
	 * Source: http://codingbat.com/prob/p191991
	 */
	@Test
	public void testCommonEnd_0() {
		int[] x = { 1, 2, 3 };
		int[] y = { 7, 3 };
		assertTrue(Hw4Pr2Arrays.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_1() {
		int[] x = { 1, 2, 3 };
		int[] y = { 1, 3 };
		assertTrue(Hw4Pr2Arrays.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_2() {
		int[] x = { 1, 2, 3 };
		int[] y = { 1 };
		assertTrue(Hw4Pr2Arrays.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_3() {
		int[] x = { 1, 2, 3 };
		int[] y = { 7, 3, 2 };
		assertFalse(Hw4Pr2Arrays.commonEnd(x, y));
	}

	@Test
	public void testCommonEnd_4() {
		int[] x = { 1, 2, 3 };
		int[] y = { 2 };
		assertFalse(Hw4Pr2Arrays.commonEnd(x, y));
	}

	/**
	 * Testing sum3
	 * 
	 * Source: http://codingbat.com/prob/p175763
	 */
	@Test
	public void testSum3_0() {
		int[] x = { 1, 2, 3 };
		assertEquals(6, Hw4Pr2Arrays.sum3(x));
	}

	@Test
	public void testSum3_1() {
		int[] x = { 5, 11, 2 };
		assertEquals(18, Hw4Pr2Arrays.sum3(x));
	}

	@Test
	public void testSum3_2() {
		int[] x = { 7, 0, 0 };
		assertEquals(7, Hw4Pr2Arrays.sum3(x));
	}

	@Test
	public void testSum3_3() {
		int[] x = { 1, 2, 1 };
		assertEquals(4, Hw4Pr2Arrays.sum3(x));
	}

	@Test
	public void testSum3_4() {
		int[] x = { 1, 1, 1 };
		assertEquals(3, Hw4Pr2Arrays.sum3(x));
	}

	@Test
	public void testSum3_5() {
		int[] x = { 2, 7, 2 };
		assertEquals(11, Hw4Pr2Arrays.sum3(x));
	}

	/**
	 * Testing rotateLeft3
	 * 
	 * Source: http://codingbat.com/prob/p185139
	 */
	@Test
	public void testRotateLeft3_0() {
		int[] x = { 1, 2, 3 };
		int[] y = { 2, 3, 1 };
		assertEquals(Arrays.toString(y), Arrays.toString(Hw4Pr2Arrays.rotateLeft3(x)));
	}

	@Test
	public void testRotateLeft3_1() {
		int[] x = { 5, 11, 9 };
		int[] y = { 11, 9, 5 };
		assertEquals(Arrays.toString(y), Arrays.toString(Hw4Pr2Arrays.rotateLeft3(x)));
	}

	@Test
	public void testRotateLeft3_2() {
		int[] x = { 7, 0, 0 };
		int[] y = { 0, 0, 7 };
		assertEquals(Arrays.toString(y), Arrays.toString(Hw4Pr2Arrays.rotateLeft3(x)));
	}

	@Test
	public void testRotateLeft3_3() {
		int[] x = { 1, 2, 1 };
		int[] y = { 2, 1, 1 };
		assertEquals(Arrays.toString(y), Arrays.toString(Hw4Pr2Arrays.rotateLeft3(x)));
	}

	@Test
	public void testRotateLeft3_4() {
		int[] x = { 0, 0, 1 };
		int[] y = { 0, 1, 0 };
		assertEquals(Arrays.toString(y), Arrays.toString(Hw4Pr2Arrays.rotateLeft3(x)));
	}

	/**
	 * Testing countEvens
	 * 
	 * Source: http://codingbat.com/prob/p162010
	 */
	@Test
	public void testCountEvens_0() {
		int[] x = { 2, 1, 2, 3, 4 };
		assertEquals(3, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_1() {
		int[] x = { 2, 2, 0 };
		assertEquals(3, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_2() {
		int[] x = { 1, 3, 5 };
		assertEquals(0, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_3() {
		int[] x = {};
		assertEquals(0, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_4() {
		int[] x = { 11, 9, 0, 1 };
		assertEquals(1, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_5() {
		int[] x = { 2, 11, 9, 0 };
		assertEquals(2, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_6() {
		int[] x = { 2 };
		assertEquals(1, Hw4Pr2Arrays.countEvens(x));
	}

	@Test
	public void testCountEvens_7() {
		int[] x = { 2, 5, 12 };
		assertEquals(2, Hw4Pr2Arrays.countEvens(x));
	}

	/**
	 * Test bigDiff
	 * 
	 * Source: http://codingbat.com/prob/p196640
	 */
	@Test
	public void testBigDiff_0() {
		int[] x = { 10, 3, 5, 6 };
		assertEquals(7, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_1() {
		int[] x = { 7, 2, 10, 9 };
		assertEquals(8, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_2() {
		int[] x = { 2, 10, 7, 2 };
		assertEquals(8, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_3() {
		int[] x = { 2, 10 };
		assertEquals(8, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_4() {
		int[] x = { 10, 2 };
		assertEquals(8, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_5() {
		int[] x = { 10, 0 };
		assertEquals(10, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_6() {
		int[] x = { 2, 3 };
		assertEquals(1, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_7() {
		int[] x = { 7, 7, 6, 8, 5, 5, 6 };
		assertEquals(3, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_8() {
		int[] x = { 2, 2 };
		assertEquals(0, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_9() {
		int[] x = { 5, 1, 6, 1, 9, 9 };
		assertEquals(8, Hw4Pr2Arrays.bigDiff(x));
	}

	@Test
	public void testBigDiff_10() {
		int[] x = { 7, 6, 8, 5 };
		assertEquals(3, Hw4Pr2Arrays.bigDiff(x));
	}

	/**
	 * Testing centeredAverage
	 * 
	 * Source: http://codingbat.com/prob/p136585
	 */
	@Test
	public void testCenteredAverage_0() {
		int[] x = { -10, -4, -2, -4, -2, 0 };
		assertEquals(-3, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_1() {
		int[] x = { 1, 1, 5, 5, 10, 8, 7 };
		assertEquals(5, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_2() {
		int[] x = { 5, 3, 4, 6, 2 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_3() {
		int[] x = { 5, 3, 4, 0, 100 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_4() {
		int[] x = { 100, 0, 5, 3, 4 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_5() {
		int[] x = { 4, 0, 100 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_6() {
		int[] x = { 0, 2, 3, 4, 100 };
		assertEquals(3, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_7() {
		int[] x = { 1, 1, 100 };
		assertEquals(1, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_8() {
		int[] x = { 7, 7, 7 };
		assertEquals(7, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_9() {
		int[] x = { 1, 7, 8 };
		assertEquals(7, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_10() {
		int[] x = { 1, 1, 99, 99 };
		assertEquals(50, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_11() {
		int[] x = { 1000, 0, 1, 99 };
		assertEquals(50, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_12() {
		int[] x = { 4, 4, 4, 4, 5 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_13() {
		int[] x = { 4, 4, 4, 1, 5 };
		assertEquals(4, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_14() {
		int[] x = { 6, 4, 8, 12, 3 };
		assertEquals(6, Hw4Pr2Arrays.centeredAverage(x));
	}

	@Test
	public void testCenteredAverage_15() {
		int[] x = { 1, 2, 3, 4, 100 };
		assertEquals(3, Hw4Pr2Arrays.centeredAverage(x));
	}
}
