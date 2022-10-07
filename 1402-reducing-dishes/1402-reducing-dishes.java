class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        int dp[][] = new int[n][n];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        Arrays.sort(satisfaction);
        return solve(satisfaction, 0, 0, dp);
    }
    
    public int solve(int[] s , int index, int time, int dp[][]){
        if(index == s.length){
            return 0;
        }
        if(dp[index][time] != -1){
            return dp[index][time];
        }
        int a = s[index]*(time+1) + solve(s, index+1, time+1, dp);
        int b = solve(s, index+1, time, dp);
        
        
        return dp[index][time] = Math.max(a,b);
    }
}