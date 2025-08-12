class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
       
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
         int dp[][] = new int[n][sum+1];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        if(sum%2!=0){
            return false;
        }else{
            return helper(nums,n-1,sum/2,dp);
        }
        
    }

    public boolean helper(int[] arr, int n , int target,int[][] dp){
        if(target==0){
            return true;
        }
        if(n==0){
            return arr[0]==target;
        }
        if(dp[n][target]!=-1){
            if(dp[n][target]==0){
                return false;
            }else{
                return true;
            }
        }

        boolean ntake = helper(arr,n-1,target,dp);
        boolean take = false;
        if(arr[n]<=target){
            take = helper(arr,n-1,target-arr[n],dp);
        }

        dp[n][target]=take||ntake ? 1:0;

        return take||ntake;
    }
}