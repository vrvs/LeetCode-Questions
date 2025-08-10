class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    
    private void dfs(int u) {
        for(int v:graph[u]) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v);
            }
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        graph = new LinkedList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            graph[i] = new LinkedList();
        }
        for(int i=0;i<edges.length;i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i);
                ans++;
            }
        }
        return ans;
    }
}