    public int minimumSemesters(int n, int[][] preq) {
        return minCourse(preq,n);
    }
    int minCourse(int[][] preq, int n){
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        int[] order = new int[n+1];
        for(int[] t : preq){
            int u = t[0];
            int v = t[1];
            adj.get(u).add(v);
            
            order[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(order[i] == 0) q.add(i);
        }
        int level = 0;
        boolean[] visit = new boolean[n+1];
        while(!q.isEmpty()){
            int size = q.size();
            //idx += size;
            while(size -- > 0){
                int rp = q.poll();
                if(visit[rp]) continue;
                visit[rp] = true;
                for(int i : adj.get(rp)){
                    order[i]--;
                    if(order[i] == 0){
                        q.add(i);
                    }
                }
                
            }
            level++;
        }
        visit[0] = true;
        for(boolean i : visit) if(i == false) return -1;
        return level == 0 ? -1 : level;
    }
}
