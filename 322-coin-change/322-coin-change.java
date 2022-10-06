class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[] = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
       //int ans = solve(coins, amount, dp);
        dp[0] = 0;
        
        for(int i =1; i <= amount; i++){
            for(int j =0; j < coins.length; j++){
                if(coins[j] <= i && dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] +1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return dp[amount];
        }
    }
//     public int solve(int[] coins, int n, int dp[]){
//         if(n==0){
//             return 0;
//         }
//         if(n<0){
//             return Integer.MAX_VALUE;
//         }
//         if(dp[n] !=  Integer.MAX_VALUE){
//             return dp[n];
//         }
//         int min = Integer.MAX_VALUE;
//         for(int i =0; i < coins.length; i++){
//             int ans = solve(coins, n-coins[i], dp);
//             if(ans != Integer.MAX_VALUE){
//                 min = Math.min(min, ans+1);
//             }
//         }
        
//         return dp[n] = min;
//     }
}