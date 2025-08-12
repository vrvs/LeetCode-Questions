class Solution {
    
    public void backtracking(int[][] graph, List<List<Integer>> ans, List<Integer> curr, int target) {
        int node = curr.get(curr.size()-1);
        for(int i=0;i<graph[node].length;i++) {
            curr.add(graph[node][i]);
            System.out.println(graph[node][i]);
            if(graph[node][i]==target) {
                ans.add(new ArrayList(curr));
            } else {
                backtracking(graph, ans, curr, target);
            }
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> curr = new ArrayList();
        curr.add(0);
        List<List<Integer>> result = new ArrayList();
        backtracking(graph, result, curr, graph.length-1);
        return result;
    }
}