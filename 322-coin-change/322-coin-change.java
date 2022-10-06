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
}