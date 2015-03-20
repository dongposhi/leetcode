import java.util.*;

public class Solution.java {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();

		if (root == null) {
			return ret;
		}

		if (root.left == null && root.right == null) {
			if (root.val == sum) {
				List<Integer> x = new ArrayList<Integer>();
				x.add(sum);
				ret.add(x);
			}
		} else {
			List<List<Integer>> x = pathSum(root.left, sum - root.val);
			x.addAll(pathSum(root.right, sum - root.val));
			for (List<Integer> tmp : x) {
				tmp.add(0,root.val);
			}
			return x;

		}
		return ret;
	}

	public static void print(List<List<Integer>> x) {
		for (List<Integer> y : x) {
			for (Integer z : y) {
				System.out.print(z + ",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		TreeNode x1 = new TreeNode(1);
		TreeNode x2 = new TreeNode(2);
		x1.left = x2;

		print(pathSum(x1, 3));
	}
}

