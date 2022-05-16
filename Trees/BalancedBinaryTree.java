class Solution {
    public boolean isBalanced(TreeNode root) {
        return balanced(root);
    }
    int height(TreeNode root){
        if(root == null) return 0;
        
        int left = height(root.left);
        int right = height(root.right);
        
        return 1 + Math.max(left,right);
    }
    boolean balanced(TreeNode root){
        if(root == null) return true;
        if(Math.abs(height(root.left) - height(root.right)) > 1) return false;
        boolean left = balanced(root.left);
        
        boolean right = balanced(root.right);
        
        return left && right;
    }
}
