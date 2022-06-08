class Solution {
    
    public int minimumCost(int n, int[][] conn) {
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        Arrays.sort(conn,new custom());
        Arrays.fill(parent,-1);
        int totalCost = 0;
        for(int[] t : conn){
            int x = find(parent,t[0]);
            int y = find(parent,t[1]);
            int wt = t[2];
            if(x != y){
                totalCost += wt;
                union(x,y,rank,parent);
            }
        }
        int cnt = 0;
        for(int i : parent){
            if(i == -1) cnt++;
        }
        if(cnt > 2) return -1;
        return totalCost;
    }
    class custom implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            return a[2] - b[2];
        }
    }
    void union(int ax, int ay, int[] rank,int[] parent){
        if(rank[ax] > rank[ay]){
            parent[ay] = ax;
        }
        else if(rank[ax] < rank[ay]){
            parent[ax] = ay;
        }
        else{
            parent[ax] = ay;
            rank[ay]++;
        }
    }
    int find(int[] parent,int x){
        if(parent[x] == -1) return x;
        return parent[x] = find(parent,parent[x]);
    }
}
