
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcs(root,p,q);
    }
    TreeNode lcs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        if(root.val > p.val && root.val < q.val) return root;
        if(root.val < p.val && root.val > q.val) return root;
        
        if(root.val == p.val || root.val == q.val) return root;
        if(root.val > p.val && root.val > q.val){
            TreeNode left = lcs(root.left,p,q);
            return left;
        }
        //TreeNode left = lcs(root.left,p,q);
        TreeNode right = lcs(root.right,p,q);
        return right;
        
    }
}
