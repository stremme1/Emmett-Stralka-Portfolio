package com.gradescope.hw5;

import java.util.Arrays;

/**
 * The Cookie class represents a cookie that is made of various ingredients. The
 * class tracks the number of cookies created to allow for very coarse calorie
 * counting.
 * 
 * We make a lot of arbitrary decisions, for the sake of creating the class,
 * including: how many cookies are in a handful, how to compute calories, and
 * the ingredients for some cookies.
 * 
 * @author CS60 cookie monster
 */

public class Cookie {

	/********************************
	 * Class variables aka static variables
	 ********************************/

	/**
	 * The total number of cookies.
	 */
	private static int cookieCount = 0;

	/**
	 * The number of cookies in a handful.
	 */
	private final static int HANDFUL_OF_COOKIES = 6;

	/********************************
	 * Instance variables
	 ********************************/

	/**
	 * The type of cookie.
	 */
	private String type;

	/**
	 * The ingredients in this cookie.
	 */
	private String[] ingredients;

	/********************************
	 * Constructors
	 ********************************/

	/**
	 * Initializes a new cookie. If not type is specified, the default cookie
	 * type is a sugar cookie.
	 */
	public Cookie() {
		this("sugar");
	}

	/**
	 * Initializes a new cookie of the specified type.
	 * 
	 * Some cookie types have built-in recipes: sugar, chocolate chip, and gluten-
	 * free. Any other type of cookie is a sugar cookie, with an additional 
	 * ingredient that comes from the type of the cookie.
	 * 
	 * @param cookieType - The type of the cookie
	 */
	public Cookie(String cookieType) {
		Cookie.cookieCount++;
		this.type = cookieType;
		if (cookieType.equals("sugar")) {
			this.ingredients = new String[4];
			this.ingredients[0] = "butter";
			this.ingredients[1] = "sugar";
			this.ingredients[2] = "eggs";
			this.ingredients[3] = "flour";
		} else if (cookieType.equals("chocolate chip")) {
			this.ingredients = new String[5];
			this.ingredients[0] = "chocolate chips";
			this.ingredients[1] = "butter";
			this.ingredients[2] = "sugar";
			this.ingredients[3] = "eggs";
			this.ingredients[4] = "flour";
		} else if (cookieType.equals("gluten free")) {
			this.ingredients = new String[4];
			this.ingredients[0] = "eggs";
			this.ingredients[1] = "sugar";
			this.ingredients[2] = "peanut butter";
			this.ingredients[3] = "chocolate chips";
		} else {
			this.ingredients = new String[5];
			this.ingredients[0] = cookieType.concat("s");
			this.ingredients[1] = "butter";
			this.ingredients[2] = "sugar";
			this.ingredients[3] = "eggs";
			this.ingredients[4] = "flour";
		}
	}

	/********************************
	 * Non-static Methods
	 ********************************/

	public String getType() {
		return this.type;
	}

	/**
	 * Counts the number of calories in a batch of cookies.
	 * 
	 * Arbitrarily, we assume that each ingredient has 100 calories.
	 * 
	 * @return The number of calories
	 */
	public int getCalories() {
		return this.ingredients.length * 100;
	}

	/**
	 * Returns a string representation of the list of ingredients.
	 * 
	 * @return A string representation of the list of ingredients
	 */
	public String listIngredients() {
	    return Arrays.toString(this.ingredients);
	}

	/**
	 * Adds another ingredient to this cookie.
	 * 
	 * @param newIngredient - The ingredient
	 */
	public void addIngredient(String newIngredient) {
		int numIngredients = this.ingredients.length;
		String[] updatedIngredients = new String[numIngredients + 1];
		for (int index = 0; index < numIngredients; index++) {
			updatedIngredients[index] = this.ingredients[index];
		}
		updatedIngredients[numIngredients] = newIngredient;
		this.ingredients = updatedIngredients;
	}

	/********************************
	 * Static Methods
	 ********************************/

	/**
	 * Gets the number of cookies.
	 * 
	 * @return The number of cookies
	 */
	public static int getCookieCount() {
		return Cookie.cookieCount;
	}

	/**
	 * Resets the number of cookies to 0.
	 */
	public static void resetCookieCount() {
		Cookie.cookieCount = 0;
	}

	/**
	 * Returns the right number of cookies to eat.
	 * 
	 * @return The number of cookies in a handful (6)
	 */
	public static int rightNumberOfCookies() {
		return Cookie.HANDFUL_OF_COOKIES;
	}

	/**
	 * Returns whether a cookie is delicious based on its type.
	 * 
	 * @param cookieType - The type of cookie
	 * @return true if cookie type starts with "chocolate"
	 */
	public static boolean isDeliciousCookieType(String cookieType) {
		return cookieType.startsWith("chocolate");
	}
}
