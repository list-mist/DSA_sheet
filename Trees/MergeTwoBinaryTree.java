package Trees;

public class MergeTwoBinaryTree {
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
    TreeNode merge(TreeNode root1, TreeNode root2){
        if(root1 == null) return root2;
        if(root2 == null) return root1;
        
        TreeNode left = merge(root1.left,root2.left);
        TreeNode right = merge(root1.right,root2.right);
        
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = left;
        root.right = right;
        
        return root;
    }
    // Time complexity -> O(M + N)
    // Space complexity -> O(H)
}
