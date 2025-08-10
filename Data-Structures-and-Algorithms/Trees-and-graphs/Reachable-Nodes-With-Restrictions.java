class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    
    private int dfs(int u) {
        int ans = 0;
        for(int v:graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                ans += dfs(v);
            }
        }
        return ans+1;
    }
    
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        graph = new LinkedList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            graph[i] = new LinkedList();
        }
        for(int i=0;i<edges.length;i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        for(int i=0;i<restricted.length;i++) {
            visited[restricted[i]] = true;
        }
        visited[0] = true;
        return dfs(0);
    }
}