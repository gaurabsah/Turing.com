package javaCoding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Implementation to check if array can be formed by concatenating sub array
 */

public class ArrayConcatenation {

	static boolean solution(int[] main, int[][] sub) {
		Map<Integer, Integer> positionMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < main.length; i++) {
			positionMap.put(main[i], i);
		}

		Set<Integer> used = new HashSet<Integer>();

		for (int[] subArray : sub) {
			for (int i = 0; i < subArray.length; i++) {
				int element = subArray[i];
				if (!positionMap.containsKey(element)) {
					return false;
				}

				int pos = positionMap.get(element);
				if (used.contains(pos)) {
					return false;
				}

				used.add(pos);

				if (i > 0) {
					int preElement = subArray[i - 1];
					int prePos = positionMap.get(preElement);
					if (pos != prePos + 1) {
						return false;
					}
				}
			}
		}

		return used.size() == main.length;
	}

	public static void main(String[] args) {
		int[] main = { 15, 88 };
		int[][] sub = { { 88 }, { 15 } };
		boolean solution = solution(main, sub);
		System.out.println(solution);
	}

}
