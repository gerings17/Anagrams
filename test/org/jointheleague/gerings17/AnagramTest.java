package org.jointheleague.gerings17;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

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
	public void loadTest(){
		Anagrams a = new Anagrams();
		List<String> listOfWords = null;
		try {
			listOfWords = a.loadAnagrams();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		assertTrue(listOfWords.size()==235886);
	}

}
