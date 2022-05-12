class Solution
{
    //Function to find out minimum steps Knight needs to reach target position

    public int minStepToReachTarget(int pos[], int target[], int n)
    {

        return bfs(pos,target,n);
       // TIme complexity -> O(N*N)
       // Space complexity -> O(N*N)
    }

    int bfs(int[] pos,int[] target,int n){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visit = new boolean[n+1][n+1];
        q.add(new Pair(pos[0],pos[1],0));
        int ans = 0;
        int[][] dirs = {{-1,-2},{-1,2},{1,-2},{1,2},{-2,-1},{-2,1},{2,-1},{2,1}};
        while(!q.isEmpty()){
            Pair rp = q.poll();
            if(visit[rp.i][rp.j]) continue;
            visit[rp.i][rp.j] = true;
            if(rp.i == target[0] && rp.j == target[1]) return rp.dist;
            
            for(int[] dir : dirs){
                
                int x = dir[0] + rp.i;
                int y = dir[1] + rp.j;
                
                if(!valid(n,x,y)) continue;
                
                if(visit[x][y] == false){
                    int dis = rp.dist + 1;
                    q.add(new Pair(x,y,dis));
                    
                }
                
            }
        }
        return ans;
    }
    class Pair{
        int i,j, dist;
        Pair(int i,int j,int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    boolean valid(int n,int i,int j){
        if(i < 0 || j < 0 || i > n || j > n) return false;
        return true;
    }
}
