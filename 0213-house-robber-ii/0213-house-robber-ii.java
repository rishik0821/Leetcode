class Solution {
    public int rob(int[] nums) {
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length;i++){
            if(i!=0){
                n1.add(nums[i]);
            }
            if(i!=nums.length-1){
                n2.add(nums[i]);
            }

        }
        int x = solve(n1);
        int y = solve(n2);
        return Math.max(x,y);

    }

    public int solve(List<Integer> nums){
        int n = nums.size();
        if(n==0){
            return 0;
        }
            if(n==1){
                return nums.get(0);
            }
            if(n==2){
                return Math.max(nums.get(0),nums.get(1));
            }
            int dp[]=new int[n];
            dp[0]=nums.get(0);
            dp[1]=Math.max(nums.get(0),nums.get(1));
            for(int i=2;i<n;i++){
               
                int take = nums.get(i)+dp[i-2];
                int non = dp[i-1];
                dp[i]=Math.max(take,non);
            }
        
        return dp[n-1];

    }
}