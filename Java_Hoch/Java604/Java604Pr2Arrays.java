package com.gradescope.hw4;

import java.util.Arrays;

/**
 * Fill in the body of the methods below based upon the specification provided.
 * It may be helpful to look at the test cases provided in Hw4Pr2ArraysTest.java
 * to understand the intended behavior of the method.
 * 
 * All content is based upon problems at CodingBat.com.
 */

public class Hw4Pr2Arrays {

	/**
	 * Given an array of ints, return the number of 9's in the array.
	 * 
	 * Source: http://codingbat.com/prob/p184031 (answer available)
	 */
	public static int arrayCount9(int[] nums) {
		// TODO: Delete debugging statements from arrayCount9
		System.out.println("****** arrayCount9 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help

		return 0; // TODO: Implement arrayCount9
	}

	/**
	 * Given an array of ints, return true if one of the first 4 elements in the
	 * array is a 9. The array length may be less than 4.
	 * 
	 * Source: http://codingbat.com/prob/p186031 (answer available)
	 */
	public static boolean arrayFront9(int[] nums) {
		// TODO: Delete debugging statements from arrayFront9
		System.out.println("****** arrayFront9 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement arrayFront9
	}

	/**
	 * Given an array of ints, return true if .. 1, 2, 3, .. appears in the array
	 * somewhere.
	 * 
	 * Source: http://codingbat.com/prob/p136041 (answer available)
	 */
	public static boolean array123(int[] nums) {
		// TODO: Delete debugging statements from array123
		System.out.println("****** array123 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement array123
	}

	/**
	 * Given an array of ints, return the number of times that two 6's are next to
	 * each other in the array plus the number of times where a 6 is followed by a
	 * 7.
	 * 
	 * Source: http://codingbat.com/prob/p110019 (answer available)
	 */
	public static int array667(int[] nums) {
		// TODO: Delete debugging statements from array667
		System.out.println("****** array667 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return 0; // TODO: Implement array667
	}

	/**
	 * Given an array of ints, we'll say that a triple is a value appearing 3 times
	 * in a row in the array. Return true if the array does not contain any triples.
	 * 
	 * Source: http://codingbat.com/prob/p170221 (answer available)
	 */
	public static boolean noTriples(int[] nums) {
		// TODO: Delete debugging statements from noTriples
		System.out.println("****** noTriples ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement noTriples
	}

	/**
	 * Given an array of ints, return true if 6 appears as either the first or last
	 * element in the array. The array will be length 1 or more.
	 * 
	 * Source: http://codingbat.com/prob/p185685 (hint available)
	 */
	public static boolean firstLast6(int[] nums) {
		// TODO: Delete debugging statements from firstLast6
		System.out.println("****** firstLast6 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement firstLast6
	}

	/**
	 * Given an array of ints, return true if the array is length 1 or more, and the
	 * first element and the last element are equal.
	 * 
	 * Source: http://codingbat.com/prob/p118976 (hint available)
	 */
	public static boolean sameFirstLast(int[] nums) {
		// TODO: Delete debugging statements from sameFirstLast
		System.out.println("****** sameFirstLast ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement sameFirstLast
	}

	/**
	 * Return an int array length 3 containing the first 3 digits of pi, {3, 1, 4}.
	 * Hint: Don't overthink this one. No computation required!
	 * 
	 * Source: http://codingbat.com/prob/p167011
	 */
	public static int[] makePi() {
		// TODO: Delete debugging statements from makePi
		System.out.println("****** makePi ******"); // debug help
		System.out.println("Some number: " + 0); // debug help
		int[] retVal = new int[3];
		return retVal; // TODO: Implement makePi
	}

	/**
	 * Given 2 arrays of ints, a and b, return true if they have the same first
	 * element or they have the same last element. Both arrays will be length 1 or
	 * more.
	 * 
	 * Source: http://codingbat.com/prob/p191991
	 */
	public static boolean commonEnd(int[] a, int[] b) {
		// TODO: Delete debugging statements from commonEnd
		System.out.println("****** commonEnd ******"); // debug help
		System.out.println("a: " + Arrays.toString(a)); // debug help
		System.out.println("b: " + Arrays.toString(b)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return true; // TODO: Implement commonEnd
	}

	/**
	 * Given an array of ints length 3, return the sum of all the elements.
	 * 
	 * Source: http://codingbat.com/prob/p175763
	 */
	public static int sum3(int[] nums) {
		// TODO: Delete debugging statements from sum3
		System.out.println("****** sum3 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			// TODO: Implement sum3
		}
		return sum;
	}

	/**
	 * Given an array of ints length 3, return an array with the elements "rotated
	 * left" so {1, 2, 3} yields {2, 3, 1}.
	 * 
	 * Source: http://codingbat.com/prob/p185139
	 */
	public static int[] rotateLeft3(int[] nums) {
		// TODO: Delete debugging statements from rotateLeft3
		System.out.println("****** rotateLeft3 ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return null; // TODO: Implement rotateLeft3
	}

	/**
	 * Return the number of even ints in the given array. Note: the % "mod" operator
	 * computes the remainder, e.g. 5 % 2 is 1.
	 * 
	 * Source: http://codingbat.com/prob/p162010
	 */
	public static int countEvens(int[] nums) {
		// TODO: Delete debugging statements from countEvens
		System.out.println("****** countEvens ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return 0; // TODO: Implement countEvens
	}

	/**
	 * Given an array length 1 or more of ints, return the difference between the
	 * largest and smallest values in the array. Note: the built-in Math.min(v1, v2)
	 * and Math.max(v1, v2) methods return the smaller or larger of two values.
	 * 
	 * Source: http://codingbat.com/prob/p196640
	 */
	public static int bigDiff(int[] nums) {
		// TODO: Delete debugging statements from bigDiff
		System.out.println("****** bigDiff ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return 0; // TODO: Implement bigDiff
	}

	/**
	 * Return the "centered" average of an array of ints, which we'll say is the
	 * mean average of the values, except ignoring the largest and smallest values
	 * in the array. If there are multiple copies of the smallest value, ignore just
	 * one copy, and likewise for the largest value. Use int division to produce the
	 * final average. You may assume that the array is length 3 or more.
	 * 
	 * Source: http://codingbat.com/prob/p136585
	 */
	public static int centeredAverage(int[] nums) {
		// TODO: Delete debugging statements from centeredAverage
		System.out.println("****** centeredAverage ******"); // debug help
		System.out.println("input: " + Arrays.toString(nums)); // debug help
		System.out.println("Some number: " + 0); // debug help
		return 0; // TODO: Implement centeredAverage
	}

	public static void main(String[] args) {
		// You can add debugging statements here to test your methods!
	}
}
