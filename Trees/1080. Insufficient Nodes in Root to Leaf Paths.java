class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
      
        root = removeNode(root,limit,0);
       
        return root;
    }
    TreeNode removeNode(TreeNode root, int limit, int sum){
        if(root == null) return root;
        
        if(root.left == null && root.right == null){
           
            if(sum + root.val >= limit) {
            
                return root;
            }
            return null;
        }
        
        
        root.left = removeNode(root.left,limit,sum + root.val);
        root.right = removeNode(root.right,limit,sum + root.val);
        
        if(root.left == null && root.right == null) return null;
        
        return root;
    }
}
