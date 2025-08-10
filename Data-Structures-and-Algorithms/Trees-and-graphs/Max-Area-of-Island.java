class Solution {
    
    boolean[][] visited;
    int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    
    private boolean isValid(int[][] grid, int r, int c) {
        return r>=0 && r<grid.length && c>=0 && c<grid[0].length && visited[r][c]==false && grid[r][c]==1;
    }
    
    private int dfs(int[][] grid, int r, int c) {
        int ans = 0;
        for(int i=0;i<directions.length;i++) {
            int nextR = r+directions[i][0];
            int nextC = c+directions[i][1];
            if(isValid(grid,nextR,nextC)) {
                visited[nextR][nextC] = true;
                ans += dfs(grid,nextR,nextC);
            }
        }
        return ans+1;
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(isValid(grid,i,j)) {
                    visited[i][j] = true;
                    ans = Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
}