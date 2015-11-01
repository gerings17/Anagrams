package org.jointheleague.gerings17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;


public class Anagrams {
	
	List<String> words;
	List<String> listOfAnagrams = new ArrayList<>();
	
	
	public static void main(String[]args) throws IOException{
		new Anagrams().run();
	}
	private void run() throws IOException{
		words =  loadAnagramsFromWeb();
		String word = JOptionPane.showInputDialog("Enter in a word.");
		findAnagrams2(word);
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
	public void findAnagrams2(String word){
		String listOfAnagrams = words.stream()
									 .filter(w->isAnagram(word, w))
									 .collect(Collectors.joining(","));
		JOptionPane.showMessageDialog(null, listOfAnagrams);
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
	public List<String> loadAnagramsFromWeb() throws IOException{
		List<String> listOfWords = new ArrayList<>();
		URL url = new URL("https://raw.githubusercontent.com/eneko/data-repository/master/data/words.txt");
		URLConnection connection = url.openConnection();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
			listOfWords = reader.lines().collect(Collectors.toList());
		}
		return listOfWords;
	}
}

