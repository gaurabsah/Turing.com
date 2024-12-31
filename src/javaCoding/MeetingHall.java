package javaCoding;

import java.util.HashMap;

/*
There are some people in a meeting hall, 
everyone is wearing a t-shirt in which a number is written on his t-shirt. 
We asked some of these people how many people other than 
themselves are wearing a t-shirt with the same number. 
In array asked, asked[i] means from ith 
person has been asked and that person gave answer for that. 
Given the array, return the minimum number of people in meeting hall.
 */

public class MeetingHall {
	public int minimumPeople(int[] asked) {
		HashMap<Integer, Integer> countMap = new HashMap<>();
		int totalPeople = 0;

		for (int answer : asked) {
			// Group people with the same answer
			countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
		}

		for (int key : countMap.keySet()) {
			int groupSize = key + 1; // Total people in this group (including the one giving the answer)
			int count = countMap.get(key); // Number of people who gave this answer

			// Calculate the minimum number of groups needed for this answer
			int groups = (int) Math.ceil((double) count / groupSize);

			// Add the total number of people in these groups
			totalPeople += groups * groupSize;
		}

		return totalPeople;
	}

	public static void main(String[] args) {
		MeetingHall solution = new MeetingHall();

		// Example Test Case
		int[] asked = { 1, 1, 2 };
		System.out.println("Minimum number of people: " + solution.minimumPeople(asked)); // Output: 6
	}
}
