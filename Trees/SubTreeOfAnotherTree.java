package Trees;

public class SubTreeOfAnotherTree {
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subtree(root,subRoot);
    }
    boolean subtree(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot != null) return false;
        
        if(same_tree(root,subRoot)) return true;
        boolean left = subtree(root.left,subRoot);
        boolean right = subtree(root.right,subRoot);
        
        return left || right;
    }
    boolean same_tree(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2 == null;
        if(root2 == null) return root1 == null;
        
        if(root1.val != root2.val) return false;
        boolean left = same_tree(root1.left, root2.left);
        boolean right = same_tree(root1.right, root2.right);
        
        return left && right;
    }
    // Time complexity -> O(N*M)
    // Space complexity -> O(N)
}
