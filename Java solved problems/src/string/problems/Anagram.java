package string.problems;

import java.util.HashMap;


public class Anagram {

	public static boolean areAnagrams(String word1, String word2){
		
		HashMap<Character,Integer> charactersPresentInWord1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> charactersPresentInWord2 = new HashMap<Character,Integer>();
		if(word2.length() != word1.length()){
			return false;
		}else{
			for(int i=0;i < word1.length();i++){
				Character currentLetter = word1.charAt(i);
				if(!charactersPresentInWord1.keySet().contains(currentLetter)){
					charactersPresentInWord1.put(currentLetter, 1);
				}else{
					int count = charactersPresentInWord1.get(currentLetter);
					charactersPresentInWord1.put(currentLetter, count+1);
				}
			}
			for(int j = 0;j < word2.length();j++){
				Character currentLetter = word2.charAt(j);
				if(!charactersPresentInWord1.keySet().contains(currentLetter)){
					return false;
				}else{
					if(!charactersPresentInWord2.keySet().contains(currentLetter)){
						charactersPresentInWord2.put(currentLetter, 1);
					}else{
						int count = charactersPresentInWord2.get(currentLetter);
						charactersPresentInWord2.put(currentLetter, count+1);
					}
				}
			}
			for(Character letter : charactersPresentInWord1.keySet()){
				if(charactersPresentInWord1.get(letter) != charactersPresentInWord2.get(letter)){
					return false;
				}
			}
			return true;
		}
	}	
	
	public static String sort(String s, int i, int j) {
		String aux = "";
		if (j - i >= 2) {
			String s1 = sort(s, i, (i+j)/2);
			String s2 = sort(s, (i+j)/2, j);
			int s1_index = 0;
			int s2_index = 0;
			for (int k = 0; k < (j-i); k++) {
				if (s1.charAt(s1_index) < s2.charAt(s2_index)) {
					aux += s1.charAt(s1_index);
					s1_index++;
				} else {
					aux += s2.charAt(s2_index);
					s2_index++;
				}
				if (s1_index > s1.length()-1 || s2_index > s2.length()-1)
					break;		
			}
			while (s1_index < s1.length()) {
				aux += s1.charAt(s1_index);
				s1_index++;
			}
			while (s2_index < s2.length()) {
				aux += s2.charAt(s2_index);
				s2_index++;
			}
		} else if (j - i == 1) {
			aux += s.charAt(i);
		}
		return aux;
	}
	
	
	public static boolean areAnagrams2(String s1, String s2) {
			s1 = sort(s1, 0, s1.length());
			s2 = sort(s2, 0, s1.length());
			return s1.equals(s2);

	}
	
	public static void main(String[] args) {
		String s1 = "ANAGRAM";
		String s2 = "ANAAGRM";
		
		if(areAnagrams(s1, s2)){
			System.out.println("they are anagrams");
		}else{
			System.out.println("they are NOT anagrams");
		}
		
		if(areAnagrams2(s1, s2)){
			System.out.println("they are anagrams");
		}else{
			System.out.println("they are NOT anagrams");
		}
		
	}
}
