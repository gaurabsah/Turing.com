package javaCoding;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int max_area = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
			int width = right - left;
			int heightContainer = Math.min(height[left], height[right]);
			int containerWater = width * heightContainer;
			max_area = Math.max(max_area, containerWater);

			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}

		}

		return max_area;
	}

	public static void main(String[] args) {
		ContainerWithMostWater solution = new ContainerWithMostWater();
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println("Maximum Area: " + solution.maxArea(height)); // Output: 49
	}

}
