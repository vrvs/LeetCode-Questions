class Solution {
    
    private class State {
        int r, c, distance;
        State(int r, int c, int distance)  {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }
    
    public boolean isValid(char[][] maze, boolean[][] visited, int r, int c) {
        return r>=0 && r<maze.length && c>=0 && c<maze[0].length && visited[r][c] == false && maze[r][c]=='.';
    }
    
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] distances = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Queue<State> queue = new LinkedList();
        visited[entrance[0]][entrance[1]] = true;
        queue.offer(new State(entrance[0],entrance[1],0));
        while(!queue.isEmpty()) {
            State current = queue.poll();
            int r = current.r;
            int c = current.c;
            int distance = current.distance;
            if ((r!=entrance[0]||c!=entrance[1])&&(r==0||r==m-1||c==0||c==n-1)) {
                return distance;
            }
            for(int i=0;i<distances.length;i++) {
                int nextR = r + distances[i][0];
                int nextC = c + distances[i][1];
                if(isValid(maze,visited,nextR,nextC)) {
                    visited[nextR][nextC] = true;
                    queue.offer(new State(nextR, nextC, distance+1));
                }
            }
        }
        return -1;
    }
}