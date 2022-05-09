package Graph;

import java.util.ArrayList;
import java.util.List;

public class NoOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections){
        if(connections.length < n - 1) return -1;
        List<List<Integer>> connection = new ArrayList<>();
        int rows = connections.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            connection.add(new ArrayList<>());
        }
        for(int i = 0; i < rows; i++){
            make_connection(connection,connections[i][0],connections[i][1]);
        }
        boolean[] visit = new boolean[n+1];
        for(int i = 0; i < n; i++){
                if(visit[i] == false){
                   count++;
                   dfs(connection,i,visit);
                }
        }
    
       return count - 1;
    }
    void make_connection(List<List<Integer>> adj,int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    void dfs(List<List<Integer>> adj, int src, boolean[] visit){
        visit[src] = true;
        for(int i : adj.get(src)){
            if(!visit[i]){
                dfs(adj,i,visit);
            }
        }
    }
}
