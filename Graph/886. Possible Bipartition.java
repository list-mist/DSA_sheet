class Solution {
    boolean res = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length == 0) return true;

        int[] parent = new int[n+1];
      //  int[] rank = new int[n+1];
        Arrays.fill(parent,-1);
        List<List<Integer>> adj = new ArrayList<>();
         for(int i = 0; i < n + 1; i++) adj.add(new ArrayList<>());
        
         for(int i = 0; i < dislikes.length; i++){
             adj.get(dislikes[i][0]).add(dislikes[i][1]);
             adj.get(dislikes[i][1]).add(dislikes[i][0]);
         }
      
        int[] color = new int[n+1];
        boolean[] visit = new boolean[n+1];
         for(int i = 1; i <= n; i++){
            
            if(visit[i] == false){
                color[i] = 0;
                dfs(adj,i,visit,color);
                if(res == false) return res;
            }
        }
     
        return res;
    }
  void dfs(List<List<Integer>> graph, int src, boolean[] visit,int[] color){
        visit[src] = true;
        
        for(int t : graph.get(src)){
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
