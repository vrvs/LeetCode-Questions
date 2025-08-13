class Solution {
    
    private boolean valid(int digit) {
        return (digit>=0&&digit<10);
    }
    
    private void numsSameConsecDiff(int n, int k, int digit, int curr, int length, Set<Integer> result) {
        if (length == n) {
            result.add(curr);
            return;
        }
        curr *= 10;
        
        if(valid(digit+k)) {
            numsSameConsecDiff(n,k,digit+k,curr+digit+k,length+1,result);
        } 
        if(valid(digit-k)) {
            numsSameConsecDiff(n,k,digit-k,curr+digit-k,length+1,result);
        }
    }
    
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet();
        for(int i=1;i<10;i++) {
            numsSameConsecDiff(n,k,i,i,1,result);
        }
        int[] ans = new int[result.size()];
        int i = 0;
        for(int value: result) {
            ans[i++] = value;
        }
        return ans;
    }
}