class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root,false);
    }
    int sum(TreeNode root, boolean isLeft){
        if(root == null) return 0;
        if(root.left == null && root.right == null) 
        {
            if(isLeft) return root.val;
            return 0;
        }
        int total = 0;
        if(root.left != null){
            total += sum(root.left,true);
        }
        total += sum(root.right,false);
        
        return total;
        
    }
}
