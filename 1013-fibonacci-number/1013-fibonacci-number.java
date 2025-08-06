class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return bck(n,dp);
        
    }
    int bck(int n, int[] dp ){
        if(n<=1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=bck(n-1,dp)+bck(n-2,dp);
    }
}