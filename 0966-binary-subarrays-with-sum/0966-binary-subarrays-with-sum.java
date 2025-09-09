class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return func(nums,goal)-func(nums,goal-1);
    }
    int func(int nums[], int goal){
        int n = nums.length;
        int l=0,r=0,sum=0,count=0;
        while(r<n){
            sum+=nums[r];
            while(sum>goal&&r>=l){
                sum=sum-nums[l];
                l++;
            }
            count = count+(r-l+1);
            r++;
        }
        return count;
    }
}