class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPath(root,targetSum);
    }
    boolean hasPath(TreeNode root, int target){
        if(isLeaf(root)) return target == root.val;
        if(root == null) return false;
        boolean left = hasPath(root.left,target - root.val);
        boolean right = hasPath(root.right,target - root.val);
        return left || right;
    }
    boolean isLeaf(TreeNode root){
        if(root != null && root.left == null && root.right == null) return true;
        return false;
    }
  //Time complexity -> O(N)
  // Space complexity -> O(N)
}
