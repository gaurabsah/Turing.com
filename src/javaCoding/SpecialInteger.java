package javaCoding;

import java.util.Arrays;

/*
 Given an array k of integers, find the special integer x such that
 there are x integers in k array that are larger than or equal to x.
 The special integer x doesn't have to exist in array k.
 You can aasume that there is always going to be one special integer or none in the k array
 If no integers are found return -1.
 
 Input: nums = [0,4,1,0,4]
 Output: 2
 There are 2 values that are greater than or equal to 2
 */

public class SpecialInteger {

	public static void main(String[] args) {
		int[] nums = { 0, 4, 1, 0, 4 };
		int result = findSpecialInteger(nums);
		System.out.println("The special integer is: " + result);
	}

	public static int findSpecialInteger(int[] nums) {
		Arrays.sort(nums); //0,0,1,4,4
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] >= n - i) {
				return n - i;
			}
		}
		return -1;
	}

}
