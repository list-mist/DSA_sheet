package Trees;

import java.util.Stack;

public class DiameteBinaryTree{
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] Max = new int[1];

        diameter(root,Max);
        
        return Max[0];
    }
    int diameter(TreeNode root,int[] Max){
        if(root == null) return 0;
        
        int left_d = diameter(root.left,Max); 
        int right_d = diameter(root.right,Max);
     
        Max[0] = Math.max(Max[0],left_d+right_d);
        return 1 + Math.max(left_d,right_d);
    }

    // Time complexity -> O(N)
    // Space complexity -> O(N)
    TreeNode dfs_iterative(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        
        st.push(root);
        TreeNode temp = root;
        while(!st.isEmpty()){
            TreeNode rp = st.pop();
            if(rp != null){
                 if(rp.left != null){
                st.push(rp.left);
            }
            if(rp.right != null){
               st.push(rp.right);
            }
            temp = rp.left;
            rp.left = rp.right;
            rp.right = temp;
            }
        }
        return root;
    }
     // Time complexity -> O(N)
    // Space complexity -> O(N)
}