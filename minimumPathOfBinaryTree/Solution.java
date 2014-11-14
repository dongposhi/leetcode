

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {
        return minDepth2(root,0);
    }

    public int minDepth2(TreeNode root, int depth){
    	if(root == null){
    		return depth;
    	}
   		depth++;
    	if(root.left!=null && root.right != null){
    		return Math.min( minDepth2(root.left, depth), minDepth2(root.right,depth));
    	}
    	else if (root.left == null){
    		return Math.min(Integer.MAX_VALUE,minDepth2(root.right,depth));
    	}
    	else if (root.right == null){
    		return Math.min(Integer.MAX_VALUE,minDepth2(root.left,depth));
    	}

    	return depth;
    }


    public TreeNode buildTree(){
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(1);
    	root.left.left = new TreeNode(2);

    	return root;
    }


    public static void main(String[] args){
    	Solution s = new Solution();
    	System.out.println(s.minDepth(s.buildTree()));
    }
}
