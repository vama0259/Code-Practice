class Solution {
    public int maxProfit(int k, int[] p) {
        int n = p.length;
        if (k >= n / 2) k = n / 2;
        if(n == 0 || k == 0) return 0;
        int[][] dp = new int[2][n];
        for(int t=1; t <= k; t++){
            int max = -Integer.MAX_VALUE;
            for(int d=1; d < n; d++){
                max = Math.max(max, dp[0][d-1]-p[d-1]);
                dp[1][d] = Math.max(dp[1][d-1], max+p[d]);
            }
            dp[0] = Arrays.copyOf(dp[1], n);
        }
        return dp[1][n-1];
    }
}