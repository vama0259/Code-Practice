class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        
        return solve(values, 0, values.length - 1, dp);
    }
    
    public int solve(int v[], int i, int j, int dp[][]){
        if(i+1 == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            ans = Math.min(ans, (v[i] * v[j] * v[k]) + solve(v, i , k, dp) + solve(v, k,j, dp));
        }
        
        return dp[i][j] = ans;
    } 
}