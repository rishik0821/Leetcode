class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
       if ((sum - target) < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        
        int x = (sum-target)/2;
        int[][] dp = new int[n][x+1];
        for(int[] y:dp){
            Arrays.fill(y,-1);
        }

        return helper(nums,n-1,x,dp);

    }

    int helper(int[] nums, int n, int target, int[][] dp){
        if(n==0){
            if(target==0&&nums[0]==0){
                return 2;
            }
            if(target==0||nums[0]==target){
                return 1;
            }
        }
        if(n<0){
            return 0;
        }
        if(dp[n][target]!=-1){
            return dp[n][target];

        }
        int ntake = helper(nums,n-1,target,dp);
        int take =0;
        if(nums[n]<=target){
            take = helper(nums,n-1,target-nums[n],dp);
        }

        return dp[n][target]=take+ntake;
    }
}