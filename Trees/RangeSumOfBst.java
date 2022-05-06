package Trees;

public class RangeSumOfBst {
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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        rangeSum(root,low,high);
        return sum;
    }
    int rangeSum(TreeNode root, int low, int high){
        if(root == null) return 0;
        
        int left = rangeSum(root.left,low,high);
        int right = rangeSum(root.right,low,high);
        
        if(root.val >= low && root.val <= high){
            sum += root.val;
            return root.val;
        }
        
        return   left + right;
        
    }
    // Time complexity -> O(N)
    // Space complexity -> O(H)
}
