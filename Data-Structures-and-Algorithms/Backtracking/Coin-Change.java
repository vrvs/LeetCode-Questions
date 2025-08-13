class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i=0;i<=amount;i++) {
            if(dp[i]==-1) {
                continue;
            }
            for(int j=0;j<coins.length;j++) {
                long current = (long)i+coins[j];
                if(current<=amount) {
                    int index = (int)current;
                    if(dp[index] == -1) {
                        dp[index] = dp[i]+1;
                    } else {
                        dp[index] = Math.min(dp[index],dp[i]+1);
                    }
                    
                }
            }
        }
        return dp[amount];
    }
}