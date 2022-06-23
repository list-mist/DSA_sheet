class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v); 
            adj.get(v).add(u); 
        }
        boolean[] visit = new boolean[n];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(visit[i] == false){
                dfs(adj,visit,i);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(List<List<Integer>> adj, boolean[] visit, int src){
        if(visit[src]) return;
        
        visit[src] = true;
        for(int i : adj.get(src)){
            dfs(adj,visit,i);
        }
    }
}
