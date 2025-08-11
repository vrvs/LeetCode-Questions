class Solution {
    public int climbStairs(int n) {
        int[] ans = new int[n+1];
        ans[n] = 1;
        ans[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            ans[i] = ans[i+1] + ans[i+2];
        }
        return ans[0];
    }
}