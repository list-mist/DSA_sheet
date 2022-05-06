package Trees;

public class ConvertSortedArrayToBST {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        
        return BST(nums,0,nums.length - 1);
    }
    int getMid(int[] nums,int low,int high){
        int mid = (low + high)/2;
        return nums[mid];
    }
    TreeNode BST(int[] nums,int low,int high){
        if(low > high) return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(getMid(nums,low,high));
        
        root.left = BST(nums,low,mid-1);
        root.right = BST(nums,mid+1,high);
        
        return root;
    }
    // Time complexity -> O(N)
    // Space complexity -> O(N/2)
}
