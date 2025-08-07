class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0) list1.add(nums[i]);
            if(i!=nums.length-1) list2.add(nums[i]);
        }
    return Math.max(recursion(list1, dp, nums.length-2), recursion(list2, dp, nums.length-2));
    }
    public int recursion(List<Integer> nums, int[] dp, int ind){
        if(ind==0) return nums.get(0);
        if(ind==1) return Math.max(nums.get(0), nums.get(1));
        dp[0] = nums.get(0);
        dp[1] = Math.max(nums.get(0), nums.get(1));
        for(int i=2;i<nums.size();i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums.get(i));
        }
    return dp[ind];
    }
}