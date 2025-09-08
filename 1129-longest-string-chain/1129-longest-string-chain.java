class Solution {

    boolean commp(String s1,String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first =0;
        int second = 0;
        while(first<s1.length()){
            if(second<s2.length()&&s1.charAt(first)==s2.charAt(second)){
                first++;
                second++;
            }
            else{
                first++;
            }
        }
        return first==s1.length()&&second == s2.length();
    }
    public int longestStrChain(String[] words) {
        int n = words.length;
         Arrays.sort(words, Comparator.comparingInt(String::length));
         int dp[] = new int[n];
         Arrays.fill(dp,1);
         for(int i=0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(commp(words[i],words[prev])&&1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }

         }
         int ans =-1;
         for(int i=0;i<n;i++){
            if(dp[i]>ans){
                ans=dp[i];
            }
         }

         return ans;
    }
}