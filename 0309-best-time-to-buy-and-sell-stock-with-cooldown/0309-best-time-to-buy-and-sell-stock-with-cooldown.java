class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        return helper(prices,0,1,0,dp);
    }
     int helper(int[] prices, int n, int buy, int profit,int[][] dp){
        if(n>=prices.length){
            return 0;
        }
        if(dp[n][buy]!=-1){
            return dp[n][buy];
        }

        if(buy==1){
            profit = Math.max(-prices[n]+helper(prices,n+1,0,profit,dp),0+helper(prices,n+1,1,profit,dp));
        }else{
            profit= Math.max(prices[n]+helper(prices,n+2,1,profit,dp),0+helper(prices,n+1,0,profit,dp));
        }
        return dp[n][buy]=profit;
    }
}