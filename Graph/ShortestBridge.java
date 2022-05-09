package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean flag = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) {
                    dfs(grid,i,j,q);
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
        while(!q.isEmpty()){
            int[] rp = q.poll();
            
            for(int[] dir : dirs){
                
                int x = dir[0] + rp[0];
                int y = dir[1] + rp[1];
                int dist = rp[2];
                if(!is_valid(grid,x,y) || grid[x][y] == -1) continue;
                
                if(grid[x][y] == 1) return rp[2] + 1;
                q.add(new int[]{x,y,dist+1});
                      
                grid[x][y] = -1;
            }
        }
        return -1;
    }
    void dfs(int[][] grid, int i, int j, Queue<int[]> q){
        if(!is_valid(grid,i,j) || grid[i][j] == -1) return;
        
        if(grid[i][j] == 0){
            q.add(new int[]{i,j,0});
            return;
        }
        grid[i][j] = -1;
        
        dfs(grid,i-1,j,q);
        dfs(grid,i+1,j,q);
        dfs(grid,i,j-1,q);
        dfs(grid,i,j+1,q);
        
    }
    boolean is_valid(int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0){
            return false;
        }
        return true;
    }

    // Time complexity -> O(N*N)
    // Space complexity -> O(N*N)

}
