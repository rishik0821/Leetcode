class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] x: dp){
            Arrays.fill(x,-1);
        }
        return helper(amount,coins,n-1,dp);
    }
    int helper(int amount, int[] coins, int n , int[][] dp){
        if(n==0){
            if(amount%coins[0]==0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }
        int ntake = 0+ helper(amount,coins,n-1,dp);
        int take = 0;
        if(coins[n]<=amount){
            take =helper(amount-coins[n],coins,n,dp);
        }
        return dp[n][amount]=take+ntake;
    }
}