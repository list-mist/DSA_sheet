class Solution {
    int currPath = 0, cnt = 0;
    public int pathSum(TreeNode root, int targetSum) {
    
        int[] res = new int[1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        path(root,targetSum,0,map,res);
       
        return res[0];
    }
    void path(TreeNode root,int sum,int curr,HashMap<Integer,Integer> map,int[] total){
        
        if(root == null) return;
        curr += root.val;
        
        if(map.containsKey(curr - sum)) total[0] += map.get(curr-sum);
        map.put(curr, map.getOrDefault(curr,0)+1);
        
        path(root.left,sum,curr,map,total);
        path(root.right,sum,curr,map,total);
        
        map.put(curr,map.get(curr)-1);
        
        return;
    }
    
}
