package org.jointheleague.gerings17;

import java.util.Arrays;

public class Anagrams {
	

	static boolean isAnagram(String a, String b){
		char[] aChars, bChars;
		boolean testAnswer;
		if(a==null || b==null || a.length()!=b.length() ){
			testAnswer = false;
		}
		else{
			a = a.toLowerCase();
			b = b.toLowerCase();
			aChars = charactersSorted(a);
			bChars = charactersSorted(b);
			testAnswer = Arrays.equals(aChars, bChars);
		}
		return testAnswer;
	}
	
	static char[] charactersSorted(String str){
		char[] abChars = new char[str.length()];
		abChars = str.toCharArray();
		Arrays.sort(abChars);
		return abChars;
	}
}

