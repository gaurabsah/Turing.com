package javaCoding;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s, return the most frequent character
Input: "abcddefda123111113333333"
Output: 'd'
 */

public class MostRepeatedCharacter {

	static char frequentCharacter(String s) {
		// Create a HashMap to store the frequency of each character
		Map<Character, Integer> frequencyMap = new HashMap<>();

		// Iterate through the string and count the frequency of each character
		for (char c : s.toCharArray()) {
			if (Character.isLetter(c)) {
//				frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
				if (frequencyMap.containsKey(c)) {
					frequencyMap.put(c, frequencyMap.get(c) + 1);
				} else {
					frequencyMap.put(c, 1);
				}
			}
		}
		// Find the character with the highest frequency
		char mostFrequentChar = ' ';
		int maxFrequency = 0;
		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() > maxFrequency) {
				mostFrequentChar = entry.getKey();
				maxFrequency = entry.getValue();
			}
		}
		return mostFrequentChar;
	}

	public static void main(String[] args) {
		String s = "abcddefda123111113333333";
		char frequentCharacter = frequentCharacter(s);
		System.out.println(frequentCharacter); // Expected output: 'd'
	}
}
