class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int[]x:dp){
            Arrays.fill(x,-1);
        }
        int ans = helper(coins,amount,n-1,dp);
          return ans >= (int)1e9 ? -1 : ans;
    }

    int helper(int[] coins, int amount, int n,int[][] dp){
        if(n==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return (int) Math.pow(10,9);
            }
        }
        if(dp[n][amount]!=-1){
            return dp[n][amount];
        }

        int ntake = 0+helper(coins,amount,n-1,dp);
        int take = Integer.MAX_VALUE;
        if(coins[n]<=amount){
            take = 1+helper(coins,amount-coins[n],n,dp);
        }
        return dp[n][amount]=Math.min(take,ntake);
    }

}