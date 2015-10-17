package org.jointheleague.gerings17;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void test() {
		assertTrue(Anagrams.isAnagram("abcde", "edcba"));
		assertTrue(Anagrams.isAnagram("AbNcL", "aBnCl"));
		assertFalse(Anagrams.isAnagram("hajkhfjk", "ajfkhafeajk"));
		assertFalse(Anagrams.isAnagram("afkhakjf", null));
		assertTrue(Anagrams.isAnagram("tacos", "acost"));
		assertTrue(Anagrams.isAnagram("", ""));
		assertFalse(Anagrams.isAnagram(null, null));
		assertFalse(Anagrams.isAnagram(null, ""));
	}

}
