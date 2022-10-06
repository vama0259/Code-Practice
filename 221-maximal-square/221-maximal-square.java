class Solution {
    int max = 0;
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        solve(matrix, 0,0, dp);
        return max*max;
    }
    public int solve(char[][] matrix, int x, int y, int[][] dp){
        if(x>= matrix.length || y>= matrix[0].length){
            return 0;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        int right = solve(matrix, x, y+1,dp); 
        int down = solve(matrix, x+1, y,dp);
        int diag = solve(matrix, x+1, y+1,dp);
        
        if(matrix[x][y] == '1'){
            int ans = 1 + Math.min(right, Math.min(down, diag));
            max = Math.max(max, ans);
            return dp[x][y] = ans;
        }
        else{
            return 0;
        }
            
    }
}