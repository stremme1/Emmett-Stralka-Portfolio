package com.gradescope.hw4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Hw4Pr1BasicsTest {

	@Test
	public void testSleepIn() {
		assertTrue(Hw4Pr1Basics.sleepIn(false, false));
		System.out.println("false, false: " + Hw4Pr1Basics.sleepIn(false, false));
		assertFalse(Hw4Pr1Basics.sleepIn(true, false));
		assertTrue(Hw4Pr1Basics.sleepIn(false, true));
		assertTrue(Hw4Pr1Basics.sleepIn(true, true));
	}

	@Test
	public void testMakes10() {
		assertTrue(Hw4Pr1Basics.makes10(9, 10));
		assertTrue(Hw4Pr1Basics.makes10(1, 9));
		assertTrue(Hw4Pr1Basics.makes10(10, 1));
		assertTrue(Hw4Pr1Basics.makes10(10, 10));
		assertTrue(Hw4Pr1Basics.makes10(8, 2));
		assertTrue(Hw4Pr1Basics.makes10(10, 42));
		assertTrue(Hw4Pr1Basics.makes10(12, -2));
		assertFalse(Hw4Pr1Basics.makes10(9, 9));
		assertFalse(Hw4Pr1Basics.makes10(8, 3));
	}

	@Test
	public void testMonkeyTrouble() {
		assertTrue(Hw4Pr1Basics.monkeyTrouble(true, true));
		assertTrue(Hw4Pr1Basics.monkeyTrouble(false, false));
		assertFalse(Hw4Pr1Basics.monkeyTrouble(true, false));
		assertFalse(Hw4Pr1Basics.monkeyTrouble(false, true));
	}

	@Test
	public void testIn1020() {
		assertTrue(Hw4Pr1Basics.in1020(12, 99));
		assertTrue(Hw4Pr1Basics.in1020(21, 12));
		assertTrue(Hw4Pr1Basics.in1020(99, 10));
		assertTrue(Hw4Pr1Basics.in1020(20, 20));
		assertFalse(Hw4Pr1Basics.in1020(8, 99));
		assertFalse(Hw4Pr1Basics.in1020(21, 21));
		assertFalse(Hw4Pr1Basics.in1020(9, 9));
	}

	@Test
	public void testIcyHot() {
		assertTrue(Hw4Pr1Basics.icyHot(120, -1));
		assertTrue(Hw4Pr1Basics.icyHot(-1, 120));
		assertFalse(Hw4Pr1Basics.icyHot(2, 120));
		assertFalse(Hw4Pr1Basics.icyHot(-1, 100));
		assertFalse(Hw4Pr1Basics.icyHot(-2, -2));
		assertFalse(Hw4Pr1Basics.icyHot(120, 120));
	}

	@Test
	public void testHasTeen() {
		assertTrue(Hw4Pr1Basics.hasTeen(13, 20, 10));
		assertTrue(Hw4Pr1Basics.hasTeen(20, 19, 10));
		assertTrue(Hw4Pr1Basics.hasTeen(20, 10, 13));
		assertTrue(Hw4Pr1Basics.hasTeen(19, 20, 12));
		assertTrue(Hw4Pr1Basics.hasTeen(12, 20, 19));
		assertTrue(Hw4Pr1Basics.hasTeen(12, 18, 20));
		assertTrue(Hw4Pr1Basics.hasTeen(14, 2, 20));
		assertFalse(Hw4Pr1Basics.hasTeen(1, 20, 12));
		assertFalse(Hw4Pr1Basics.hasTeen(12, 9, 20));
		assertFalse(Hw4Pr1Basics.hasTeen(4, 2, 20));
		assertFalse(Hw4Pr1Basics.hasTeen(11, 22, 22));
	}

	@Test
	public void testLastDigit() {
		assertTrue(Hw4Pr1Basics.lastDigit(7, 17));
		assertTrue(Hw4Pr1Basics.lastDigit(3, 113));
		assertTrue(Hw4Pr1Basics.lastDigit(114, 4));
		assertTrue(Hw4Pr1Basics.lastDigit(10, 0));
		assertFalse(Hw4Pr1Basics.lastDigit(114, 113));
		assertFalse(Hw4Pr1Basics.lastDigit(6, 17));
		assertFalse(Hw4Pr1Basics.lastDigit(11, 0));
	}

	@Test
	public void testPosNeg() {
		assertTrue(Hw4Pr1Basics.posNeg(1, -1, false));
		assertTrue(Hw4Pr1Basics.posNeg(-1, 1, false));
		assertTrue(Hw4Pr1Basics.posNeg(-4, -5, true));
		assertTrue(Hw4Pr1Basics.posNeg(-4, 5, false));
		assertTrue(Hw4Pr1Basics.posNeg(-1, -1, true));
		assertTrue(Hw4Pr1Basics.posNeg(5, -5, false));
		assertTrue(Hw4Pr1Basics.posNeg(-6, 6, false));
		assertTrue(Hw4Pr1Basics.posNeg(-5, -5, true));
		assertFalse(Hw4Pr1Basics.posNeg(-4, -5, false));
		assertFalse(Hw4Pr1Basics.posNeg(-4, 5, true));
		assertFalse(Hw4Pr1Basics.posNeg(1, 1, false));
		assertFalse(Hw4Pr1Basics.posNeg(-1, -1, false));
		assertFalse(Hw4Pr1Basics.posNeg(1, -1, true));
		assertFalse(Hw4Pr1Basics.posNeg(-1, 1, true));
		assertFalse(Hw4Pr1Basics.posNeg(1, 1, true));
		assertFalse(Hw4Pr1Basics.posNeg(-5, -6, false));
		assertFalse(Hw4Pr1Basics.posNeg(-2, -1, false));
		assertFalse(Hw4Pr1Basics.posNeg(1, 2, false));
		assertFalse(Hw4Pr1Basics.posNeg(-5, 6, true));
	}

	@Test
	public void testCalcMax2Numbers() {
		assertEquals(2, Hw4Pr1Basics.calculateMax(1, 2));
		assertEquals(2, Hw4Pr1Basics.calculateMax(2, 1));
		assertEquals(23, Hw4Pr1Basics.calculateMax(-1, 23));
		assertEquals(2, Hw4Pr1Basics.calculateMax(2, -1));
	}

	@Test
	public void testCalcMax4Numbers() {
		assertEquals(4, Hw4Pr1Basics.calculateMax(1, 2, 3, 4));
		assertEquals(7, Hw4Pr1Basics.calculateMax(7, 2, 3, 4));
		assertEquals(13, Hw4Pr1Basics.calculateMax(1, 2, 13, 4));
		assertEquals(12, Hw4Pr1Basics.calculateMax(1, 12, 3, 4));
		assertEquals(4, Hw4Pr1Basics.calculateMax(-11, -22, -33, 4));
		assertEquals(7, Hw4Pr1Basics.calculateMax(7, 2, 3, -4));
		assertEquals(4, Hw4Pr1Basics.calculateMax(1, -2, -13, 4));
		assertEquals(12, Hw4Pr1Basics.calculateMax(1, 12, -3, 4));
	}

	@Test
	public void testCalcAbsMax() {
		assertEquals(2, Hw4Pr1Basics.calculateAbsMax(1, 2));
		assertEquals(2, Hw4Pr1Basics.calculateAbsMax(2, 1));
		assertEquals(23, Hw4Pr1Basics.calculateAbsMax(-1, 23));
		assertEquals(2, Hw4Pr1Basics.calculateAbsMax(2, -1));
		assertEquals(-2, Hw4Pr1Basics.calculateAbsMax(-2, -1));
		assertEquals(-2, Hw4Pr1Basics.calculateAbsMax(-2, 1));
	}

	@Test
	public void testCalcPerimeter() {
		assertEquals(Math.PI, Hw4Pr1Basics.calculatePerimeter(0.5), 0);
		assertEquals(2 * Math.PI, Hw4Pr1Basics.calculatePerimeter(1), 0);
	}
}
