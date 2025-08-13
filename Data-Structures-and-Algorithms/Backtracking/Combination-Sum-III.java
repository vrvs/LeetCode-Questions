class Solution {
    
    private void combinationSum3(int k, int n, int i, int sum, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size()==k && sum==n) {
            result.add(new ArrayList(curr));
            return;
        }
        if (curr.size()>=k||sum>=n||i>9) {
            return;
        }
        curr.add(i);
        combinationSum3(k,n,i+1,sum+i,curr,result);
        curr.remove(curr.size()-1);
        combinationSum3(k,n,i+1,sum,curr,result);
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        combinationSum3(k,n,1,0,new ArrayList(),result);
        return result;
    }
}