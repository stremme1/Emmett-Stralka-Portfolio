package com.gradescope.hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {

	double EPSILON = Complex.EPSILON;

	/********************
	 * constructors
	 ********************/

	@Test
	public void testComplex2Args() {
		new Complex(42.0, 60.0);
	}

	@Test
	public void testComplex0Args() {
		new Complex();
	}

	/********************
	 * getters
	 ********************/

	@Test
	public void testGetters() {
		Complex c1 = new Complex(42.0, 60.0);
		assertEquals(42.0, c1.getReal(), EPSILON);
		assertEquals(60.0, c1.getImag(), EPSILON);
		
		Complex c2 = new Complex();
		assertEquals(0.0, c2.getReal(), EPSILON);
		assertEquals(0.0, c2.getImag(), EPSILON);
	}

	/********************
	 * methods
	 ********************/

	@Test
	public void testMagnitude() {
		Complex c2 = new Complex(3.0, 4.0);
		assertEquals(5.0, c2.magnitude(), EPSILON);
	}

	@Test
	public void testNegate() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(-2.0, -3.0);
		assertEquals(c2, c1.negate()); // uses c2.equals(...)
	}

	@Test
	public void testNegateDest() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(-2.0, -3.0);
		c1.negateDest();
		assertEquals(c2, c1); // uses c2.equals(...)
	}

	@Test
	public void testConjugate() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(2.0, -3.0);
		assertEquals(c2, c1.conjugate()); // uses c2.equals(...)
	}

	@Test
	public void testConjugateDest() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(2.0, -3.0);
		c1.conjugateDest();
		assertEquals(c2, c1); // uses c2.equals(...)
	}

	@Test
	public void testAdd() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(1.0, 1.0);
		Complex c = c1.add(c2);
		assertEquals(3.0, c.getReal(), EPSILON);
		assertEquals(4.0, c.getImag(), EPSILON);
		assertEquals(new Complex(2.0, 3.0), c1);
		assertEquals(new Complex(1.0, 1.0), c2);
	}

	@Test
	public void testAddDest() {
		Complex c1 = new Complex(2.0, 3.0);
		Complex c2 = new Complex(1.0, 1.0);
		c1.addDest(c2);
		assertEquals(new Complex(3.0, 4.0), c1);
		assertEquals(3.0, c1.getReal(), EPSILON);
		assertEquals(4.0, c1.getImag(), EPSILON);
		assertEquals(new Complex(1.0, 1.0), c2);
	}

	@Test
	public void testMultiply() {
		Complex c1 = new Complex(14.64, 0.48);
		Complex c2 = new Complex(3.0, 4.0);
		Complex c3 = new Complex(42.0, 60.0);
		assertEquals(c3, c1.multiply(c2)); // uses c3.equals(...)
	}

	@Test
	public void testDivide() {
		Complex c1 = new Complex(42.0, 60.0);
		Complex c2 = new Complex(14.64, 0.48);
		Complex c3 = new Complex(3.0, 4.0);
		assertEquals(c3, c1.divide(c2)); // uses c3.equals(...)
	}

	@Test
	public void testDivideNaN() {
		Complex c1 = new Complex(42.0, 60.0);
		Complex c2 = new Complex(0, 0);
		Complex c3 = new Complex(Double.NaN, Double.NaN);
		assertEquals(c3, c1.divide(c2)); // uses c3.equals(...)
	}
}
