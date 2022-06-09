class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conn) {
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int parent = -1;
        
        int[] dis = new int[n];
        int[] low = new int[n];
        boolean[] visit = new boolean[n];
        
        Arrays.fill(dis, -1);
        Arrays.fill(low, -1);
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < conn.size(); i++){
            adj.get(conn.get(i).get(1)).add(conn.get(i).get(0));
            adj.get(conn.get(i).get(0)).add(conn.get(i).get(1));
        }
        int timer = 0;
        
        for(int i = 0; i < n; i++){
            if(visit[i] == false){
                dfs(adj,res,i,parent,dis,low,visit,timer);
            }
        }
        return res;
    }
    void dfs(List<List<Integer>> adj,List<List<Integer>> res, int node,int parent,int[] dis,int[] low, boolean[] visit,int timer){
        visit[node] = true;
        
        dis[node] = low[node] = timer;
        for(int ngbr : adj.get(node)){
            if(ngbr == parent) continue;
            
            if(!visit[ngbr]){
                dfs(adj,res,ngbr,node,dis,low,visit,timer + 1);
                low[node] = Math.min(low[node],low[ngbr]);
                
                if(dis[node] < low[ngbr]){
                    res.add(new ArrayList<>(Arrays.asList(node,ngbr)));
                }
            }
            else{
                low[node] = Math.min(low[node],dis[ngbr]);
            }
        }
    }
}
