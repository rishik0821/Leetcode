class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int dp[] = new int[n];
        int[] hash =  new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(hash,1);
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0&& 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                    hash[i]=prev;
                }
            }
        }

        int ans=-1;
        int last =-1;
        for(int i=0;i<n;i++){
            if(dp[i]>ans){
                ans=dp[i];
                last=i;
            }

        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[last]);
        while(hash[last]!=last){
            last = hash[last];
            temp.add(nums[last]);
        }
        
        Collections.reverse(temp);
        return temp;
    }
}