class Solution {
    
    public int maxProfit(int[] prices, int day, int holding, int[][] memo) {
        if (day >= prices.length) {
            return 0;
        }
        if(memo[day][holding]!=-1) {
            return memo[day][holding];
        }
        System.out.println(day + " - " + holding);
        int ans = maxProfit(prices,day+1,holding,memo);
        if (holding==1) {
            ans = Math.max(
                maxProfit(prices,day+2,0,memo)+prices[day],
                ans
            );
        } else {
            ans = Math.max(
                maxProfit(prices,day+1,1,memo)-prices[day],
                ans
            );
        }
        memo[day][holding] = ans;
        return ans;
    }
    
    public int maxProfit(int[] prices) {
        int[][] memo = new int[prices.length][2];
        for(int i=0;i<prices.length;i++) {
            Arrays.fill(memo[i],-1);
        }
        return maxProfit(prices,0,0,memo);
    }
}