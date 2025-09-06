class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return helper(nums,0,-1,dp);
    }
    int helper(int[] nums, int i,int prev, int[][] dp){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][prev+1]!=-1){
            return dp[i][prev+1];
        }

        int len = 0+helper(nums,i+1,prev,dp);
        
        if(prev==-1||nums[i]>nums[prev]){
            len = Math.max(len,1 +helper(nums,i+1,i,dp));
        }

       return dp[i][prev+1]=len;
    }
}