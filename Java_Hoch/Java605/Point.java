package com.gradescope.hw5;

/**
 * The Point class represents a 2-dimensional point and includes methods for
 * performing basic operations with points.
 */

public class Point {
	/**
	 * The x coordinate.
	 */
	private double x;

	/**
	 * The y coordinate.
	 */
	private double y;

	/**
	 * The difference at which coordinates are considered equal.
	 */
	public final static double EPSILON = 0.000001;

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Initializes a new point at the origin.
	 */
	public Point() {
		this(0.0, 0.0); // calls generalized constructor
	}

	/**
	 * Initializes a new point.
	 * 
	 * @param x - The x coordinate
	 * @param y - The y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Compares this point to a to another object. The result is true if and only if
	 * this Point represents the same location as the specified object, up to an
	 * error margin (EPSILON).
	 * 
	 * Note to CS 60 students: This is a more complicated form of equals than the
	 * one you will write this week.
	 * 
	 * @param obj - The object to compare this Point against
	 * @return true if the two Points represent the same location
	 */
	public boolean equals(Object obj) {
		if (this.getClass() != obj.getClass()) {
			return false; // different class? false!
		}

		Point p = (Point) obj; // cast obj to Point

		if (Math.abs(this.x - p.x) < EPSILON && Math.abs(this.y - p.y) < EPSILON) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns a string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Point [x=" + this.x + ", y=" + this.y + "]";
	}

	/**
	 * Computes the magnitude of this point.
	 * 
	 * @return The magnitude
	 */
	public double magnitude() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/**
	 * Scales this point.
	 * 
	 * @param factor - The scaling factor
	 * @return A new point object that is scaled from this point
	 */
	public Point scale(double factor) {
		return new Point(factor * this.x, factor * this.y);
	}

	/**
	 * Returns the vector sum of this point and another point.
	 * 
	 * @param p - The other point object
	 * @return A new point object that is the vector sum of this point and the other
	 *         point
	 */
	public Point add(Point p) {
		return new Point(this.x + p.x, this.y + p.y);
	}

	/**
	 * Compares the magnitude of this point against another point.
	 * 
	 * @param p - The other point object
	 * @return true if this point is closer to the origin
	 */
	public boolean isSmaller(Point p) {
		return this.magnitude() < p.magnitude();
	}

	/**
	 * Start of execution. Good place for small tests and print statements.
	 */
	public static void main(String[] args) {
		Point p1 = new Point(30, 40);
		Point p2 = new Point(12, 2);
		Point p3 = p1.add(p2);

		System.out.println("p1 is " + p1);
		System.out.println("p2 is " + p2);
		System.out.println("p3 (sum) is " + p3);

		Point p4 = p1.scale(0.5);
		System.out.println("p4 is " + p4);

		if (p2.isSmaller(p1)) {
			System.out.println("p2 IS smaller than p1.");
		} else {
			System.out.println("p2 is NOT smaller than p1!");
		}
	}

}
