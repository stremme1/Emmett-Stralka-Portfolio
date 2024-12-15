package com.gradescope.hw7;

/**
 * An instrument.
 */
public class Instrument {
	private String key;

	/**
	 * Initializes a new instrument object.
	 * 
	 * @param type - the key of the instrument
	 */
	public Instrument(String key) {
		this.key = key;
	}

	/**
	 * Returns the key of this instrument.
	 */
	public String getKey() {
		return this.key;
	}
}
