package org.jointheleague.gerings17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;


public class Anagrams {
	
	List<String> words;
	List<String> listOfAnagrams = new ArrayList<>();
	
	
	public static void main(String[]args) throws IOException{
		new Anagrams().run();
	}
	private void run() throws IOException{
		words =  loadAnagrams();
		String word = JOptionPane.showInputDialog("Enter in a word.");
		findAnagrams(word);
	}
	public void findAnagrams(String word) throws IOException{
		for(int i = 0; i<words.size(); i++){
			if(isAnagram(word, words.get(i)) == true){
				listOfAnagrams.add(words.get(i));
			}
		}
		String message;
		
		StringBuilder sb = new StringBuilder();
		boolean first =  true;
		for(String w: listOfAnagrams){
			if(!first){
				sb.append(", ");
			}
			else{
				first = false;
			}
			sb.append(w);
		}
		JOptionPane.showMessageDialog(null,sb.toString());
	}

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
	
	public List<String> loadAnagrams() throws IOException{
		List<String> listOfWords = new ArrayList<>();
		InputStream is = getClass().getResourceAsStream("res/words.txt");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(is))){
			String line = null;
			while((line = reader.readLine()) != null){
				listOfWords.add(line);
			}
		}
		return listOfWords;
	
	}
}

