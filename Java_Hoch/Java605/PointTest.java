package com.gradescope.hw5;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	double EPSILON = Point.EPSILON;

	@Test
	public void testPoint2Args() {
		Point p = new Point(42.0, 60.0);
		assertEquals(42.0, p.getX(), EPSILON);
		assertEquals(60.0, p.getY(), EPSILON);
	}

	@Test
	public void testPoint0Args() {
		Point p = new Point();
		assertEquals(0.0, p.getX(), EPSILON);
		assertEquals(0.0, p.getY(), EPSILON);
	}

	@Test
	public void testEquals() {
		Point p1 = new Point(2.0, 3.0);
		Point p2 = new Point(2, 3);
		assertEquals(p1, p2);
	}

	@Test
	public void testMagnitude() {
		Point p = new Point(2.0, 3.0);
		assertEquals(3.605551275463989, p.magnitude(), EPSILON);
	}

	@Test
	public void testScale() {
		Point p1 = new Point(2.0, 3.0);
		double d = 10.0;
		Point p2 = p1.scale(d);
		Point p3 = new Point(20.0, 30.0);
		assertEquals(p3, p2); // uses c3.equals(...)
	}

	@Test
	public void testAdd() {
		Point p1 = new Point(2.0, 3.0);
		Point p2 = new Point(1.0, 1.0);
		Point p = p1.add(p2);
		assertEquals(3.0, p.getX(), EPSILON);
		assertEquals(4.0, p.getY(), EPSILON);
	}

	@Test
	public void testIsSmaller() {
		Point p1 = new Point(2.0, 3.0);
		Point p2 = new Point(20.0, 30.0);
		assertTrue(p1.isSmaller(p2));
		assertFalse(p2.isSmaller(p1));
	}

}
