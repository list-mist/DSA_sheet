class Solution {
    boolean res = true;
  
    public boolean isBipartite(int[][] graph) {
        
        int n = graph.length;
      
        boolean[] visit = new boolean[n];
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            
            if(visit[i] == false){
                color[i] = 0;
                dfs(graph,i,visit,color);
                if(res == false) return res;
            }
        }
     
        return res;
    }
    void dfs(int[][] graph, int src, boolean[] visit,int[] color){
        visit[src] = true;
        
        for(int t : graph[src]){
            if(visit[t] == false){
                   color[t] = 1 - color[src];
                   dfs(graph, t, visit, color);
                }
              else{
                  if(color[t] == color[src]) res = false;
              }
            }
        }
}
