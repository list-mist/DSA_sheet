package Trees;

public class InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    TreeNode invert(TreeNode root){
        if(root == null) return root;
        
        TreeNode leftTree = invert(root.left);
        TreeNode rightTree = invert(root.right);
        
        root.left = rightTree;
        root.right = leftTree;
        
        return root;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(N)
}
