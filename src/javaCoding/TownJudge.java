package javaCoding;

/*
 Input: N=2, trust = [[1,2]]
 Output: 2 
 */

public class TownJudge {

	public static int findJudge(int n, int[][] trust) {
		// Array to count trust scores
		int[] trustScores = new int[n + 1];

		// Calculate trust scores
		for (int[] relation : trust) {
			trustScores[relation[0]]--; // Person trusts someone, decrease their score
			trustScores[relation[1]]++; // Person is trusted by someone, increase their score
		}

		// Identify the judge
		for (int i = 1; i <= n; i++) {
			if (trustScores[i] == n - 1) {
				return i; // This person is trusted by everyone else and trusts nobody
			}
		}

		return -1; // No judge found
	}

	public static void main(String[] args) {
		int n = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		int judge = findJudge(n, trust);
		System.out.println("The town judge is: " + judge);
	}
}
