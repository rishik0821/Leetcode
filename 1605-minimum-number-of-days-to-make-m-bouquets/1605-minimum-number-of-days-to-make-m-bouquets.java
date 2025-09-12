class Solution {
        boolean ispossible(int[] arr, int day, int m, int k){
            int n = arr.length;
            int count=0;
            int total=0;
            for(int i=0;i<n;i++){
                if(arr[i]<=day){
                    count++;
                }else{
                    total+= count/k;
                    count=0;
                }
            }

            total+=count/k;
            return total>=m;
        }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        long x = (long) m*k;
        if(x>n){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]);
        }
        int ans = max;
        int low = min;
        int high = max;
        while(low<=high){
            int mid = (low+high)/2;
            if(ispossible(bloomDay,mid,m,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}