package com.gradescope.hw7;

/**
 * A guinea pig.
 */
public class GuineaPig {
	private int age;
	private String name;

	/**
	 * Initializes a new guinea pig object.
	 * 
	 * @param name - the name
	 * @param age  - the age
	 */
	public GuineaPig(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Initializes a new guinea pig object with default name "arya" and age 1 (Prof
	 * Wu's pet).
	 */
	public GuineaPig() {
		this("arya", 1);
	}

	/**
	 * Returns the name of this guinea pig.
	 */
	public String getName() {
		return this.name;
	}
}
