class Solution {
    int re = 0;
    
    int k = 0;
    public int kthSmallest(TreeNode root, int a) {
       
        k = a;
        getKthMinElement(root);
        
        return re;
    }
    void getKthMinElement(TreeNode root){
        if(root == null) return;
        
        getKthMinElement(root.left);
        k--;
        if(k == 0 && re == 0) re = root.val; 
         
        getKthMinElement(root.right);
       
    }
}
