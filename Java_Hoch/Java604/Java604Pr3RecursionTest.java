package com.gradescope.hw4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Hw4Pr3RecursionTest {

	@Test
	public void testCountDivisibleBy_0_42() {
		assertEquals(1, Hw4Pr3Recursion.countDivisibleBy(0, 42));
	}

	@Test
	public void testCountDivisibleBy_47_1() {
		assertEquals(48, Hw4Pr3Recursion.countDivisibleBy(47, 1));
	}

	@Test
	public void testCountDivisibleBy_10_3() {
		assertEquals(4, Hw4Pr3Recursion.countDivisibleBy(10, 3));
	}

	@Test
	public void testCountDivisibleBy_42_47() {
		assertEquals(1, Hw4Pr3Recursion.countDivisibleBy(42, 47));
	}

	@Test
	public void testCountDivisibleBy_47_47() {
		assertEquals(2, Hw4Pr3Recursion.countDivisibleBy(47, 47));
	}
}