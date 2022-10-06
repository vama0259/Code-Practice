class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length+1];
        Arrays.fill(dp, -1);
        return solve(days, costs, 0, dp);
    }
    
    public int solve(int[] days, int[] costs, int index, int[] dp){
        if(index>=days.length){
            return 0;
        }
        
        if(dp[index] != -1){
            return dp[index];
        }
        
        //1 day 
        int a1 = solve(days, costs, index+1, dp) + costs[0];
        int i;
        //7-day
        for(i = index; i < days.length && days[i] < days[index]+7; i++);
        
        int a2 = solve(days, costs, i, dp) + costs[1];
        
        //30 days
        
        for(i =index; i < days.length && days[i] < days[index] + 30; i++);
        
        int a3 = solve(days, costs, i, dp) + costs[2];
        
        
        return dp[index] = Math.min(a1, Math.min(a2,a3));
    }
}