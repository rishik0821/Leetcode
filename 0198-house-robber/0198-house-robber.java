class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,nums.length-1,dp);
        
    }
    int helper(int[] arr, int n , int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return arr[n];
        }
        if(n==1){
           return Math.max(arr[0],arr[1]);
        }
        if(dp[n]!=-1){
            return dp[n];
        }
       int pick = arr[n]+helper(arr,n-2,dp);
       int non = helper(arr,n-1,dp);
       return dp[n]=Math.max(pick,non);
    }
}