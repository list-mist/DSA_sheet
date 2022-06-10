class Solution {
    class Pair{
        int x,  dist;
        Pair(int x,  int dist){
            this.x = x;
            this.dist = dist;
        }
    }
    public int snakesAndLadders(int[][] board) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = board.length;
        int idx = 0;
        for(int i = n - 1; i >= 0; i--){
            if((n-i - 1) % 2 == 0){
                for(int j = 0; j < n; j++){
                    idx++;
                    if(board[i][j] != -1){
                        map.put(idx, board[i][j]);
                    }
              }
            }else{
                for(int j = n - 1; j >= 0; j--){
                    idx++;
                   // System.out.println(board[i][j]+" "+i+" "+j);
                    if(board[i][j] != -1){
                        map.put(idx, board[i][j]);
                    }
              }
            }
        }
       // System.out.println(map);
        
        return bfs(board,1,n,map);
    }
    int bfs(int[][] board, int src, int n,HashMap<Integer,Integer> map){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,0));
        boolean[] visit = new boolean[n*n + 1];
        
        while(!q.isEmpty()){
            Pair rp = q.poll();
            if(visit[rp.x] == true) continue;
            visit[rp.x] = true;
         
            if(rp.x == n*n) return rp.dist;
            int x = rp.x ,  dist = rp.dist;
            for(int i = x + 1; i <= Math.min(x+6, n*n); i++){
                int nx = i;
                if(map.containsKey(nx)){
                    q.add(new Pair(map.get(nx),dist + 1));
                }else{
                    q.add(new Pair(nx,dist+1));
                }
            }
            
        }
        return -1;
    }
}
