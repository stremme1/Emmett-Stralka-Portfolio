package com.gradescope.hw4;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Hw4Pr4StringsTest {

	@Test
	public void testNotString() {
		assertEquals("not candy", Hw4Pr4Strings.notString("candy"));
		assertEquals("not x", Hw4Pr4Strings.notString("x"));
		assertEquals("not bad", Hw4Pr4Strings.notString("not bad"));
		assertEquals("not bad", Hw4Pr4Strings.notString("bad"));
		assertEquals("not", Hw4Pr4Strings.notString("not"));
		assertEquals("not is not", Hw4Pr4Strings.notString("is not"));
		assertEquals("not no", Hw4Pr4Strings.notString("no"));
	}

	@Test
	public void testMissingChar() {
		assertEquals("ktten", Hw4Pr4Strings.missingChar("kitten", 1));
		assertEquals("itten", Hw4Pr4Strings.missingChar("kitten", 0));
		assertEquals("kittn", Hw4Pr4Strings.missingChar("kitten", 4));
		assertEquals("i", Hw4Pr4Strings.missingChar("Hi", 0));
		assertEquals("H", Hw4Pr4Strings.missingChar("Hi", 1));
		assertEquals("ode", Hw4Pr4Strings.missingChar("code", 0));
		assertEquals("cde", Hw4Pr4Strings.missingChar("code", 1));
		assertEquals("coe", Hw4Pr4Strings.missingChar("code", 2));
		assertEquals("cod", Hw4Pr4Strings.missingChar("code", 3));
		assertEquals("chocolat", Hw4Pr4Strings.missingChar("chocolate", 8));
	}

	@Test
	public void testfrontBack0() {
		assertEquals("eodc", Hw4Pr4Strings.frontBack("code"));
		assertEquals("a", Hw4Pr4Strings.frontBack("a"));
		assertEquals("ba", Hw4Pr4Strings.frontBack("ab"));
		assertEquals("cba", Hw4Pr4Strings.frontBack("abc"));
		assertEquals("", Hw4Pr4Strings.frontBack(""));
		assertEquals("ehocolatC", Hw4Pr4Strings.frontBack("Chocolate"));
		assertEquals("Java", Hw4Pr4Strings.frontBack("aavJ"));
		assertEquals("oellh", Hw4Pr4Strings.frontBack("hello"));
	}

	@Test
	public void testfront3() {
		assertEquals("JavJavJav", Hw4Pr4Strings.front3("Java"));
		assertEquals("ChoChoCho", Hw4Pr4Strings.front3("Chocolate"));
		assertEquals("abcabcabc", Hw4Pr4Strings.front3("abc"));
		assertEquals("abcabcabc", Hw4Pr4Strings.front3("abcXYZ"));
		assertEquals("ababab", Hw4Pr4Strings.front3("ab"));
		assertEquals("aaa", Hw4Pr4Strings.front3("a"));
		assertEquals("", Hw4Pr4Strings.front3(""));
	}

	@Test
	public void testBackAround() {
		assertEquals("tcatt", Hw4Pr4Strings.backAround("cat"));
		assertEquals("oHelloo", Hw4Pr4Strings.backAround("Hello"));
		assertEquals("aaa", Hw4Pr4Strings.backAround("a"));
		assertEquals("cabcc", Hw4Pr4Strings.backAround("abc"));
		assertEquals("dreadd", Hw4Pr4Strings.backAround("read"));
		assertEquals("obooo", Hw4Pr4Strings.backAround("boo"));
	}

	@Test
	public void testfront22() {
		assertEquals("kikittenki", Hw4Pr4Strings.front22("kitten"));
		assertEquals("HaHaHa", Hw4Pr4Strings.front22("Ha"));
		assertEquals("ababcab", Hw4Pr4Strings.front22("abc"));
		assertEquals("ababab", Hw4Pr4Strings.front22("ab"));
		assertEquals("aaa", Hw4Pr4Strings.front22("a"));
		assertEquals("", Hw4Pr4Strings.front22(""));
		assertEquals("LoLogicLo", Hw4Pr4Strings.front22("Logic"));
	}

	@Test
	public void teststartHi() {
		assertTrue(Hw4Pr4Strings.startHi("hi there"));
		assertTrue(Hw4Pr4Strings.startHi("hi"));
		assertTrue(Hw4Pr4Strings.startHi("hi ho"));
		assertFalse(Hw4Pr4Strings.startHi("hello hi"));
		assertFalse(Hw4Pr4Strings.startHi("he"));
		assertFalse(Hw4Pr4Strings.startHi("h"));
		assertFalse(Hw4Pr4Strings.startHi(""));
		assertFalse(Hw4Pr4Strings.startHi("ho hi"));
	}

	@Test
	public void teststartOz() {
		assertEquals("oz", Hw4Pr4Strings.startOz("ozymandias"));
		assertEquals("z", Hw4Pr4Strings.startOz("bzoo"));
		assertEquals("o", Hw4Pr4Strings.startOz("oxx"));
		assertEquals("oz", Hw4Pr4Strings.startOz("oz"));
		assertEquals("o", Hw4Pr4Strings.startOz("ounce"));
		assertEquals("o", Hw4Pr4Strings.startOz("o"));
		assertEquals("", Hw4Pr4Strings.startOz("abc"));
		assertEquals("", Hw4Pr4Strings.startOz(""));
		assertEquals("", Hw4Pr4Strings.startOz("zoo"));
		assertEquals("z", Hw4Pr4Strings.startOz("aztec"));
		assertEquals("z", Hw4Pr4Strings.startOz("zzzz"));
		assertEquals("oz", Hw4Pr4Strings.startOz("oznic"));
	}
}
