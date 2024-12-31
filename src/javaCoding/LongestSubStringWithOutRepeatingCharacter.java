package javaCoding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithOutRepeatingCharacter {

	static int longestSubStringWithOutRepeatingCharacter(String s) {
		// Map to store the last seen index of each character
		Map<Character, Integer> map = new HashMap<>();
		int maxLength = 0;
		int start = 0;

		// Convert the string into a character array
		char[] ch = s.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			char currentChar = ch[i];

			// If the character is already in the map and within the current window
			if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
				// Move the start pointer to the right of the last occurrence
				start = map.get(currentChar) + 1;
			}

			// Update the character's index in the map
			map.put(currentChar, i);

			// Calculate the current substring length and update the maxLength
			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "cadbzabcd";
		int ans = longestSubStringWithOutRepeatingCharacter(s);
		System.out.println(ans);
	}

}
