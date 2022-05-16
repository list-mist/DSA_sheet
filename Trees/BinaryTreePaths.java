class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        
        path(root,ans,"");
        return ans;
    }
    void path(TreeNode root, List<String> ans, String psf){
        if(root == null) return;
        if(root != null && root.left == null && root.right == null){
            psf += root.val;
            ans.add(psf);
            return;
        }
        path(root.left,ans,psf+root.val+"->");
        path(root.right,ans,psf+root.val+"->");
        
    }
}
