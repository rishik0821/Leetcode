class Solution {
    public int maxProfit(int k, int[] prices) {
         int n = prices.length;
        
        int[][][] dp = new int[n][2][k+1];
        for (int[][] x : dp) {
            for (int[] y : x) {
                Arrays.fill(y, -1);
            }
        }
        return helper(prices, 0, 1, k, dp);
    }
    int helper(int[] prices, int day, int buy, int cap, int[][][] dp) {
        if (day == prices.length || cap == 0) {
            return 0; 
        }
        if (dp[day][buy][cap] != -1) {
            return dp[day][buy][cap];
        }

        int profit;
        if (buy == 1) {
            
            profit = Math.max(-prices[day] + helper(prices, day + 1, 0, cap, dp),
                               0 + helper(prices, day + 1, 1, cap, dp));
        } else {
          
            profit = Math.max(prices[day] + helper(prices, day + 1, 1, cap - 1, dp),
                               0 + helper(prices, day + 1, 0, cap, dp));
        }

        return dp[day][buy][cap] = profit;
    }

}