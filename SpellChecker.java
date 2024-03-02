
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}
	//returns a string without it's first letter
	public static String tail(String str) {
		if (str.length() == 1) { //if the string has 1 letter, returns an empty string
			return "";
		}else{
			return str.substring(1);
		}
	}

	public static int levenshtein(String word1, String word2) {
		if (word1.length() == 0) return word2.length(); //base case 1
		if (word2.length() == 0) return word1.length(); //base case 2			
		if (word1.charAt(0) == word2.charAt(0)) return levenshtein(tail(word1), tail(word2)); //if they have the same head, continue with their tails
		//else, return the one change (not the same head) + the minimum number of changes in all tail variations
		return 1 + Math.min(levenshtein(tail(word1), word2), Math.min(levenshtein(word1, tail(word2)),levenshtein(tail(word1),tail(word2))));
			
		
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i = 0; i < dictionary.length; i++){ //inputs each line of the dictionary in each index for the array
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String value = word;
		for(int i = 0; i < dictionary.length; i++){
			if (levenshtein(word, dictionary[i]) <= threshold) {
				value = dictionary[i];
			}
		}
		return value;
	}

}
