class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthTree(root);
    }
    int maxDepthTree(TreeNode root){
        if(root == null) return 0;
        
        int left = maxDepthTree(root.left);
        
        int right = maxDepthTree(root.right);
        
        return 1 + Math.max(left,right);
    }
}
