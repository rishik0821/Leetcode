class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        return helper(m,n,dp,0,0,obstacleGrid);
        
    }
    int helper(int m, int n ,int[][] dp, int i, int j,int[][] grid){
        if(i>m-1||j>n-1){
            return 0;
        }
        if(grid[i][j]==1){
            return 0;
        }
        else if(i==m-1&&j==n-1){
            return 1;
        }
        else if(dp[i][j]!=-1){
            return dp[i][j];
        }else{
            return dp[i][j]=helper(m,n,dp,i+1,j,grid)+helper(m,n,dp,i,j+1,grid);
        }
    }
}