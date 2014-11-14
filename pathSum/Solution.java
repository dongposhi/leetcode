

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
 
public class Solution {
    public static boolean hasPathSum(TreeNode root, int sum){
        if (root == null)
            return false;

        if(root.left == null && root.right == null){
            return root.val == sum;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    public static TreeNode buildTree(){
/*
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
*/

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        return root;
    }

    public static void main(String[] args){
        System.out.println(hasPathSum(buildTree(),1));
        
    }

}
