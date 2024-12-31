package javaCoding;

/*
 Given a binary tree, find its max depth.
 The maximum depth is the number of nodes along the longest path from the root node
 down to the farthest leaf node
 Note: Leaf node has no children
 Input: [3,9,20,null,null,15,7]
 Output: 3
 */

//Definition for a binary tree node
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		// Base case: if the node is null, return 0
		if (root == null) {
			return 0;
		}

		// Recursively calculate the depth of left and right subtrees
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		// The depth of the current node is the max of left and right subtree depths + 1
		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {
		// Create the binary tree: [3, 9, 20, null, null, 15, 7]
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		// Find the maximum depth
		MaxDepth solution = new MaxDepth();
		System.out.println("Maximum Depth of Binary Tree: " + solution.maxDepth(root)); // Output: 3
	}
}
