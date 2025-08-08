class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[]x:dp){
            Arrays.fill(x,-1);
        }
        return helper(grid,m-1,n-1,dp);
    }
    public int helper(int[][] grid, int i, int j,int[][] dp){
        if(i==0&&j==0){
            return grid[0][0];
        }if(i<0||j<0){
            return (int)Math.pow(10,9);
        }if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up = grid[i][j]+helper(grid,i-1,j,dp);
        int left = grid[i][j]+helper(grid,i,j-1,dp);
        return dp[i][j] = Math.min(left,up);
    }
}