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
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        graph = new LinkedList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++) {
            graph[i] = new LinkedList();
        }
        for(int i=0;i<edges.length;i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }
        visited[source] = true;
        dfs(source);
        return visited[destination];
    }
}