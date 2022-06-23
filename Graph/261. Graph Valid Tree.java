class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }
        boolean[] visit = new boolean[n];

        if(isValidTree(adj, visit,0,-1)) return false;
        for(boolean i : visit) if(i == false) return false;
        return true;
    }
    boolean isValidTree(List<List<Integer>> adj, boolean[] visit, int src, int parent){
        
        if(visit[src]) return true;
        
        visit[src] = true;
        boolean ans = false;
        for(int i : adj.get(src)){
            if(parent == i) continue;
            
            ans = ans || isValidTree(adj,visit, i, src);
        }
        return ans;
    }
}
