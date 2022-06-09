class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        int m = edges.length;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < m; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt){
                    dist[v] = dist[u] + wt;
                }
            }
        }
       // boolean flag = true;
        for(int j = 0; j < m; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + wt){
                    dist[v] = dist[u] + wt;
                    return 1;
                }
        }
        return 0;
    }
   
}
