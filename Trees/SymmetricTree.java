package Trees;

public class SymmetricTree {
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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        
        return mirror(root.left, root.right);
    }
    boolean mirror(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2 == null;
        if(root2 == null) return root1 == null;
        
        if(root1.val != root2.val) return false;
        
        boolean left = mirror(root1.left,root2.right);
        
        boolean right = mirror(root1.right,root2.left);
        
        return left && right;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(H)
}
