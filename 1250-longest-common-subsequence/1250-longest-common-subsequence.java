class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[]x:dp){
            Arrays.fill(x,-1);
        }
        return helper(0,0,text1,text2,dp);
    }

    int helper(int n1, int n2, String s1, String s2, int[][] dp){
        if(n1>=s1.length()||n2>=s2.length()){
            return 0;
        }
        if(dp[n1][n2]!=-1){
            return dp[n1][n2];
        }
        if(s1.charAt(n1)==s2.charAt(n2)){
            return dp[n1][n2]= 1+helper(n1+1,n2+1,s1,s2,dp);
        }else{
            return dp[n1][n2]= Math.max(helper(n1+1,n2,s1,s2,dp),helper(n1,n2+1,s1,s2,dp));
        }
    }
}