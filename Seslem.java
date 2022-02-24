public class Seslem {
	private static boolean isVowel(char letter) {
		return letter == 'a' || letter == 'e' || letter == 'ı' || letter == 'i' || letter == 'o' ||
				letter == 'ö' || letter == 'u' || letter == 'ü';
	}
	
	private static int countSyllable(String word) {
		int counter = 0;
		
		for (int i = 0; i < word.length(); i++) {
			if (isVowel(word.charAt(i))) {
				counter++;
			}
		}
		return counter;
	}
	
	private static int nextVowel(String word, int index) {
		for (int i = index; i < word.length(); i++) {
			if (isVowel(word.charAt(i))) {
				return i;
			}
		}
		return -1;
	}
	
	private static void spell(String word) {
		String[] syllables = new String[countSyllable(word)];
		int index = 0;
		int counter = 0;
		
		while (countSyllable(word.substring(index)) != 1) {
			if (isVowel(word.charAt(index))) {
				if (!isVowel(word.charAt(index + 1)) && !isVowel(word.charAt(index + 2))) {
					syllables[counter] = word.charAt(index) + "" + word.charAt(index + 1);
				} else {
					syllables[counter] = word.charAt(index) + "";
				}
				index += syllables[counter].length();
			} else {
				int vowel = nextVowel(word, nextVowel(word, index) + 1);
				
				if (!isVowel(word.charAt(vowel - 1))) {
					syllables[counter] = "";
					
					for (int i = index; i < vowel - 1; i++) {
						syllables[counter] += word.charAt(i);
					}
					index += syllables[counter].length();
				}
			}
			counter++;
		}
		syllables[counter] = word.substring(index);
		
		for (int i = 0; i < syllables.length; i++) {
			System.out.print(syllables[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Seslem.spell("anıl"); // a nıl
	}
}