class Solution {
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[4][obstacles.length];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return solve(obstacles, 2, 0, dp);
    }
    
    public int solve(int[] o, int x, int y, int[][] dp){
        
        int n = o.length - 1;
        if(y == n){
            return 0;
        }
        
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        
        if(o[y+1] != x){
            return dp[x][y] = solve(o, x, y+1, dp);
        }
        else{
            int ans = Integer.MAX_VALUE;
            for(int i =1; i <= 3; i++){
                if(i != x && o[y] != i)
                    ans = Math.min(ans, 1 + solve(o, i, y, dp));
            }
            return dp[x][y] = ans;
        }
        
    }
}