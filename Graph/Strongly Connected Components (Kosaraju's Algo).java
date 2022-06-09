class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
       Stack<Integer> st = new Stack<>();
       boolean[] visit = new boolean[v];
       for(int i = 0; i < v; i++){
           if(visit[i] == false){
               topoSort(adj,i,visit,st);
           }
       }
  
       ArrayList<ArrayList<Integer>> modifyAdj = new ArrayList<>();
       for(int i = 0; i < v; i++) modifyAdj.add(new ArrayList<>());
       // transpose the graph
       for(int i = 0; i < v; i++){
           ArrayList<Integer> rp = adj.get(i);
           
           for(int t : rp){
               modifyAdj.get(t).add(i);
           }
       }
   
       int cnt = 0;
       boolean[] vis = new boolean[v];
   
       while(!st.isEmpty()){
          int rp = st.pop();
           if(vis[rp] == false){
              dfs(modifyAdj,rp,vis);
               cnt++;
           }
       }
       return cnt;
    }
    void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visit){
        visit[src] = true;
        
        for(Integer rp : adj.get(src)){
            if(visit[rp] == false){
                dfs(adj,rp,visit);
            }
        }
    }
    void topoSort(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visit,Stack<Integer> st){
        visit[src] = true;
        
        for(Integer rp : adj.get(src)){
            if(visit[rp] == false){
                topoSort(adj,rp,visit,st);
            }
        }
        st.push(src);
    }
}
