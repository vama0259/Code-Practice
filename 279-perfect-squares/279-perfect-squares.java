class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i =1; i <=n; i++){
            int min = Integer.MAX_VALUE;
            for(int j =1; j*j <=i; j++){
                min = Math.min(min, dp[i-(j*j)]);
            }
            dp[i] = min+1;
        }
        return dp[n];
    }
//     public int solve(int n, int[] dp){
//         if(n<0) return Integer.MAX_VALUE;  //Taking min later on
//         if(n==0) return 0;
//         if(dp[n]!=Integer.MAX_VALUE){
//             return dp[n];
//         }
        
//         int min=n;
        
//         for(int i=1;i*i<=n;i++){
//             min=Math.min(min,solve(n-(i*i), dp)+1);
//         }
//         return dp[n] = min;
}