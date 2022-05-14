class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < n; i++){
            if(manager[i] != -1){
                adj.get(manager[i]).add(i);
            }
        }
        return noMin(adj,headID, informTime,n);
    }
    int noMin(List<List<Integer>> adj, int headId, int[] informTime, int n){
        Queue<Pair> q = new LinkedList<>();
        boolean[] visit = new boolean[n];
        q.add(new Pair(headId, 0));
        int ans = 0;
        while(!q.isEmpty()){
            Pair rp = q.poll();
            if(visit[rp.id]) continue;
            visit[rp.id] = true;
            ans = Math.max(ans,rp.dist);
            for(int i : adj.get(rp.id)){
                if(visit[i] == false){
                    q.add(new Pair(i,informTime[rp.id]+rp.dist));
                }
            }
        }
        return ans;
    }
    class Pair{
        int id,dist;
        Pair(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }
  //Time complexity -> O(N)
  //Space complexity -> O(N)
}
