

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i = 0; i < dictionary.length; i++){ //inputs each line of the dictionary in each index for the array
			dictionary[i] = in.readLine();
		}

		return dictionary;
	}
	//checks if a certain word is a part of the dictionary
	public static boolean existInDictionary(String word, String[] dictionary) {
		for(int i = 0; i < dictionary.length; i++){
			if (word.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		hashtag = hashtag.toLowerCase(); //lower cases the string
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
				if (existInDictionary(hashtag.substring(0, i), dictionary) == true) {//cheks if the prefix is in the dictionary
					System.out.println(hashtag.substring(0, i)); //prints if it
					breakHashTag(hashtag.substring(i), dictionary); // checks the next prefix without the word
					break;
				}
        }
    }

}
