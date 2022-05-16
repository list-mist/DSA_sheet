class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return sameTree(p,q);
    }
    boolean sameTree(TreeNode p,TreeNode q){
        if((p == null && q != null) || (p != null && q == null)) return false;
        if(p == null) return q == null;
        if(p.val != q.val) return false;
        
        boolean left = sameTree(p.left,q.left);
        boolean right = sameTree(p.right,q.right);
        
        return left && right;
    }
}
