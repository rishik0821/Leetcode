class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] x:dp){
            for(int[]y : x){
            Arrays.fill(y,-1);}
        }
        return helper(prices,0,1,2,0,dp);
    }
    int helper(int[] prices, int n, int buy,int cap, int profit,int[][][] dp){
        if(n==prices.length|| cap == 0){
            return 0;
        }
        if(dp[n][buy][cap]!=-1){
            return dp[n][buy][cap];
        }

        if(buy==1){
            profit = Math.max(-prices[n]+helper(prices,n+1,0,cap,profit,dp),0+helper(prices,n+1,1,cap,profit,dp));
        }else{
            profit= Math.max(prices[n]+helper(prices,n+1,1,cap-1,profit,dp),0+helper(prices,n+1,0,cap,profit,dp));
        }
        return dp[n][buy][cap]=profit;
    }
}