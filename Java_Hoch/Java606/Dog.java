package com.gradescope.hw6;

/**
 * An adorable dog!
 */
public class Dog implements Comparable<Dog> {
	/**
	 * The age
	 */
	int myAge;

	/**
	 * Constructs a dog with the specified age.
	 * 
	 * @param age The age
	 */
	public Dog(int age) {
		this.myAge = age;
	}

	/**
	 * Compares two dogs' ages.
	 * 
	 * The result is a negative integer if this dog is younger than the other dog.
	 * The result is a positive integer if this dog is older than the other dog. The
	 * result is zero if the two dogs are the same age.
	 * 
	 * @return the difference between this dog's age and the other dog's age
	 */
	public int compareTo(Dog other) {
		return this.myAge - other.myAge;
	}

	/**
	 * Compares this string to the specified object. The result is true if and only
	 * if the specified object is also a dog, and both dogs have the same age.
	 * 
	 * @param obj the object to be compared for equality with this dog
	 * @return true if the specified object is equal to this dog
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Dog) {
			Dog otherDog = (Dog) obj;
			return this.compareTo(otherDog) == 0;
		}
		return false;
	}

}
